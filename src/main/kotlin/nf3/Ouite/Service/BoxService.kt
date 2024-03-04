package nf3.Ouite.Service

import nf3.Ouite.DTO.*
import nf3.Ouite.Mapper.BoxFormMapper
import nf3.Ouite.Mapper.BoxViewMapper
import nf3.Ouite.repository.BoxRepository
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import javax.swing.Box
@Service
class BoxService(
    private val repos: BoxRepository,
    private val mapperView: BoxViewMapper,
    private val mapperForm: BoxFormMapper
) {
    fun listar(): List<BoxView> {
        return repos
            .findAll()
            .stream()
            .map { s -> mapperView.map(s) }
            .collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): BoxView? {
        val space = repos.findById(id) // retorna  um opcional
        return if (space.isPresent){
            mapperView.map(space.get())
        }else {
            null
        }
    }

    fun cadastrar(form: BoxForm): BoxView {
        val space = mapperForm.map(form)
        repos.save(space)

        return mapperView.map(space)
    }

//    fun atualizar(form: SpaceFormUpdate): SpaceView {
//        val space = repos.findById(form.id)
//            .orElseThrow{ ChangeSetPersister.NotFoundException() }
//
//        space.nome = form.nome
//        space.descricao = form.descricao
//        space.caminho = space.construirCaminho()
//        return mapperView.map(space)
//    }

    fun deletar(id:Long){
        repos.deleteById(id)
    }
}
