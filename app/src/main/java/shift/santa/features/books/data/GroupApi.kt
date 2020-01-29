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

    @GET("/{groupId}")
    fun getBook(@Path("id") id: String): Call<Book>

    @POST("books")
    fun createBook(@Body book: Book): Call<Book>

    @DELETE("books/{id}")
    fun deleteBook(@Path("id") id: String): Call<Success>

}
