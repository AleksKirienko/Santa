package shift.santa.features.books.presentation

import java.util.concurrent.atomic.AtomicInteger

import shift.santa.features.MvpPresenter
import shift.santa.features.books.domain.BooksRepository
import shift.santa.features.books.domain.model.Book
import shift.santa.features.books.domain.model.Group
import shift.santa.network.Carry

/**
 * Created: samokryl
 * Date: 02.07.18
 * Time: 0:43
 */

internal class BookListPresenter(private val booksRepository: BooksRepository) :
    MvpPresenter<BookListView>() {

    override fun onViewReady() {
        loadBooks()
    }

    private fun loadBooks() {
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


    fun onCreateBookClicked() {

    }
}