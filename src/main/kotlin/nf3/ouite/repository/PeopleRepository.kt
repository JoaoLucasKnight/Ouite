package nf3.ouite.repository

import nf3.ouite.model.People
import org.springframework.data.jpa.repository.JpaRepository

interface PeopleRepository: JpaRepository <People, Long> {
    fun findByName(name: String?): People?
}
