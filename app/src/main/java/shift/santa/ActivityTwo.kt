package shift.santa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_two.*

class ActivityTwo : AppCompatActivity() {

    companion object {
        const val IS_GROUP_CREATOR = "is_group_creator"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        button.setOnClickListener{
            if (editText2.text.toString() == "" ||
                editText3.text.toString() == "" ||
                editText4.text.toString() == "") {

                Toast.makeText(this, "Вы заполнили не все поля", Toast.LENGTH_SHORT).show()
            }
            else {
                val intentEx = setInetentParam(
                    intent.getBooleanExtra(
                        WaitActivity.IS_GROUP_CREATOR,
                        false
                    )
                )
                startActivity(intentEx)
            }
        }
    }

    private fun setInetentParam(isCreator: Boolean): Intent {
        val intent = Intent(this, WaitActivity::class.java)
        intent.putExtra(WaitActivity.IS_GROUP_CREATOR, isCreator)
        return intent
    }
}
