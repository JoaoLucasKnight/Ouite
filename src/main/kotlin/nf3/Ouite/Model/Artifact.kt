package nf3.Ouite.Model

import jakarta.persistence.*

@Entity
data class Artifact(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val descricao: String,
    val caminho: String? = null,

    @ManyToOne
    @JoinColumn(name = "id_space")
    val space: Space,

    @ManyToOne
    @JoinColumn(name = "id_box")
    val box: Box? = null
)
