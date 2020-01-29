package shift.santa.features.books.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import shift.santa.ActivityThree
import shift.santa.ActivityTwo

import shift.santa.R
import shift.santa.features.BaseActivity
import shift.santa.features.MvpPresenter
import shift.santa.features.MvpView
import shift.santa.features.books.domain.model.Book
import shift.santa.features.books.domain.model.Group

class BookActivity : BaseActivity<BookListView>(), BookListView {

    private var progressBar: ProgressBar? = null
    private var recyclerView: RecyclerView? = null
    private var createBookButton: Button? = null
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

        createBookButton!!.setOnClickListener { presenter!!.onCreateBookClicked() }

        adapter = BookAdapter(this, object : BookAdapter.SelectBookListener {

            override fun onBookSelect(book: Group) {
                //new activity 3 page for id group
                val intentEx = group_selection(true)
                startActivity(intentEx)
            }

        })

        recyclerView!!.adapter = adapter
        recyclerView!!.layoutManager = LinearLayoutManager(this)
    }
    private fun group_selection(isCreator: Boolean): Intent {
        val intent = Intent(this, ActivityThree::class.java)
        intent.putExtra(ActivityThree.IS_GROUP_CREATOR, isCreator)
        return intent
    }

    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
        recyclerView!!.visibility = View.GONE
    }

    override fun hideProgress() {
        progressBar!!.visibility = View.GONE
        recyclerView!!.visibility = View.VISIBLE
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

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, BookActivity::class.java)
            context.startActivity(intent)
        }
    }
}
