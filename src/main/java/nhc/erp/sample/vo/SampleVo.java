package nhc.erp.sample.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class SampleVo extends AuditEntity {
	private long id;

    private String vendor;

    private int displaySize;

    @JsonIgnore
    private boolean deleted;
    
    @JsonIgnore
    private String createdBy;
    
    @JsonIgnore
    private LocalDateTime createdDate;
    
    @JsonIgnore
    private String creDate;
    
    @JsonIgnore
    private String createdRemoteAddr;
    
    @JsonIgnore
    private String createDept;
    
    @JsonIgnore
    private String modifiedBy;
    
    @JsonIgnore
    private LocalDateTime modifiedDate;
    
    @JsonIgnore
    private String modDate;
    
    @JsonIgnore
    private String modifiedRemoteAddr;
    
    @JsonIgnore
    private String updateDept;
}