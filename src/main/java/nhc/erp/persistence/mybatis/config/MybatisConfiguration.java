package nhc.erp.persistence.mybatis.config;

import static prunus.persistence.data.audit.provider.AuditProviderSupport.SUBJECT_PROVIDER_BEAN_NAME;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import nhc.erp.persistence.mybatis.datasource.DataSourceConfig;
import nhc.erp.persistence.mybatis.datasource.HikariDataSourceConfig;
import nhc.erp.persistence.mybatis.provider.AuditingUserDeptProvider;
import nhc.erp.persistence.mybatis.provider.AuditingUserSubjectProvider;
import prunus.persistence.data.audit.provider.AuditingAware;

@Import({HikariDataSourceConfig.class, DataSourceConfig.class})
@MapperScan(basePackages = "nhc.erp", annotationClass = Mapper.class)
@Configuration
public class MybatisConfiguration {
    @Bean(SUBJECT_PROVIDER_BEAN_NAME)
    public AuditingAware<String> auditingUserSubjectProvider() {
        return new AuditingUserSubjectProvider();
    }

    @Bean("auditingDeptProvider")
    public AuditingAware<String> auditingUserDeptProvider() {
        return new AuditingUserDeptProvider();
    }
}