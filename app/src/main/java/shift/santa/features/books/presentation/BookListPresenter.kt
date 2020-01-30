package shift.santa.features.books.presentation

import java.util.concurrent.atomic.AtomicInteger

import shift.santa.features.MvpPresenter
import shift.santa.features.books.domain.BooksRepository
import shift.santa.features.books.domain.CreatorRepository
import shift.santa.features.books.domain.model.Group
import shift.santa.features.books.domain.model.Creator
import shift.santa.network.Carry

internal class BookListPresenter(private val userRepository: CreatorRepository, private val booksRepository: BooksRepository) :
    MvpPresenter<BookListView>() {

    private val atomicInteger = AtomicInteger()

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

    fun onCreateBookClicked() {
        val id = atomicInteger.incrementAndGet()
        /*val name = ActivityTwo::fieldName

        val group = Group(
            1, Creator(
                ActivityTwo::fieldDislikes.toString(),
                17, ActivityTwo::fieldLikes.toString(),
                ActivityTwo::fieldName.toString()
            ),
            id, name.toString()
        )*/
        val name = "Name"

        val cr = Creator(
            "Dis",
            17, "Name",
            "Like")
//        val group = Group(
//            77, 7, "ll"
//        )
//        booksRepository.createGroup(group, object : Carry<Group> {
//            override fun onSuccess(result: Group) {
//                loadBooks()
//            }
//
//            override fun onFailure(throwable: Throwable) {
//                view!!.showError(throwable.message)
//            }
//        })
    }
}