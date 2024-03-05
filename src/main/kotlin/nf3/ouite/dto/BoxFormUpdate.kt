package nf3.ouite.dto

data class BoxFormUpdate(
    val id: Long?,
    val name: String,
    val description: String,
    val way: String,
    val spaceId: Long,
    val boxId: Long?
)
