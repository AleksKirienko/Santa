package shift.santa.features.groupList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import shift.santa.R
import shift.santa.features.books.domain.model.Group

class groupListActivity : AppCompatActivity() {

    private var selectedIDGroup: Long? = null

    companion object {
        val SELECTED_GROUP: String? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_list)
        selectedIDGroup = intent.getLongExtra(SELECTED_GROUP, 0)
    }

}
