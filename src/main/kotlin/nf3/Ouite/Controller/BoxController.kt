package nf3.Ouite.Controller

import nf3.Ouite.DTO.*
import nf3.Ouite.Service.BoxService
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/box")
class BoxController (private val service: BoxService) {

    @GetMapping
    fun listar(): List<BoxView>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscaID(@PathVariable id:Long): BoxView?{
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun criar (@RequestBody form: BoxForm): BoxView {
        return service.cadastrar(form)
    }

//    @PutMapping
//    @Transactional
//    fun atualizar(@RequestBody form: SpaceFormUpdate): SpaceView {
//        return  service.atualizar(form)
//    }

    @DeleteMapping("/{id}")
    fun apagar(@PathVariable id: Long): List<BoxView>{
        service.deletar(id)
        return service.listar()
    }
}