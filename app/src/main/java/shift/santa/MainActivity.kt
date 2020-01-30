package shift.santa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import shift.santa.features.activitytwo.ActivityTwo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Button1.setOnClickListener {
            val intentEx = setInetentParam(true)
            startActivity(intentEx)
        }
    }

    private fun setInetentParam(isCreator: Boolean): Intent {
        val intent = Intent(this, ActivityTwo::class.java)
        //intent.putExtra(ActivityTwo.IS_GROUP_CREATOR, isCreator)
        return intent
    }
}
