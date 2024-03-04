package nf3.Ouite.Model

import jakarta.persistence.*

@Entity
data class Box(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var nome: String,
    var descricao: String,
    var caminho: String? = null,

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
        caminho = construirCaminho()
    }
    fun construirCaminho(): String {
        val caminhoBuilder = StringBuilder()

        caminhoBuilder.append(nome)
        boxPai?.let {
            caminhoBuilder.insert(0, it.construirCaminho() + ">")
        }
        space.let{
            caminhoBuilder.insert(0, it.construirCaminho() + ">")
        }

        caminho = caminhoBuilder.toString()
        return caminho!!
    }

}
