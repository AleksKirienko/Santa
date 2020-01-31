package shift.santa.features.groupList

import shift.santa.features.MvpView
import shift.santa.features.books.domain.model.Creator

interface GroupListView : MvpView {

    fun showError(message: String?)

    fun showUserList(list: List<Creator>)

    fun showProgress()

    fun hideProgress()

    fun getGroupID(): Long
}