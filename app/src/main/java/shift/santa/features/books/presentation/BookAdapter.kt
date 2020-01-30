package shift.santa.features.books.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import java.util.ArrayList

import shift.santa.R
import shift.santa.features.books.domain.model.Group

/**
 * Created: samokryl
 * Date: 02.07.18
 * Time: 0:24
 */

internal class BookAdapter(context: Context, private val selectBookListener: SelectBookListener) :
    RecyclerView.Adapter<BookAdapter.BookHolder>() {

    private val books = ArrayList<Group>()
    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val itemView = inflater.inflate(R.layout.book_item, parent, false)
        return BookHolder(itemView, selectBookListener)
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int {
        return books.size
    }

    fun setBooks(bookList: List<Group>) {
        books.clear()
        books.addAll(bookList)
        notifyDataSetChanged()
    }

    internal inner class BookHolder(
        view: View,
        private val selectBookListener: SelectBookListener
    ) : RecyclerView.ViewHolder(view) {

        private val bookNameView: TextView

        init {
            bookNameView = view.findViewById(R.id.book_item_name)

        }

        fun bind(book: Group) {
            bookNameView.setText(book.name)

            itemView.setOnClickListener { selectBookListener.onBookSelect(book) }

        }

    }

    internal interface SelectBookListener {

        fun onBookSelect(book: Group)

    }

}
