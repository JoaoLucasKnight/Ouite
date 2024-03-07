package nf3.ouite.service

import nf3.ouite.model.People
import nf3.ouite.repository.PeopleRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class PeopleService(
    private val repos: PeopleRepository
): UserDetailsService {
    fun SearchId (id: Long):People {
        return repos.findById(id).get()
    }

    override fun loadUserByUsername(name: String?): UserDetails {
        val people = repos.findByName(name) ?: throw RuntimeException()
        return PeopleDetails(people)
    }
}