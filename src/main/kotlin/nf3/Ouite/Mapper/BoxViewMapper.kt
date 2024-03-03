package nf3.Ouite.Mapper

import nf3.Ouite.DTO.BoxView
import nf3.Ouite.Model.Box
import org.springframework.stereotype.Component

@Component
class BoxViewMapper: Mapper <Box, BoxView>{
    override fun map(b: Box): BoxView {
        return BoxView(
            id = b.id,
            name = b.nome,
            descricao = b.descricao,
            caminho = b.caminho
        )

    }
}