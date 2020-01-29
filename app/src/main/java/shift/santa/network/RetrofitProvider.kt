package shift.santa.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitProvider(interceptorList: List<Interceptor>) {

    val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(createClient(interceptorList))
            .build()
    }

    private fun createClient(interceptorList: List<Interceptor>): OkHttpClient {
        val builder = OkHttpClient.Builder()

        for (interceptor in interceptorList) {
            builder.addInterceptor(interceptor)
        }

        return builder.build()
    }

    companion object {

        private val BASE_URL = "https://secretsanta2020.herokuapp.com/"
    }

}