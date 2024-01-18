package nhc.erp.persistence.mybatis.provider;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import prunus.persistence.data.audit.provider.AuditingAware;

public class AuditingCurrentDateTimeProvider implements AuditingAware<String> {
    @Override
    public String provide() {
    	LocalDateTime dateTime = LocalDateTime.now();
    	String dateTimeStr = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        return dateTimeStr;
    }
}