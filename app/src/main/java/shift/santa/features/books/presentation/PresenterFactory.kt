package shift.santa.features.books.presentation

import android.content.Context

import shift.santa.App
import shift.santa.features.activitytwo.TwoPresenter
import shift.santa.features.books.data.BooksRepositoryImpl
import shift.santa.features.books.data.CreatorApi
import shift.santa.features.books.data.CreatorRepositoryImpl
import shift.santa.features.books.data.GroupApi
import shift.santa.features.books.domain.BooksRepository
import shift.santa.features.books.domain.CreatorRepository

/**
 * Created: samokryl
 * Date: 02.07.18
 * Time: 1:03
 */

internal object PresenterFactory {

    var repository: BooksRepository? = null
    var userRepository: CreatorRepository? = null


    fun createPresenter(context: Context): BookListPresenter {
        val rep = repository ?: createRepository(context).also { repository = it }
        val rep2 = userRepository ?: createUserRepository(context).also { userRepository = it }

        return BookListPresenter(rep2, rep)
    }

    fun createPresenterTwo(context: Context): TwoPresenter {
        val rep = repository ?: createRepository(context).also { repository = it }

        return TwoPresenter(rep)
    }

    private fun createRepository(context: Context): BooksRepository {
        val api = App.getRetrofitProvider(context)
            ?.retrofit
            ?.create(GroupApi::class.java)

        val repository = BooksRepositoryImpl(api!!)
        return repository
    }

    private fun createUserRepository(context: Context): CreatorRepository {
        val api = App.getRetrofitProvider(context)
            ?.retrofit
            ?.create(CreatorApi::class.java)

        val repository = CreatorRepositoryImpl(api!!)
        return repository
    }

}