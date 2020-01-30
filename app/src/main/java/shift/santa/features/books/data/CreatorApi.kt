package shift.santa.features.books.data

import retrofit2.Call
import retrofit2.http.*
import shift.santa.features.books.domain.model.Creator
import shift.santa.features.books.domain.model.Success

interface CreatorApi {

    @GET("api/v001/users")
    fun getCreator(): Call<List<Creator>>

    @GET("api/v001/users/{id}")
    fun getCreator(@Path("id") id: Long): Call<Creator>

    @POST("api/v001/users")
    fun createCreator(@Query("name") user: Creator): Call<Creator>

    @DELETE("api/v001/users/{id}")
    fun deleteCreator(@Path("id") id: Long): Call<Success>

}
