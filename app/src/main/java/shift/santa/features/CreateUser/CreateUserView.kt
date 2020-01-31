package shift.santa.features.CreateUser

import shift.santa.features.MvpView

interface CreateUserView : MvpView {

    fun goBackSuccess()

    fun showError(error: String)

    fun openGroupList()
}