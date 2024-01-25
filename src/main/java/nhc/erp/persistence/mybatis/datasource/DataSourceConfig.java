package nhc.erp.persistence.mybatis.datasource;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;

import com.zaxxer.hikari.HikariConfig;

public class DataSourceConfig {
	public static final String DEFAULT_DATASOURCE_NAME = "tibero";
    private final Map<String, HikariConfig> hikariDataSourceConfig;

    public DataSourceConfig(Map<String, HikariConfig> hikariDataSourceConfig) {
        this.hikariDataSourceConfig = hikariDataSourceConfig;
    }

    @Bean
    public DataSourceResolver dataSourceResolver() {
        return new DataSourceResolver(hikariDataSourceConfig, DEFAULT_DATASOURCE_NAME);
    }

    @Bean
    public DataSource routingDataSource(DataSourceResolver dataSourceResolver) {
        return new RoutingDataSource(dataSourceResolver);
    }
}