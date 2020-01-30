package shift.santa.features.books.domain.model


import com.google.gson.annotations.SerializedName

data class Creator(
    @SerializedName("dislikes")
    val dislikes: String,
    @SerializedName("id")
    val id: Long,
    @SerializedName("likes")
    val likes: String,
    @SerializedName("name")
    val name: String
)