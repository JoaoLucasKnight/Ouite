package nf3.Ouite.DTO

data class BoxForm(
    val nome: String,
    val descricao : String,
    val caminho: String?,
    val space_id : Long,
    val box_id: Long?
)
