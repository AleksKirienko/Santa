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

    override fun loadGroup(id: String, carry: Carry<Group>) {
        groupApi.getGroup(id).enqueue(DefaultCallback(carry))
    }

    override fun createGroup(group: Group, carry: Carry<Group>) {
        groupApi.createGroup(group).enqueue(DefaultCallback(carry))
    }

    override fun deleteGroup(id: String, carry: Carry<Success>) {
        groupApi.deleteGroup(id).enqueue(DefaultCallback(carry))
    }

}