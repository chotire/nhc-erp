package nhc.erp.persistence.mybatis.entity;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import prunus.persistence.data.audit.entity.AuditableEntity;

@Getter
@Setter
@AttributeOverrides({
	@AttributeOverride(name="createdBy", column=@Column(name="CRE_USER")),
	@AttributeOverride(name="creDate", column=@Column(name="CRE_DATE")),
	@AttributeOverride(name="modifiedBy", column=@Column(name="MOD_USER")),
	@AttributeOverride(name="modDate", column=@Column(name="MOD_DATE"))
})
public class AuditEntity extends AuditableEntity {
	@PersistDept
	@Column(name="CRE_DEPT")
	private String createDept;
	
	@UpdateDept
	@Column(name="MOD_DEPT")
	private String updateDept;
	
	@CreDate
	@Column(name="CRE_DATE")
	private String creDate;
	
	@ModDate
	@Column(name="MOD_DATE")
	private String modDate;
	
}