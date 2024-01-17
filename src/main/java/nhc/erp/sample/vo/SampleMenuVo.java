package nhc.erp.sample.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nhc.erp.persistence.mybatis.entity.AuditEntity;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleMenuVo extends AuditEntity {
	private String empCd;
	
    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}