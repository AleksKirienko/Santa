package shift.santa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_wait.*

class WaitActivity : AppCompatActivity() {

    companion object {
        const val IS_GROUP_CREATOR = "is_group_creator"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wait)
        button2.isVisible = intent.getBooleanExtra(IS_GROUP_CREATOR, false)
        button2.setOnClickListener{
            startActivity(Intent(this, GivePresentActivity::class.java))
        }
    }
}
