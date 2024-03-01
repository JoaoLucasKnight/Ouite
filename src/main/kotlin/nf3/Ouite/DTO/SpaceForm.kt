package nf3.Ouite.DTO

import jakarta.validation.constraints.NotEmpty

data class SpaceForm(
    @field:NotEmpty
    val name: String,
    @field:NotEmpty
    val descricao: String,
    val caminho: String?,
    val space_id: Long?
)
