package nhc.erp.persistence.mybatis.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RoutingDataSource extends AbstractRoutingDataSource {
    public RoutingDataSource(DataSourceResolver dataSourceResolver) {
		Map<String, DataSource> targetDataSouces = dataSourceResolver.getDataSources();
		super.setTargetDataSources(new HashMap<>(targetDataSouces));
		super.setDefaultTargetDataSource(targetDataSouces.get(dataSourceResolver.getDefaultDataSourceName()));
    }

    @Override
    protected Object determineCurrentLookupKey() {
    	return DataSourceNameContextHolder.get();
    }
}
