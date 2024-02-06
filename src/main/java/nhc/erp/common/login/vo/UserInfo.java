package nhc.erp.common.login.vo;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class UserInfo extends HashMap<String, Object> {
    private String tenant;
	private String userId;
	private String userNm;
	private String deptCd;
	private String deptNm;
}
