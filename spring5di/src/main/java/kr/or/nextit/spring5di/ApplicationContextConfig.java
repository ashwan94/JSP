package kr.or.nextit.spring5di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContextConfig {
	
	@Bean
	public Greeter greeter() {
		return new Greeter();
	}
	
}
