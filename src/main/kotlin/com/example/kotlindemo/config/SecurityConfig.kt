package com.example.kotlindemo.config

import javax.sql.DataSource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository

@Configuration
class SecurityConfig: WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var dataSource: DataSource

    override fun configure(http: HttpSecurity ){
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .rememberMe()
                .rememberMeCookieName("javasampleapproach-remember-me")
                .tokenValiditySeconds(24 * 60 * 60) // expired time = 1 day
                .tokenRepository(persistentTokenRepository())
                .and()
                .logout()
                .permitAll()
    }

    @Bean
    fun persistentTokenRepository(): PersistentTokenRepository {
        var tokenRepository = JdbcTokenRepositoryImpl()
        tokenRepository.setDataSource(dataSource)
        return tokenRepository
    }

    @Autowired
    fun configureGlobal(auth: AuthenticationManagerBuilder){
        auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER")
    }
}