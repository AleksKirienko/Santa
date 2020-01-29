package shift.santa.features.books.domain

import shift.santa.features.books.domain.model.Book
import shift.santa.features.books.domain.model.Group
import shift.santa.features.books.domain.model.Success
import shift.santa.network.Carry

/**
 * Created: samokryl
 * Date: 01.07.18
 * Time: 22:49
 */

interface BooksRepository {

    fun loadGroups(carry: Carry<List<Group>>)

    fun loadBook(id: String, carry: Carry<Book>)

    fun createBook(book: Book, carry: Carry<Book>)

    fun deleteBook(id: String, carry: Carry<Success>)
}