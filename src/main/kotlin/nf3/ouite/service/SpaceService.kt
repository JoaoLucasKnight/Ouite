package nf3.ouite.service

import nf3.ouite.dto.SpaceForm
import nf3.ouite.dto.SpaceFormUpdate
import nf3.ouite.dto.SpaceView
import nf3.ouite.mapper.SpaceFormMapper
import nf3.ouite.mapper.SpaceViewMapper
import nf3.ouite.repository.SpaceRepository
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

    fun atualizar(form: SpaceFormUpdate):SpaceView{
        val space = repos.findById(form.id)
            .orElseThrow{NotFoundException()}

        space.name = form.name
        space.description = form.description
        space.way = space.construirCaminho()
        return mapperView.map(space)
    }

    fun deletar(id:Long){
        repos.deleteById(id)
    }
}
