package shift.santa.features

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
