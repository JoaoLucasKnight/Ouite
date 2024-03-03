package nf3.Ouite.DTO

data class ArtifactFormUpdate(
    val id: Long?,
    val name: String,
    val descricao: String,
    val caminho: String,
    val space_id: Long,
    val box_id: Long?
)
