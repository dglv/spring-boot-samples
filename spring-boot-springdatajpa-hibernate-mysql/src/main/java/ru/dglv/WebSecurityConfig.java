package ru.dglv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private ComboPooledDataSource datasource;
    
    @Override
    protected void configure(final HttpSecurity http) throws Exception 
    {
        http
            .authorizeRequests()
                .antMatchers("/resources/**", "/pages/**").permitAll()
                .antMatchers("/signup").permitAll()
                .anyRequest().authenticated();
        
        http
            .formLogin()
                .loginPage("/login").defaultSuccessUrl("/").failureUrl("/login?error").permitAll().and()
                .logout().logoutSuccessUrl("/login").logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception 
    {
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
        
/*        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
        userDetailsService.setDataSource(datasource);
        PasswordEncoder encoder = new BCryptPasswordEncoder();
 
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
        auth.jdbcAuthentication().dataSource(datasource);*/
    }
}
