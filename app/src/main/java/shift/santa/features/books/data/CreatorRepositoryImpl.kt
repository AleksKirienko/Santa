package shift.santa.features.books.data

import shift.santa.features.books.domain.CreatorRepository
import shift.santa.features.books.domain.model.Creator
import shift.santa.features.books.domain.model.Success
import shift.santa.network.Carry
import shift.santa.network.DefaultCallback

class CreatorRepositoryImpl(private val creatorApi: CreatorApi) : CreatorRepository {

    override fun loadCreator(carry: Carry<List<Creator>>) {
        creatorApi.getCreator().enqueue(DefaultCallback(carry))
    }

    override fun createCreator(user: Creator, carry: Carry<Creator>) {
        creatorApi.createCreator(user).enqueue(DefaultCallback(carry))
    }

    override fun deleteCreator(id: Long, carry: Carry<Success>) {
        creatorApi.deleteCreator(id).enqueue(DefaultCallback(carry))
    }

    override fun loadCreator(id: Long, carry: Carry<Creator>) {
        creatorApi.getCreator(id).enqueue(DefaultCallback(carry))
    }
}