// package `in`.ding.common.config
//
// import org.springframework.context.annotation.Bean
// import org.springframework.context.annotation.Configuration
// import org.springframework.security.config.annotation.web.builders.HttpSecurity
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
// import org.springframework.security.web.SecurityFilterChain
//
// @Configuration
// @EnableWebSecurity
// class SecurityConfig {
//
//    @Bean
//    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
//        http
//            .csrf().disable() // CSRF 보호 비활성화
//            .authorizeHttpRequests { requests ->
//                requests
//                    .requestMatchers("/api/v1/users").permitAll()
//                    .anyRequest().authenticated()
//            }
//        return http.build()
//    }
// }
