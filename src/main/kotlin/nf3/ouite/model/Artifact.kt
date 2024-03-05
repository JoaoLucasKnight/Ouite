package nf3.ouite.model

import jakarta.persistence.*

@Entity
data class Artifact(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val description: String,
    val way: String? = null,

    @ManyToOne
    @JoinColumn(name = "id_space")
    val space: Space,

    @ManyToOne
    @JoinColumn(name = "id_box")
    val box: Box? = null
)
