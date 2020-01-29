package shift.santa.features.books.presentation

import android.content.Context

import shift.santa.App
import shift.santa.features.books.data.BooksRepositoryImpl
import shift.santa.features.books.data.GroupApi

/**
 * Created: samokryl
 * Date: 02.07.18
 * Time: 1:03
 */

internal object PresenterFactory {

    fun createPresenter(context: Context): BookListPresenter {
        val api = App.getRetrofitProvider(context)
            ?.retrofit
            ?.create(GroupApi::class.java)

        val repository = BooksRepositoryImpl(api!!)

        return BookListPresenter(repository)
    }

}