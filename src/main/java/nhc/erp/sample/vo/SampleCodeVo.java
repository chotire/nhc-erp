package nhc.erp.sample.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SampleCodeVo {
	private String searchCondition;
	private String searchKeyword;
	
	private List<Map<String, Object>> commonCodeList = new ArrayList<Map<String, Object>>();
	private List<Map<String, Object>> codeDetailList = new ArrayList<Map<String, Object>>();
	
	private String commonCodeId;
	private String commonCodeNm;
	private String useYn;
	
	private String code;
	private String codeNm;
	private String codeSort;
	private String attr1;
	private String attr2;
	private String attr3;
	private String attr4;
	private String attr5;
	private String codeDesc;
}