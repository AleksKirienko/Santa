package shift.santa.features.groupList

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import shift.santa.GivePresentActivity
import shift.santa.R
import shift.santa.features.BaseActivity
import shift.santa.features.MvpPresenter
import shift.santa.features.books.domain.model.Creator
import shift.santa.features.books.domain.model.Group
import shift.santa.features.books.presentation.BookListPresenter
import shift.santa.features.books.presentation.BookListView
import shift.santa.features.books.presentation.PresenterFactory

class GroupListActivity : BaseActivity<GroupListView>(), GroupListView {

    private var selectedIDGroup: Long = 0
    private var recyclerView: RecyclerView? = null
    private var adapter: GroupListAdapter? = null
    private var presenter: GroupListPresenter? = null
    private var progressBar: ProgressBar? = null

    companion object {
        val SELECTED_GROUP: String? = null
    }

    override fun getMvpView(): GroupListView {
        return this
    }

    override fun getMvpPresenter(): MvpPresenter<GroupListView> {
        presenter = PresenterFactory.createGroupPresenter(this)
        return presenter!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_list)
        selectedIDGroup = intent.getLongExtra(SELECTED_GROUP, 0)

        initView()
    }

    private fun initView() {
        recyclerView = findViewById(R.id.group_recycle_view)

        adapter = GroupListAdapter(this, object : GroupListAdapter.SelectUserListener {

            override fun onUserSelect(user: Creator) {

            }

            override fun onUserLongClick(user: Creator) {

            }
        })

        recyclerView!!.adapter = adapter
        recyclerView!!.layoutManager = LinearLayoutManager(this)
    }

    override fun showProgress() {
        recyclerView!!.visibility = View.GONE
    }

    override fun hideProgress() {
        recyclerView?.visibility = View.VISIBLE
    }

    override fun showUserList(list: List<Creator>) {
        adapter!!.setUsers(list)
    }

    override fun showError(message: String?) {
        Toast.makeText(this, message ?: "", Toast.LENGTH_LONG).show()
    }

    override fun getGroupID(): Long
    {
        return selectedIDGroup
    }
}
