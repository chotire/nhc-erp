package nhc.erp.persistence.mybatis.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@MapperScan(value = "nhc.erp",
annotationClass= WrmSQLConnMapper.class,
sqlSessionFactoryRef = "WrmSQLSessionFactory")
@Configuration
public class WrmSQLConfig {
	@Bean(name = "WrmSQLDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.wrm")
    public DataSource WrmDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "WrmSQLSessionFactory")
    public SqlSessionFactory WrmSqlSessionFactory(
    		@Qualifier("WrmSQLDataSource")
    		DataSource mariaDataSource) throws Exception {
    	SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    	sqlSessionFactoryBean.setDataSource(mariaDataSource);
    	sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/**/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("nhc.erp");
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "WrmSQLSessionTemplate")
    public SqlSessionTemplate WrmSqlSessionTemplate(
    		@Qualifier("WrmSQLSessionFactory")
    		SqlSessionFactory mariaSessionTemplate) {
    	return new SqlSessionTemplate(mariaSessionTemplate);
    }

    @Bean(name = "WrmSQLTransactionManager")
    public DataSourceTransactionManager PrimaryTransactionManager(
            @Qualifier("WrmSQLDataSource")
            DataSource mariaDataSource) {
    	return new DataSourceTransactionManager(mariaDataSource);
    }
}
