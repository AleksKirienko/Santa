package shift.santa.features.books.presentation


import shift.santa.features.MvpView
import shift.santa.features.books.domain.model.Group

interface BookListView : MvpView {

    fun showProgress()

    fun hideProgress()

    fun showBookList(list: List<Group>)

    fun showError(message: String?)

    fun openActivity(name: String, likes: String, dislikes: String)

}
