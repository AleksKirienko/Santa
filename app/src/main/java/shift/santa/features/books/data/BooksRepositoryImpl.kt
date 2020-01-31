package shift.santa.features.books.data

import shift.santa.features.books.domain.BooksRepository
import shift.santa.features.books.domain.model.Group
import shift.santa.features.books.domain.model.Success
import shift.santa.network.Carry
import shift.santa.network.DefaultCallback
import shift.santa.features.books.domain.model.Creator

class BooksRepositoryImpl(private val groupApi: GroupApi) : BooksRepository {

    override fun loadGroups(carry: Carry<List<Group>>) {
        groupApi.getGroup().enqueue(DefaultCallback(carry))
    }

    override fun loadGroup(id: Long, carry: Carry<Group>) {
        groupApi.getGroup(id).enqueue(DefaultCallback(carry))
    }

    override fun createGroup(name: String, count: Int, id: Long, carry: Carry<String>) {
        groupApi.createGroup(name, count, id).enqueue(DefaultCallback(carry))
    }

    override fun deleteGroup(id: Long, carry: Carry<Success>) {
        groupApi.deleteGroup(id).enqueue(DefaultCallback(carry))
    }

    override fun getGroupMembers(group_id: Long, carry : Carry<List<Creator>>) {
        groupApi.getGroupMembers(group_id).enqueue(DefaultCallback(carry))
    }
}