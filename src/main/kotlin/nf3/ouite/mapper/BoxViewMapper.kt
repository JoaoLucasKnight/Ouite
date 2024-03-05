package nf3.ouite.mapper

import nf3.ouite.dto.BoxView
import nf3.ouite.model.Box
import org.springframework.stereotype.Component

@Component
class BoxViewMapper: Mapper <Box, BoxView>{
    override fun map(b: Box): BoxView {
        return BoxView(
            id = b.id,
            name = b.name,
            description = b.description,
            way = b.way
        )

    }
}