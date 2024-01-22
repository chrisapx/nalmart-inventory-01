//package com.cwift.cwiftMarketplace_backend.configuration.securityConfig;
//
//import com.cwift.cwiftMarketplace_backend.configuration.securityConfig.jwt.JWTRequestFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
//
//    private static final String[] AUTH_WHITELIST = {
//            // -- Swagger UI v2
//            "/v2/api-docs",
//            "/swagger-resources",
//            "/swagger-resources/**",
//            "/configuration/ui",
//            "/configuration/security",
//            "/swagger-ui.html",
//            "/webjars/**",
//
//            // -- Swagger UI v3 (OpenAPI)
//            "/v3/api-docs/**",
//            "/swagger-ui/**",
//
//            // -- white listed endpoints
//            "/users/auth",
//            "/users/us1",
//            "/users/cfm"
//
//    };
//    @Autowired
//    private MyUserDetailsService myUserDetailsService;
//
//    @Value("${password-encoder}")
//    private boolean passwordEncoder;
//
//    @Autowired
//    private JWTRequestFilter jwtRequestFilter;
//
//    public SecurityConfigurer(MyUserDetailsService myUserDetailsService) {
//        this.myUserDetailsService = myUserDetailsService;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(myUserDetailsService);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.csrf().disable()
//                .authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
//                .anyRequest().authenticated()
//        .and().sessionManagement()
//        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return passwordEncoder? new BCryptPasswordEncoder(12):
//        NoOpPasswordEncoder.getInstance();
//    }
//}
