package nf3.ouite.controller

import nf3.ouite.dto.*
import nf3.ouite.service.BoxService
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/box")
class BoxController (private val service: BoxService) {

    @GetMapping
    fun getBoxes(): List<BoxView>{
        return service.getBoxes()
    }

    @GetMapping("/{id}")
    fun getBoxById(@PathVariable id:Long): BoxView?{
        return service.getBoxID(id)
    }

    @PostMapping
    @Transactional
    fun createBox (@RequestBody form: BoxForm): BoxView {
        return service.createBox(form)
    }


    @DeleteMapping("/{id}")
    fun deleteBox(@PathVariable id: Long): List<BoxView>{
        service.deleteBoxId(id)
        return service.getBoxes()
    }
}