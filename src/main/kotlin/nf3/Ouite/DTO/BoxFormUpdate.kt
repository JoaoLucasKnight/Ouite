package nf3.Ouite.DTO

data class BoxFormUpdate(
    val id: Long?,
    val name: String,
    val descricao: String,
    val space_id: Long,
    val box_id: Long?
)
