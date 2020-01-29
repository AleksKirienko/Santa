package shift.santa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.books_activity.*

class ActivityThree : AppCompatActivity() {

    companion object {
        const val IS_GROUP_CREATOR = "is_group_creator"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.books_activity)

    }

    private fun setInetentParam(isCreator: Boolean): Intent {
        val intent = Intent(this, WaitActivity::class.java)
        intent.putExtra(WaitActivity.IS_GROUP_CREATOR, isCreator)
        return intent
    }
}
