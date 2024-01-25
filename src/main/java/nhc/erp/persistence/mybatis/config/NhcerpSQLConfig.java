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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@MapperScan(value = "nhc.erp",
annotationClass= NhcerpSQLConnMapper.class,
sqlSessionFactoryRef = "NhcerpSQLSessionFactory")
@Configuration
public class NhcerpSQLConfig {
	@Primary
	@Bean(name = "NhcerpSQLDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.nhcerp")
    public DataSource nhcerpDataSource() {
        return DataSourceBuilder.create().build();
    }

	@Primary
    @Bean(name = "NhcerpSQLSessionFactory")
    public SqlSessionFactory nhcerpSqlSessionFactory(
    		@Qualifier("NhcerpSQLDataSource")
    		DataSource tiberoDataSource) throws Exception {
    	SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    	sqlSessionFactoryBean.setDataSource(tiberoDataSource);
    	sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/**/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("nhc.erp");
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name = "NhcerpSQLSessionTemplate")
    public SqlSessionTemplate nhcerpSqlSessionTemplate(
    		@Qualifier("NhcerpSQLSessionFactory")
    		SqlSessionFactory tiberoSessionTemplate) {
    	return new SqlSessionTemplate(tiberoSessionTemplate);
    }

    @Primary
    @Bean(name = "NhcerpSQLTransactionManager")
    public DataSourceTransactionManager PrimaryTransactionManager(
            @Qualifier("NhcerpSQLDataSource")
            DataSource tiberoDataSource) {
    	return new DataSourceTransactionManager(tiberoDataSource);
    }
}
