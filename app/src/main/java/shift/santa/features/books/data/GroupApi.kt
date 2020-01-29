package shift.santa.features.books.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import shift.santa.features.books.domain.model.Book
import shift.santa.features.books.domain.model.Group
import shift.santa.features.books.domain.model.Success


interface GroupApi {

    @GET("api/v001/groups")
    fun getGroup(): Call<List<Group>>

    @GET("groups/{groupId}")
    fun getGroup(@Path("id") id: String): Call<Group>

    @POST("groups")
    fun createGroup(@Body group: Group): Call<Group>

    @DELETE("groups/{id}")
    fun deleteGroup(@Path("id") id: String): Call<Success>

}
