package shift.santa.features.books.domain

import shift.santa.features.books.domain.model.Creator
import shift.santa.features.books.domain.model.Group
import shift.santa.features.books.domain.model.Success
import shift.santa.network.Carry

interface CreatorRepository {

    fun loadCreator(carry: Carry<List<Creator>>)

    fun loadCreator(id: Long, carry: Carry<Creator>)

    fun createCreator(user: Creator, carry: Carry<Creator>)

    fun deleteCreator(id: Long, carry: Carry<Success>)
}