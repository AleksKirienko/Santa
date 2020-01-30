package shift.santa.features.books.presentation


import shift.santa.features.MvpView
import shift.santa.features.books.domain.model.Group

/**
 * Created: samokryl
 * Date: 02.07.18
 * Time: 0:22
 */

interface BookListView : MvpView {

    fun showProgress()

    fun hideProgress()

    fun showBookList(list: List<Group>)

    fun showError(message: String?)

    fun openActivity(name: String, likes: String, dislikes: String)

}
