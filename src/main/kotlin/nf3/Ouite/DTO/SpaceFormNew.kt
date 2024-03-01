package nf3.Ouite.DTO

import jakarta.validation.constraints.NotEmpty


data class SpaceFormNew(
    @field:NotEmpty
    val id:Long,
    @field:NotEmpty
    val nome: String,
    @field:NotEmpty
    val descricao: String,
    val caminho: String?,
    val space_id: Long?
)
