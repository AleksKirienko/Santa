package shift.santa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_give_present.*

class GivePresentActivity : AppCompatActivity() {
    companion object {
        const val NAME = "name"
        const val LIKES = "likes"
        const val DISLIKES = "dislikes"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_give_present)

        textView2.text = intent.getStringExtra(NAME)
        textView3.text = intent.getStringExtra(LIKES)
        textView5.text = intent.getStringExtra(DISLIKES)

   }
}
