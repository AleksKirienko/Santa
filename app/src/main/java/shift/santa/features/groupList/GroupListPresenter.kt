package shift.santa.features.groupList

import shift.santa.features.MvpPresenter
import shift.santa.features.books.domain.BooksRepository
import shift.santa.features.books.domain.CreatorRepository
import shift.santa.features.books.domain.model.Creator
import shift.santa.network.Carry

internal class GroupListPresenter(private val userRepository: CreatorRepository, private val booksRepository: BooksRepository) :
    MvpPresenter<GroupListView>() {

    override fun onViewReady() {
        val groupID = view!!.getGroupID()
        loadUsers(groupID)
    }

    fun loadUsers(groupID: Long) {
        //view?.showProgress()
        booksRepository.getGroupMembers(groupID, object : Carry<List<Creator>> {

            override fun onSuccess(result: List<Creator>) {
                view?.showUserList(result)
                //view?.hideProgress()
            }

            override fun onFailure(throwable: Throwable) {
                //view?.hideProgress()
                view?.showError(throwable.message)
            }

        })
    }
}