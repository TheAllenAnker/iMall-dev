package com.delicate.iMall.config;

import com.delicate.iMall.service.security.AdminDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/address/*").permitAll()
                .antMatchers("/cart/*").permitAll()
                .antMatchers("/home/*").permitAll()
                .antMatchers("/productCategory/*").permitAll()
                .antMatchers("/product/*").permitAll()
                .antMatchers("/user/*").permitAll()
                .antMatchers("/resources/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/index/loginPage")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/admin/loginPage")
                .loginProcessingUrl("/admin/login")
                .defaultSuccessUrl("/admin/index")
                .permitAll();
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new AdminDetailsService();
    }
}
