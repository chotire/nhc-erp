package nhc.erp.persistence.mybatis.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.zaxxer.hikari.HikariConfig;

public class HikariDataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari.tibero")
    public HikariConfig tibero() {
    	return new HikariConfig();
    }
}