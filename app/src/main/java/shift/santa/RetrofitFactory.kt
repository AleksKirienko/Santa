package shift.santa

import android.content.Context

import java.util.ArrayList

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import shift.santa.network.RetrofitProvider

internal object RetrofitFactory {

    fun createRetrofitProvider(context: Context): RetrofitProvider {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val interceptorList = ArrayList<Interceptor>()
        interceptorList.add(logInterceptor)

        return RetrofitProvider(interceptorList)
    }
}
