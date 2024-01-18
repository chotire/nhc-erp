package nhc.erp.sample.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import nhc.erp.persistence.mybatis.entity.AuditEntity;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SampleMenuVo extends AuditEntity {
	private String empCd;
}