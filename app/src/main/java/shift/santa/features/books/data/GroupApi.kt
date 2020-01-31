package shift.santa.features.books.data

import retrofit2.Call
import retrofit2.http.*
import shift.santa.features.books.domain.model.Creator
import shift.santa.features.books.domain.model.Group
import shift.santa.features.books.domain.model.Success


interface GroupApi {

    @GET("api/v001/groups")
    fun getGroup(): Call<List<Group>>

    @GET("api/v001/groups/users/{group_id}")
    fun getGroupMembers(@Path("group_id") id: Long): Call<List<Creator>>

    @GET("api/v001/groups/{id}")
    fun getGroup(@Path("id") id: Long): Call<Group>

    @POST("api/v001/groups")
    fun createGroup(@Query("name") name: String, @Query("count_people") count_people: Int, @Query("user_id") user_id: Long): Call<String>

    @DELETE("api/v001/groups/{id}")
    fun deleteGroup(@Path("id") id: Long): Call<Success>

}
