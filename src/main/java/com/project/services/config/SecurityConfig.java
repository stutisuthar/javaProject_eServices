// package com.project.services.config;

// import com.project.services.controller.LoginAccessDeniedController;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
// import javax.sql.DataSource;
// // import org.springframework.*;

// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     @Autowired
//     private DataSource dataSource;
//     private LoginAccessDeniedController accessDeniedHandler;

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http
//                 .authorizeRequests()
//                     .antMatchers(
//                             "/",
//                             "/js/**",
//                             "/css/**",
//                             "/img/**",
//                             "/webjars/**").permitAll()
//                     .antMatchers("/**").hasRole("USER")
//                     .anyRequest().authenticated()
//                 .and()
//                 .formLogin()
//                     .loginPage("/login")
//                     .permitAll()
//                 .and()
//                 .logout()
//                     .invalidateHttpSession(true)
//                     .clearAuthentication(true)
//                     .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                     .logoutSuccessUrl("/login?logout")
//                     .permitAll()
//                 .and()
//                 .exceptionHandling()
//                     .accessDeniedHandler(accessDeniedHandler);
//     }

//     @Override
//     @Autowired
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//         auth.inMemoryAuthentication()
//                 .withUser("user@gmail.com").password("password").roles("USER")
//             .and()
//                 .withUser("manager").password("password").roles("MANAGER");
//         // auth.jdbcAuthentication().dataSource(dataSource)
//         //         .usersByUsernameQuery("select email,password " + "from user_details " + "where email = ?")
//         //         .authoritiesByUsernameQuery("USER");
//                 // .authoritiesByUsernameQuery("select email,authority " + "from authorities " + "where email = ?");
//     }

// }