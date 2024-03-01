package nf3.Ouite.Controller

import jakarta.persistence.Cacheable
import nf3.Ouite.DTO.SpaceForm
import nf3.Ouite.DTO.SpaceFormNew
import nf3.Ouite.DTO.SpaceView
import nf3.Ouite.Model.Space
import nf3.Ouite.Service.SpaceService
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/space")
class SpaceController(private val service: SpaceService){

    @GetMapping
    fun listar(): List<SpaceView>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscaID(@PathVariable id:Long): SpaceView?{
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun criar (@RequestBody form: SpaceForm):SpaceView{
        return service.cadastrar(form)
    }

    @PutMapping
    @Transactional
    fun atualizar(@RequestBody form: SpaceFormNew):SpaceView{
        return  service.atualizar(form)
    }

    @DeleteMapping("/{id}")
    fun apagar(@PathVariable id: Long): List<SpaceView>{
        service.deletar(id)
        return service.listar()
    }
}