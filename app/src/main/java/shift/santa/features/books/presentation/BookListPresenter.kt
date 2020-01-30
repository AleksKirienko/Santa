package shift.santa.features.books.presentation

import shift.santa.features.MvpPresenter
import shift.santa.features.books.domain.BooksRepository
import shift.santa.features.books.domain.CreatorRepository
import shift.santa.features.books.domain.model.Group
import shift.santa.features.books.domain.model.Creator
import shift.santa.features.books.domain.model.Success
import shift.santa.network.Carry

internal class BookListPresenter(private val userRepository: CreatorRepository, private val booksRepository: BooksRepository) :
    MvpPresenter<BookListView>() {

    override fun onViewReady() {
        loadBooks()
    }

    fun loadBooks() {
        view?.showProgress()
        booksRepository.loadGroups(object : Carry<List<Group>> {

            override fun onSuccess(result: List<Group>) {
                view?.showBookList(result)
                view?.hideProgress()
            }

            override fun onFailure(throwable: Throwable) {
                view?.hideProgress()
                view?.showError(throwable.message)
            }

        })
    }

    fun loadUsers() {
        view?.showProgress()
        booksRepository.loadGroups(object : Carry<List<Group>> {

            override fun onSuccess(result: List<Group>) {
                view?.hideProgress()
                onBookSelected(result.shuffled().first())
            }

            override fun onFailure(throwable: Throwable) {
                view?.hideProgress()
                view?.showError(throwable.message)
            }
        })
    }

    fun onBookSelected(group: Group) {
        view!!.showProgress()
        booksRepository.loadGroup(group.id, object : Carry<Group> {

            override fun onSuccess(result: Group) {
                view!!.hideProgress()

                userRepository.loadCreator(result.id, object : Carry<Creator> {
                    override fun onSuccess(result: Creator) {
                        view?.openActivity(result.name, result.likes, result.dislikes)
                    }

                    override fun onFailure(throwable: Throwable) {
                        view!!.hideProgress()
                        view!!.showError(throwable.message)
                    }
                })
            }

            override fun onFailure(throwable: Throwable) {
                view!!.hideProgress()
                view!!.showError(throwable.message)
            }

        })
    }

    fun onBookLongClicked(group: Group) {
        view!!.showProgress()
        booksRepository.deleteGroup(group.id, object : Carry<Success> {

            override fun onSuccess(result: Success) {
                loadBooks()
            }

            override fun onFailure(throwable: Throwable) {
                view!!.hideProgress()
                view!!.showError(throwable.message)
            }
        })
    }
}