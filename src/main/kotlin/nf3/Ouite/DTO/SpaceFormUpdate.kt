package nf3.Ouite.DTO

import jakarta.validation.constraints.NotEmpty


data class SpaceFormUpdate(

    val id:Long,
    val nome: String,
    val descricao: String,
    val caminho: String?,
    val space_id: Long?

)
