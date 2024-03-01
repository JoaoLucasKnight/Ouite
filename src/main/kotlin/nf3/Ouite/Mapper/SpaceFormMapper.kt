package nf3.Ouite.Mapper

import nf3.Ouite.DTO.SpaceForm
import nf3.Ouite.DTO.SpaceView
import nf3.Ouite.Model.Space
import nf3.Ouite.repository.SpaceRepository
import org.springframework.stereotype.Component

@Component
class SpaceFormMapper(
    private val spaceRepository: SpaceRepository
): Mapper<SpaceForm, Space> {

    override fun map(s: SpaceForm): Space {

        // Verificar space_id
        val spacePai: Space? = s.space_id?.let { spaceRepository
            .findById(it).orElse(null) }

        return Space(
            nome = s.name,
            descricao = s.descricao,
            spacePai = spacePai
        )
    }
}
