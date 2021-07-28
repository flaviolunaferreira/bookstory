package the.coyote.bookstory.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import the.coyote.bookstory.service.DbSeeds;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DbSeeds dbSeeds;
	
	@Bean
	public void instanciandoBaseDeDados() {
		this.dbSeeds.semearBaseDeDados();
	}
	
}
