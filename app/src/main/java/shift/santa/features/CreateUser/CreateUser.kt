package shift.santa.features.CreateUser

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_create_user.*
import shift.santa.R
import shift.santa.features.BaseActivity
import shift.santa.features.MvpPresenter
import shift.santa.features.activitytwo.TwoView
import shift.santa.features.books.presentation.BookAdapter
import shift.santa.features.books.presentation.BookListPresenter
import shift.santa.features.books.presentation.BookListView
import shift.santa.features.books.presentation.PresenterFactory
import shift.santa.features.groupList.groupListActivity

class CreateUser : BaseActivity<CreateUserView>(), CreateUserView {

    private var presenter: CreateUserPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)

        button3.setOnClickListener {
            val fieldName = editText.toString()
            val fieldLikes = editText5.toString()
            val fieldDislikes = editText6.toString()

            if (fieldName == "" || fieldLikes == "" || fieldDislikes == "") {

                Toast.makeText(this, "Вы заполнили не все поля", Toast.LENGTH_SHORT).show()
            }
            else {
                //presenter.onClick(fieldName!!, fieldLikes!!.toInt(), fieldDislikes!!.toLong())
                presenter!!.onClick(fieldName, fieldLikes, fieldDislikes)
            }

            //presenter!!.onClick(fieldName, fieldLikes, fieldDislikes)
        }
    }

    override fun getMvpPresenter(): MvpPresenter<CreateUserView> {
        presenter = PresenterFactory.createPresenterUser(this)
        return presenter!!
    }

    override fun getMvpView(): CreateUserView {
        return this
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun openGroupList() {
        //запрос на добавление в группу
        //finish()
    }


    override fun goBackSuccess() {
        //Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
        //запрос на добавление группы
        setResult(Activity.RESULT_OK)
        finish()
    }
}
