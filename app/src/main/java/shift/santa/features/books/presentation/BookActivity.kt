package shift.santa.features.books.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import shift.santa.GivePresentActivity

import shift.santa.R
import shift.santa.features.BaseActivity
import shift.santa.features.MvpPresenter
import shift.santa.features.activitytwo.ActivityTwo
import shift.santa.features.books.domain.model.Group

class BookActivity : BaseActivity<BookListView>(), BookListView {

    private companion object {

        const val ACTIVITY_TWO_REQUEST_CODE = 111
    }

    private var progressBar: ProgressBar? = null
    private var recyclerView: RecyclerView? = null
    private var createBookButton: Button? = null
    private var getRandomUserButton: Button? = null
    private var adapter: BookAdapter? = null
    private var presenter: BookListPresenter? = null


    override fun getMvpView(): BookListView {
        return this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.books_activity)

        initView()
    }

    private fun initView() {
        progressBar = findViewById(R.id.books_progress)
        recyclerView = findViewById(R.id.books_recycle_view)
        createBookButton = findViewById(R.id.create_button)
        getRandomUserButton = findViewById(R.id.button2)

        createBookButton!!.setOnClickListener {
            startActivityForResult(Intent(this, ActivityTwo::class.java), ACTIVITY_TWO_REQUEST_CODE)
        }

        getRandomUserButton!!.setOnClickListener { presenter!!.loadUsers()}

        adapter = BookAdapter(this, object : BookAdapter.SelectBookListener {

            override fun onBookSelect(group: Group) {

                presenter!!.onBookSelected(group)
                //new activity 3 page for id group
            }
            override fun onBookLongClick(group: Group) {
                presenter!!.onBookLongClicked(group)
            }
        })

        recyclerView!!.adapter = adapter
        recyclerView!!.layoutManager = LinearLayoutManager(this)
    }

    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
        recyclerView!!.visibility = View.GONE
    }

    override fun hideProgress() {
        progressBar?.visibility = View.GONE
        recyclerView?.visibility = View.VISIBLE
    }

    override fun showBookList(list: List<Group>) {
        adapter!!.setBooks(list)
    }

    override fun showError(message: String?) {
        Toast.makeText(this, message ?: "", Toast.LENGTH_LONG).show()
    }

    override fun getMvpPresenter(): MvpPresenter<BookListView> {
        presenter = PresenterFactory.createPresenter(this)
        return presenter!!
    }

    override fun openActivity(name: String, likes: String, dislikes: String) {
        val intent = Intent(this, GivePresentActivity::class.java)

        intent.putExtra(GivePresentActivity.NAME, name)
        intent.putExtra(GivePresentActivity.LIKES, likes)
        intent.putExtra(GivePresentActivity.DISLIKES, dislikes)

        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ACTIVITY_TWO_REQUEST_CODE && resultCode == RESULT_OK) {
               presenter?.loadBooks()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
