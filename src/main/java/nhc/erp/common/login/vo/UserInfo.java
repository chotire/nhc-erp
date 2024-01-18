package nhc.erp.common.login.vo;

import java.util.HashMap;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserInfo extends HashMap<String, Object> {

	private String tenant;
	
	private String userId;
	
	private String userNm;
	
	private String deptCd;
	
	private String deptNm;
	
}
