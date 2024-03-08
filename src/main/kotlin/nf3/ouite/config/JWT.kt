package nf3.ouite.config

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import nf3.ouite.service.PeopleService
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*
import javax.crypto.spec.SecretKeySpec


@Component
class JWT (
        private val peopleService: PeopleService
) {
    private val expiration: Long = 60000

    @Value("\${jwt.secret}")
    private  lateinit var secret: String
    var key: Key = SecretKeySpec (secret.toByteArray(),SignatureAlgorithm.HS512.jcaName)



    fun generateToken (name: String, authorities: MutableCollection<out GrantedAuthority>): String?{
        return Jwts.builder()
            .setSubject(name)
            .claim("role", authorities)
            .setExpiration(Date(System.currentTimeMillis() + expiration))
            .signWith(key)
            .compact()
    }

    fun isValid (jwt: String?): Boolean{
        return try {
            Jwts
                .parser()
                .setSigningKey(secret.toByteArray())
                .parseClaimsJws(jwt)
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }
    fun getAutheticator(jwt: String?):Authentication{
        val name = Jwts.parser().setSigningKey(secret.toByteArray()).parseClaimsJws(jwt).body.subject
        val user = peopleService.loadUserByUsername(name)
        return UsernamePasswordAuthenticationToken(name, null, user.authorities)
    }

}