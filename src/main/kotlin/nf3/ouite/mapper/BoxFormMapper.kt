package nf3.ouite.mapper

import nf3.ouite.dto.BoxForm
import nf3.ouite.model.Box
import nf3.ouite.model.Space
import nf3.ouite.repository.BoxRepository
import nf3.ouite.repository.SpaceRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Component

@Component
class BoxFormMapper(
    private val boxRepos: BoxRepository,
    private val spaceRepos: SpaceRepository
): Mapper <BoxForm, Box>{
    override fun map(b: BoxForm): Box {

        val spacePai: Space = b.spaceId.let{
            spaceRepos.findById(it).orElseThrow{NotFoundException()}
        }

        val boxPai: Box? = b.boxId?.let { boxRepos
            .findById(it).orElse(null) }


        return Box (
            name = b.name,
            description = b.description,
            way = b.way,
            space = spacePai,
            boxPai = boxPai

        )
    }

}
