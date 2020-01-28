package shift.santa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_give_present.*
import kotlinx.android.synthetic.main.activity_wait.*

class GivePresentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_give_present)
        button3.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
