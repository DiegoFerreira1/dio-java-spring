package dio.spring_security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import dio.spring_security.config.SecurityDatabaseService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    // Configura os usuários em memória
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User
                .withUsername("user")
                .password(passwordEncoder.encode("1234"))
                .roles("USERS")
                .build());
        manager.createUser(User
                .withUsername("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("MANAGERS", "USERS")
                .build());
        return manager;
    }

    // Configura o encoder para as senhas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configura a cadeia de filtros de segurança
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/").permitAll()
                .requestMatchers(HttpMethod.POST,"/login").permitAll()
                .requestMatchers("/admin/**").hasRole("MANAGERS")
                .requestMatchers("/user/**").hasRole("USERS")
                .anyRequest().authenticated()
            )
            .formLogin()
            .and()
            .httpBasic(); // Opcional
    
        return http.build();
    }
    
}
