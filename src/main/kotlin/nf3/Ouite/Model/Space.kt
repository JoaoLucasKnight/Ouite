package nf3.Ouite.Model

import jakarta.persistence.*

@Entity
data class Space(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var nome: String,
    var descricao: String,
    val caminho: String? = null,

    @ManyToOne
    @JoinColumn(name = "id_space_pai")
    val spacePai: Space? = null,

//    @OneToMany(mappedBy = "spacePai")
//    val subespacos: List<Space> = listOf(),

    @OneToMany(mappedBy = "space")
    val boxes: List<Box> = listOf(),

    @OneToMany(mappedBy = "space")
    val artifacts: List<Artifact> = listOf()
)
