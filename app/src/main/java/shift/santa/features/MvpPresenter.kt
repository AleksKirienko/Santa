package shift.santa.features

/**
 * Created: samokryl
 * Date: 02.07.18
 * Time: 0:07
 */

open class MvpPresenter<View : MvpView> {

    protected var view: View? = null

    fun attachView(view: View) {
        this.view = view
        onViewReady()
    }

    fun detachView() {
        view = null
    }

    protected open fun onViewReady() {
        // override if need
    }
}
