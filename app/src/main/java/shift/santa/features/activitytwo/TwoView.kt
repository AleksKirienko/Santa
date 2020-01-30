package shift.santa.features.activitytwo

import shift.santa.features.MvpView

interface TwoView : MvpView{

    fun goBackSuccess()

    fun showError(error: String)
}