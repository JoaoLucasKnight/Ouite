package nf3.ouite.service

import nf3.ouite.dto.*
import nf3.ouite.mapper.BoxFormMapper
import nf3.ouite.mapper.BoxViewMapper
import nf3.ouite.repository.BoxRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class BoxService(
    private val repos: BoxRepository,
    private val mapperView: BoxViewMapper,
    private val mapperForm: BoxFormMapper
) {
    fun getBoxes(): List<BoxView> {
        return repos
            .findAll()
            .stream()
            .map { s -> mapperView.map(s) }
            .collect(Collectors.toList())
    }

    fun getBoxID(id: Long): BoxView? {
        val space = repos.findById(id) // retorna  um opcional
        return if (space.isPresent){
            mapperView.map(space.get())
        }else {
            null
        }
    }

    fun createBox(form: BoxForm): BoxView {
        val space = mapperForm.map(form)
        repos.save(space)

        return mapperView.map(space)
    }


    fun deleteBoxId(id:Long){
        repos.deleteById(id)
    }
}
