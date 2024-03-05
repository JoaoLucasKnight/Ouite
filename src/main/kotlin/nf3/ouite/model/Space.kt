package nf3.ouite.model

import jakarta.persistence.*

@Entity
data class Space(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String,
    var description: String,
    var way: String? = null,

    @ManyToOne
    @JoinColumn(name = "id_space_pai")
    val spacePai: Space? = null,

//    @OneToMany(mappedBy = "spacePai")
//    val subespacos: List<Space> = listOf(),

    @OneToMany(mappedBy = "space")
    val boxes: List<Box> = listOf(),

    @OneToMany(mappedBy = "space")
    val artifacts: List<Artifact> = listOf()
){
    init {
        way = construirCaminho()
    }

    fun construirCaminho(): String {
        val caminhoBuilder = StringBuilder()

        caminhoBuilder.append(name)
        spacePai?.let {
            caminhoBuilder.insert(0, it.construirCaminho() + ">")
        }
        way = caminhoBuilder.toString()
        return way!!
    }

}
