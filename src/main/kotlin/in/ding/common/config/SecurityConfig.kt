import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy


@Configuration
@EnableWebSecurity
class SecurityConfig {
    private val allowedUrls = arrayOf("/api/v1/auth/users")

    @Bean
    fun filterChain(http: HttpSecurity) = http
        .authorizeHttpRequests {
            it.requestMatchers(*allowedUrls).permitAll()
                .requestMatchers(PathRequest.toH2Console()).permitAll()
                .anyRequest().authenticated()
        }
        .build()!!
}