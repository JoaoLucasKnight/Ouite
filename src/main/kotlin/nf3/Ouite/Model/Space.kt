package nf3.Ouite.Model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
data class Space(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val descricao: String,
    val caminho: String? = null,

    @ManyToOne
    val space: Space?= null,

    @ManyToOne
    val box: Box? = null,

    @ManyToOne
    val algo: Algo? = null
)
