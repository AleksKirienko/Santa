package shift.santa.features.books.domain.model


import com.google.gson.annotations.SerializedName

data class Group(
    @SerializedName("countPeople")
    val countPeople: Int,
    @SerializedName("creator")
    val creator: Creator,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)