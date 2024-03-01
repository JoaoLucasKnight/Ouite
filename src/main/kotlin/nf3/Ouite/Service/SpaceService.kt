package nf3.Ouite.Service

import nf3.Ouite.DTO.SpaceForm
import nf3.Ouite.DTO.SpaceFormNew
import nf3.Ouite.DTO.SpaceView
import nf3.Ouite.Mapper.SpaceFormMapper
import nf3.Ouite.Mapper.SpaceViewMapper
import nf3.Ouite.repository.SpaceRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class SpaceService (
    private val repos: SpaceRepository,
    private val mapperView: SpaceViewMapper,
    private val mapperForm: SpaceFormMapper
) {
    fun listar(): List<SpaceView> {
        return repos
            .findAll()
            .stream()
            .map { s -> mapperView.map(s) }
            .collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): SpaceView? {
        val space = repos.findById(id) // retorna  um opcional
        return if (space.isPresent){
            mapperView.map(space.get())
        }else {
            null
        }
    }

    fun cadastrar(form: SpaceForm): SpaceView{
        val space = mapperForm.map(form)
        repos.save(space)

        return mapperView.map(space)
    }

    fun atualizar(form: SpaceFormNew):SpaceView{
        val space = repos.findById(form.id)
            .orElseThrow{NotFoundException()}

        space.nome = form.nome
        space.descricao = form.descricao
        return mapperView.map(space)
    }

    fun deletar(id:Long){
        repos.deleteById(id)
    }
}
