package in.ineuron.securityconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfigApp {

	@Autowired
	private DataSource datasource;

	@Autowired
	public void authenticateManager(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
		.dataSource(datasource)
		.usersByUsernameQuery("select username,password,enabled from user where username = ?")
		.authoritiesByUsernameQuery("select username,authority from authorities where username = ?");
	}
	
	
	@Bean
	SecurityFilterChain userDefinedFilter(HttpSecurity http) throws Exception {
		
		System.out.println("SecurityConfigApp.userDefinedFilter()");
        http.authorizeHttpRequests(request -> request.requestMatchers("/api/").permitAll()
        		.requestMatchers("/api/admin/").hasRole("ADMIN")
        		.requestMatchers("/api/user/").hasAnyRole("USER","ADMIN")
        		.anyRequest().authenticated())
                .formLogin(withDefaults());
		return http.build();
	}
}
