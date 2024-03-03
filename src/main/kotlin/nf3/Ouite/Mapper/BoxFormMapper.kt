package nf3.Ouite.Mapper

import nf3.Ouite.DTO.BoxForm
import nf3.Ouite.Model.Box

class BoxFormMapper: Mapper <BoxForm, Box>{
    override fun map(b: BoxForm): Box {
        return Box (
            nome = b.nome,
            descricao = b.descricao,
            caminho = b.caminho,
            space = b.space_id,
            boxPai = b.box_id
            

        )
    }

}
