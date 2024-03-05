package nf3.ouite.controller

import nf3.ouite.dto.SpaceForm
import nf3.ouite.dto.SpaceFormUpdate
import nf3.ouite.dto.SpaceView
import nf3.ouite.service.SpaceService
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/space")
class SpaceController(private val service: SpaceService){

    @GetMapping
    fun getSpaces(): List<SpaceView>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun getSpaceId(@PathVariable id:Long): SpaceView?{
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun createSpace (@RequestBody form: SpaceForm):SpaceView{
        return service.cadastrar(form)
    }

    @PutMapping
    @Transactional
    fun updateSpace(@RequestBody form: SpaceFormUpdate):SpaceView{
        return  service.atualizar(form)
    }

    @DeleteMapping("/{id}")
    fun deleteSpace(@PathVariable id: Long): List<SpaceView>{
        service.deletar(id)
        return service.listar()
    }
}