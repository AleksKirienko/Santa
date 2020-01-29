package shift.santa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_two.*
import shift.santa.features.books.presentation.BookActivity
import shift.santa.features.books.presentation.BookListPresenter

class ActivityTwo : AppCompatActivity() {

    var fieldName: String? = null
    var fieldLikes: String? = null
    var fieldDislikes: String? = null

    companion object {
        const val IS_GROUP_CREATOR = "is_group_creator"
    }

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
                startActivity(Intent(this, BookActivity::class.java))
            }
        }
    }
}
