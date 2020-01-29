package shift.santa.features.books.domain

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

    fun loadGroup(id: String, carry: Carry<Group>)

    fun createGroup(group: Group, carry: Carry<Group>)

    fun deleteGroup(id: String, carry: Carry<Success>)
}