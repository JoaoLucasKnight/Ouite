package nf3.Ouite.Model

import jakarta.persistence.*

@Entity
data class Box(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val descricao: String,
    val caminho: String? = null,

    @ManyToOne
    @JoinColumn(name = "id_space", nullable = false)
    val space: Space,

    @ManyToOne
    @JoinColumn(name = "id_box_pai")
    val boxPai: Box? = null,

    @OneToMany(mappedBy = "box")
    val subBoxes: List<Box> = listOf(),

    @OneToMany(mappedBy = "box")
    val artifacts: List<Artifact> = listOf()
)
