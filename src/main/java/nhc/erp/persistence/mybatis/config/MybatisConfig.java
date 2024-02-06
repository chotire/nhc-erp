package nhc.erp.persistence.mybatis.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = "nhc.erp", annotationClass = Mapper.class)
@Configuration
public class MybatisConfig {

}
