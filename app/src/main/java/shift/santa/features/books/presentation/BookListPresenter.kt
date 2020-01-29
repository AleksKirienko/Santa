package shift.santa.features.books.presentation

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import shift.santa.ActivityThree
import shift.santa.ActivityTwo
import java.util.concurrent.atomic.AtomicInteger

import shift.santa.features.MvpPresenter
import shift.santa.features.books.domain.BooksRepository
import shift.santa.features.books.domain.model.Group
import shift.santa.features.books.domain.model.Creator
import shift.santa.features.books.domain.model.Success
import shift.santa.network.Carry

/**
 * Created: samokryl
 * Date: 02.07.18
 * Time: 0:43
 */

internal class BookListPresenter(private val booksRepository: BooksRepository) :
    MvpPresenter<BookListView>() {

    private val atomicInteger = AtomicInteger()

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
        val group = Group(
            1, cr, id, name
        )
        booksRepository.createGroup(group, object : Carry<Group> {
            override fun onSuccess(result: Group) {
                loadBooks()
            }

            override fun onFailure(throwable: Throwable) {
                view!!.showError(throwable.message)
            }
        })
    }
}