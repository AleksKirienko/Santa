package shift.santa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_two.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Button1.setOnClickListener {
            startActivity(Intent(this, ActivityTwo::class.java))
        }
    }

    /*fun toastMe(view: View) {
        val myToast = Toast.makeText(this, "Hello", Toast.LENGTH_SHORT)

        myToast.show()
    }*/
}
