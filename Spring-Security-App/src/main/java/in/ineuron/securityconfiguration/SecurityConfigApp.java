package in.ineuron.securityconfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfigApp {

	static {
		System.out.println("SecurityConfigApp .class file is loading...");
	}
	public SecurityConfigApp() {
		System.out.println("SecurityConfigApp.SecurityConfigApp()");
	}
	public SecurityFilterChain userDefinedFilter(HttpSecurity http) throws Exception {
		
		System.out.println("SecurityConfigApp.userDefinedFilter()");
        http.authorizeHttpRequests(request -> request.requestMatchers("/login", "/bank/", "/bank/about").permitAll().anyRequest().authenticated())
                .formLogin(withDefaults());
		return http.build();
	}
}
