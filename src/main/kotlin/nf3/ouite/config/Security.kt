package nf3.ouite.config

import nf3.ouite.security.JwtAuthFilter
import nf3.ouite.security.JwtLoginFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
class Security(
    private val userDetailsService: UserDetailsService,
    private val jwt: JWT,
) {


    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeRequests()
            .requestMatchers("/space").hasRole("ADMIN")
            .anyRequest()
            .authenticated()
            .and()
            .addFilterBefore(JwtLoginFilter(authManager = authenticationManager(), jwt = jwt),
                UsernamePasswordAuthenticationFilter().javaClass)
            .addFilterBefore(JwtAuthFilter(jwt = jwt), UsernamePasswordAuthenticationFilter().javaClass)
        return http.build()
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Autowired
    fun configureGlobal (auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder())
    }

}

