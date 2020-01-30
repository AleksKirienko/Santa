package shift.santa.features.books.domain

import shift.santa.features.books.domain.model.Group
import shift.santa.features.books.domain.model.Success
import shift.santa.network.Carry

interface BooksRepository {

    fun loadGroups(carry: Carry<List<Group>>)

    fun loadGroup(id: Long, carry: Carry<Group>)

    fun createGroup(name: String, count: Int, id: Long, carry: Carry<String>)

    fun deleteGroup(id: Long, carry: Carry<Success>)
}