package nf3.Ouite.Mapper

import nf3.Ouite.DTO.BoxForm
import nf3.Ouite.Model.Box
import nf3.Ouite.Model.Space
import nf3.Ouite.Service.SpaceService
import nf3.Ouite.repository.BoxRepository
import nf3.Ouite.repository.SpaceRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Component

@Component
class BoxFormMapper(
    private val boxRepos: BoxRepository,
    private val spaceRepos: SpaceRepository
): Mapper <BoxForm, Box>{
    override fun map(b: BoxForm): Box {

        val spacePai: Space = b.space_id.let{
            spaceRepos.findById(it).orElseThrow{NotFoundException()}
        }

        val boxPai: Box? = b.box_id?.let { boxRepos
            .findById(it).orElse(null) }


        return Box (
            nome = b.nome,
            descricao = b.descricao,
            caminho = b.caminho,
            space = spacePai,
            boxPai = boxPai

        )
    }

}
