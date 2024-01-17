package nhc.erp;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * @author 조용상
 */
@SpringBootApplication
@EnableCaching(proxyTargetClass = true)
public class Application extends SpringBootServletInitializer {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
    
    @Bean
	CommandLineRunner init() {
		return (String[] args) -> {
			String[] profiles = env.getActiveProfiles();
			logger.info("스프링부트 실행 완료 / 실행모드 : {} - {}", profiles[0], String.valueOf(UUID.randomUUID()));
		};
	}
}