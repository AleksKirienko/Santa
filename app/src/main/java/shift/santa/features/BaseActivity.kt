package shift.santa.features

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<T : MvpView> : AppCompatActivity() {

    private var presenter: MvpPresenter<T>? = null

    protected abstract fun getMvpPresenter(): MvpPresenter<T>

    protected abstract fun getMvpView(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = getMvpPresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter!!.attachView(getMvpView())
    }

    override fun onStop() {
        super.onStop()
        presenter!!.detachView()
    }

}