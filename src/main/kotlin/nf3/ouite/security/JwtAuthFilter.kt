package nf3.ouite.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import nf3.ouite.config.JWT
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class JwtAuthFilter(
    private val jwt: JWT
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = request.getHeader("Authorization")
        val gtd: String? = getTokenDetail(token)
        if(jwt.isValid(gtd)){
            val authentication = jwt.getAutheticator(gtd)
            SecurityContextHolder.getContext().authentication = authentication
        }
        filterChain.doFilter(request,response)
    }

    private fun getTokenDetail(token: String?): String?{
        return token?.let { t ->
            t.startsWith("Bearer ")
            t.substring(7,t.length)
        }
    }
}