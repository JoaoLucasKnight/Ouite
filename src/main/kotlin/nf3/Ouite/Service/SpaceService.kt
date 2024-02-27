package nf3.Ouite.Service

import nf3.Ouite.Model.Space
import nf3.Ouite.repository.SpaceRepository
import org.springframework.stereotype.Service

@Service
class SpaceService (
    private val repos: SpaceRepository,
){
    fun listar(): List<Space>{
        return repos.findAll()
    }

    fun buscarPorId(id: Long): Space? {
        val optionalSpace = repos.findById(id)
        return if (optionalSpace.isPresent)
            optionalSpace.get()
        else
            null
    }
}