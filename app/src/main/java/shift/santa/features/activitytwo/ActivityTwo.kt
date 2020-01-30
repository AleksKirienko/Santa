package shift.santa.features.activitytwo

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_two.*
import shift.santa.R
import shift.santa.features.BaseActivity
import shift.santa.features.MvpPresenter
import shift.santa.features.books.presentation.PresenterFactory

class ActivityTwo : BaseActivity<TwoView>(), TwoView {

    var fieldName: String? = null
    var fieldLikes: String? = null
    var fieldDislikes: String? = null

    lateinit var presenter: TwoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

            button.setOnClickListener{

            fieldName = editText2.text.toString()
            fieldLikes = editText3.text.toString()
            fieldDislikes = editText4.text.toString()

            if (fieldName == "" || fieldLikes == "" || fieldDislikes == "") {

                Toast.makeText(this, "Вы заполнили не все поля", Toast.LENGTH_SHORT).show()
            }
            else {
                presenter.onClick(fieldName!!, fieldLikes!!.toInt(), fieldDislikes!!.toLong())
            }
        }
    }

    override fun goBackSuccess() {
        setResult(Activity.RESULT_OK)
        finish()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun getMvpPresenter(): MvpPresenter<TwoView> {
        presenter = PresenterFactory.createPresenterTwo(this)
        return presenter
    }

    override fun getMvpView(): TwoView {
        return this
    }
}
