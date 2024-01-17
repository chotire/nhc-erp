package nhc.erp.persistence.mybatis.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.zaxxer.hikari.HikariConfig;

public class HikariDataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari.tibero")
    public HikariConfig tibero() {
    	/*
    	HikariConfig hikariConfig = new HikariConfig();
    	hikariConfig.setDriverClassName("com.tmax.tibero.jdbc.TbDriver");
    	hikariConfig.setJdbcUrl("jdbc:tibero:thin:@192.168.0.28:8629:tibero");
    	hikariConfig.setUsername("nhcerp");
    	hikariConfig.setPassword("nhcerp1215");
    	*/
    	return new HikariConfig();
    }
}