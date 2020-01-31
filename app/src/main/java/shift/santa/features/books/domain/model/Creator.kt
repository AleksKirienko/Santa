package shift.santa.features.books.domain.model


import com.google.gson.annotations.SerializedName

data class Creator(
    @SerializedName("name")
    val name: String,
    @SerializedName("likes")
    val likes: String,
    @SerializedName("dislikes")
    val dislikes: String
)