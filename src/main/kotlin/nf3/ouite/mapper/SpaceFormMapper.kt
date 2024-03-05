package nf3.ouite.mapper

import nf3.ouite.dto.SpaceForm
import nf3.ouite.model.Space
import nf3.ouite.repository.SpaceRepository
import org.springframework.stereotype.Component

@Component
class SpaceFormMapper(
    private val spaceRepository: SpaceRepository
): Mapper<SpaceForm, Space> {

    override fun map(t: SpaceForm): Space {

        // Verificar space_id
        val spacePai: Space? = t.spaceId?.let { spaceRepository
            .findById(it).orElse(null) }

        return Space(
            name = t.name,
            description = t.description,
            spacePai = spacePai
        )
    }
}
