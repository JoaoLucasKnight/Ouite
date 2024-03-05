package nf3.ouite.mapper

import nf3.ouite.dto.SpaceView
import nf3.ouite.model.Space
import org.springframework.stereotype.Component

@Component
class SpaceViewMapper: Mapper<Space, SpaceView> {
    override fun map(s: Space): SpaceView {
        return SpaceView(
            id = s.id,
            name = s.name,
            description = s.description,
            way = s.way
        )
    }
}