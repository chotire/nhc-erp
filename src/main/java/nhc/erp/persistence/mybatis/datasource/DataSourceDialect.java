package nhc.erp.persistence.mybatis.datasource;

import org.apache.ibatis.mapping.MappedStatement;
import org.springframework.context.annotation.Bean;

import com.github.miemiedev.mybatis.paginator.dialect.Dialect;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import prunus.persistence.mybatis.pagination.interceptor.PagingDialect;
import prunus.persistence.mybatis.pagination.interceptor.dialect.TiberoDialect;

public class DataSourceDialect extends Dialect {
	public DataSourceDialect(MappedStatement mappedStatement, Object parameterObject, PageBounds pageBounds) {
		super(mappedStatement, parameterObject, pageBounds);
	}
	
	@Bean
	public PagingDialect tiberoDialect() {
		return new PagingDialect(TiberoDialect.class);
	}
}