package shift.santa.features.books.domain.model


import com.google.gson.annotations.SerializedName

data class Group(
    @SerializedName("countPeople")
    val countPeople: Int,
    @SerializedName("id_user")
    val idUser: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    val id: Long
)