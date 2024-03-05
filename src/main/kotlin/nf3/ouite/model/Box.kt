package nf3.ouite.model

import jakarta.persistence.*

@Entity
data class Box(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String,
    var description: String,
    var way: String? = null,

    @ManyToOne
    @JoinColumn(name = "id_space", nullable = false)
    val space: Space,

    @ManyToOne
    @JoinColumn(name = "id_box_pai")
    val boxPai: Box? = null,

    @OneToMany(mappedBy = "boxPai")
    val subBoxes: List<Box> = listOf(),

    @OneToMany(mappedBy = "box")
    val artifacts: List<Artifact> = listOf()
){

    init {
        way = construirCaminho()
    }
    fun construirCaminho(): String {
        val caminhoBuilder = StringBuilder()

        caminhoBuilder.append(name)
        boxPai?.let {
            caminhoBuilder.insert(0, it.construirCaminho() + ">")
        }
        space.let{
            caminhoBuilder.insert(0, it.construirCaminho() + ">")
        }

        way = caminhoBuilder.toString()
        return way!!
    }

}
