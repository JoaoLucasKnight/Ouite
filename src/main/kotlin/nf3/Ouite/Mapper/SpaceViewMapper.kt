package nf3.Ouite.Mapper

import nf3.Ouite.DTO.SpaceView
import nf3.Ouite.Model.Space
import org.springframework.stereotype.Component

@Component
class SpaceViewMapper: Mapper<Space, SpaceView> {
    override fun map(s: Space): SpaceView {
        return SpaceView(
            id = s.id,
            nome = s.nome,
            descricao = s.descricao,
            caminho = s.caminho
        )
    }
}