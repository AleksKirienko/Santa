package shift.santa.features.activitytwo

import shift.santa.features.MvpPresenter
import shift.santa.features.books.domain.BooksRepository
import shift.santa.features.books.domain.model.Group
import shift.santa.network.Carry

class TwoPresenter(private val repository: BooksRepository) : MvpPresenter<TwoView>() {




    fun onClick(name: String, countPeople: Int, userId: Long) {
        repository.createGroup(name, countPeople, userId, object : Carry<String> {
            override fun onSuccess(result: String) {
                view!!.goBackSuccess()

            }

            override fun onFailure(throwable: Throwable) {
                view!!.showError(throwable.message ?: " ")
            }
        })
    }
}