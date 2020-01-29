package shift.santa.features.books.data

import shift.santa.features.books.domain.BooksRepository
import shift.santa.features.books.domain.model.Book
import shift.santa.features.books.domain.model.Group
import shift.santa.features.books.domain.model.Success
import shift.santa.network.Carry
import shift.santa.network.DefaultCallback

class BooksRepositoryImpl(private val groupApi: GroupApi) : BooksRepository {

    override fun loadGroups(carry: Carry<List<Group>>) {
        groupApi.getGroup().enqueue(DefaultCallback(carry))
    }

    override fun loadBook(id: String, carry: Carry<Book>) {
        groupApi.getBook(id).enqueue(DefaultCallback(carry))
    }

    override fun createBook(book: Book, carry: Carry<Book>) {
        groupApi.createBook(book).enqueue(DefaultCallback(carry))
    }

    override fun deleteBook(id: String, carry: Carry<Success>) {
        groupApi.deleteBook(id).enqueue(DefaultCallback(carry))
    }

}