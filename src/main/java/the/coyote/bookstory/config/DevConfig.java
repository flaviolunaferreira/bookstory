package the.coyote.bookstory.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import the.coyote.bookstory.service.DbSeeds;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DbSeeds dbSeeds;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instanciaBaseDeDados() {
		if (strategy.equals("create")) this.dbSeeds.semearBaseDeDados();
		return false;
	}
}
