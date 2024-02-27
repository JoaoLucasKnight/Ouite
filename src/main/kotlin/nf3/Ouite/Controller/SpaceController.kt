package nf3.Ouite.Controller

import jakarta.persistence.Cacheable
import nf3.Ouite.Model.Space
import nf3.Ouite.Service.SpaceService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/space")
class SpaceController(private val service: SpaceService){

    @GetMapping
    fun listar(): List<Space>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscaID(@PathVariable id:Long): Space?{
        return service.buscarPorId(id)
    }


}