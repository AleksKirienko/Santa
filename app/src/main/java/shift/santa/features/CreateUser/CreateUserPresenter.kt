package shift.santa.features.CreateUser

import shift.santa.features.MvpPresenter
import shift.santa.features.activitytwo.TwoView
import shift.santa.features.books.domain.BooksRepository
import shift.santa.features.books.domain.CreatorRepository
import shift.santa.features.books.domain.model.Creator
import shift.santa.network.Carry

class CreateUserPresenter(private val repository: CreatorRepository) : MvpPresenter<CreateUserView>() {

    fun onClick(name: String, likes: String, dislikes: String) {
        val user = Creator(name, likes, dislikes)
        repository.createCreator(user, object : Carry<Creator> {
            override fun onSuccess(result: Creator) {
                view!!.goBackSuccess()

            }

            override fun onFailure(throwable: Throwable) {
                view!!.showError(throwable.message ?: " ")
            }
        })
    }
}