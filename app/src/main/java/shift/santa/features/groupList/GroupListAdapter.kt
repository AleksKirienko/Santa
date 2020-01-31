package shift.santa.features.groupList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import java.util.ArrayList

import shift.santa.R
import shift.santa.features.books.domain.model.Creator

internal class GroupListAdapter(context: Context, private val selectUserListener: SelectUserListener) :
    RecyclerView.Adapter<GroupListAdapter.UserHolder>() {

    private val users = ArrayList<Creator>()
    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val itemView = inflater.inflate(R.layout.book_item, parent, false)
        return UserHolder(itemView, selectUserListener)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun setUsers(userList: List<Creator>) {
        users.clear()
        users.addAll(userList)
        notifyDataSetChanged()
    }

    internal inner class UserHolder(
        view: View,
        private val selectUserListener: SelectUserListener
    ) : RecyclerView.ViewHolder(view) {

        private val userNameView: TextView

        init {
            userNameView = view.findViewById(R.id.book_item_name)

        }

        fun bind(user: Creator) {
            userNameView.setText(user.name)

            itemView.setOnClickListener { selectUserListener.onUserSelect(user) }

        }

    }

    internal interface SelectUserListener {

        fun onUserSelect(user: Creator)

        fun onUserLongClick(user: Creator)

    }
}