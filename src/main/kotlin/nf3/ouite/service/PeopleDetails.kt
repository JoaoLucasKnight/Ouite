package nf3.ouite.service

import nf3.ouite.model.People
import org.springframework.security.core.userdetails.UserDetails

class PeopleDetails(
    private val people: People
): UserDetails {

    override fun getAuthorities() = people.role

    override fun getPassword() = people.password

    override fun getUsername() = people.name

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true

}