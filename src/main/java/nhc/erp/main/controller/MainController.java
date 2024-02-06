package nhc.erp.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import nhc.erp.common.inswave.util.Result;
import nhc.erp.sample.service.SampleMenuService;
import nhc.erp.sample.vo.SampleMenuVo;

/**
 * @author 이승준
 */
@RestController
public class MainController {
	@Autowired
	private SampleMenuService service;
	
	@PostMapping(value = "/main/init")
	public Map<String, Object> getInitMainInfo() {
		Result result = new Result();
		
		try {
			SampleMenuVo sampleMenuVo = new SampleMenuVo();
			sampleMenuVo.setEmpCd("100001");
			
			List<Map<String, Object>> menuList = service.selectMenuList(sampleMenuVo);
			result.setData("dlt_menu", menuList);
			
			List<Map<String, Object>> favoriteList = service.selectFavoriteListByEmpCd(sampleMenuVo);
			result.setData("dlt_fav", favoriteList);
			
			Map<String, Object> defInfo = new HashMap<String, Object>();
			
			/* 로그인 데이터 시작 */
			defInfo.put("EMP_CD", "100001");
			defInfo.put("EMP_NM", "이승준");
			defInfo.put("IS_ADMIN", "Y");
						
			result.setData("dma_defInfo", defInfo);
			/* 로그인 데이터 끝 */
			
			List<Map<String, Object>> authorityList = service.selectProgramAuthorityList(sampleMenuVo);
			result.setData("dlt_programAuthority", authorityList);
			
			/* 결과 메시지 세팅 */
			result.setStatusMsg(Result.STATUS_SUCESS, "메뉴정보가 조회 되었습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
			result.setMsg(Result.STATUS_ERROR, "");
		}

		return result.getResult();
	}
}
