package shift.santa

import android.app.Application
import android.content.Context

import shift.santa.network.RetrofitProvider

class App : Application() {

    private var retrofitProvider: RetrofitProvider? = null

    override fun onCreate() {
        super.onCreate()
        retrofitProvider = RetrofitFactory.createRetrofitProvider(this)
    }

    companion object {

        fun getRetrofitProvider(context: Context): RetrofitProvider? {
            return getApp(context).retrofitProvider
        }

        private fun getApp(context: Context): App {
            return context.applicationContext as App
        }
    }
}