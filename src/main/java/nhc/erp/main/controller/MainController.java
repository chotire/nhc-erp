package nhc.erp.main.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inswave.wrm.util.Result;

/**
 * @author 이승준
 */
@Controller
public class MainController {
	@PostMapping(value = "/main/init")
	@ResponseBody
	public Map<String, Object> getInitMainInfo() {
		Result result = new Result();
		
		try {
			List<Map<String, Object>> menuList = new ArrayList<Map<String, Object>>();
			Map<String, Object> menuMap = new HashMap<String, Object>();
			
			/* 메뉴관리 시작 */
			menuMap.put("MENU_CD", "001000000");
			menuMap.put("MENU_LEVEL", 1);
			menuMap.put("MENU_NM", "업무화면");
			menuMap.put("PARENT_MENU_CD", "000000000");
			menuMap.put("PROGRAM_CD", "");
			menuMap.put("SRC_PATH", null);
			menuList.add(menuMap);
			
			menuMap = new HashMap<String, Object>();
			menuMap.put("MENU_CD", "001001000");
			menuMap.put("MENU_LEVEL", 2);
			menuMap.put("MENU_NM", "시스템");
			menuMap.put("PARENT_MENU_CD", "001000000");
			menuMap.put("PROGRAM_CD", "");
			menuMap.put("SRC_PATH", null);
			menuList.add(menuMap);
			
			menuMap = new HashMap<String, Object>();
			menuMap.put("MENU_CD", "001001001");
			menuMap.put("MENU_LEVEL", 3);
			menuMap.put("MENU_NM", "코드관리");
			menuMap.put("PARENT_MENU_CD", "001001000");
			menuMap.put("PROGRAM_CD", "BM001M01");
			menuMap.put("SRC_PATH", "/ui/BM/BM001M01.xml");
			menuList.add(menuMap);
			
			menuMap = new HashMap<String, Object>();
			menuMap.put("MENU_CD", "001001002");
			menuMap.put("MENU_LEVEL", 3);
			menuMap.put("MENU_NM", "권한관리");
			menuMap.put("PARENT_MENU_CD", "001001000");
			menuMap.put("PROGRAM_CD", "BM002M01");
			menuMap.put("SRC_PATH", "/ui/BM/BM002M01.xml");
			menuList.add(menuMap);
			
			menuMap = new HashMap<String, Object>();
			menuMap.put("MENU_CD", "001001003");
			menuMap.put("MENU_LEVEL", 3);
			menuMap.put("MENU_NM", "프로그램관리");
			menuMap.put("PARENT_MENU_CD", "001001000");
			menuMap.put("PROGRAM_CD", "BM003M01");
			menuMap.put("SRC_PATH", "/ui/BM/BM003M01.xml");
			menuList.add(menuMap);
			
			menuMap = new HashMap<String, Object>();
			menuMap.put("MENU_CD", "001001004");
			menuMap.put("MENU_LEVEL", 3);
			menuMap.put("MENU_NM", "메뉴관리");
			menuMap.put("PARENT_MENU_CD", "001001000");
			menuMap.put("PROGRAM_CD", "BM004M01");
			menuMap.put("SRC_PATH", "/ui/BM/BM004M01.xml");
			menuList.add(menuMap);
			
			menuMap = new HashMap<String, Object>();
			menuMap.put("MENU_CD", "001001005");
			menuMap.put("MENU_LEVEL", 3);
			menuMap.put("MENU_NM", "릴리즈관리");
			menuMap.put("PARENT_MENU_CD", "001001000");
			menuMap.put("PROGRAM_CD", "BM005M01");
			menuMap.put("SRC_PATH", "/ui/BM/BM005M01.xml");
			menuList.add(menuMap);
			
			menuMap = new HashMap<String, Object>();
			menuMap.put("MENU_CD", "001001006");
			menuMap.put("MENU_LEVEL", 3);
			menuMap.put("MENU_NM", "파일그룹관리");
			menuMap.put("PARENT_MENU_CD", "001001000");
			menuMap.put("PROGRAM_CD", "BM006M01");
			menuMap.put("SRC_PATH", "/ui/BM/BM006M01.xml");
			menuList.add(menuMap);
			
			menuMap = new HashMap<String, Object>();
			menuMap.put("MENU_CD", "001001007");
			menuMap.put("MENU_LEVEL", 3);
			menuMap.put("MENU_NM", "단축키관리");
			menuMap.put("PARENT_MENU_CD", "001001000");
			menuMap.put("PROGRAM_CD", "BM007M01");
			menuMap.put("SRC_PATH", "/ui/BM/BM007M01.xml");
			menuList.add(menuMap);
			
			menuMap = new HashMap<String, Object>();
			menuMap.put("MENU_CD", "001001008");
			menuMap.put("MENU_LEVEL", 3);
			menuMap.put("MENU_NM", "다국어 메시지 관리");
			menuMap.put("PARENT_MENU_CD", "001001000");
			menuMap.put("PROGRAM_CD", "BM008M01");
			menuMap.put("SRC_PATH", "/ui/BM/BM008M01.xml");
			menuList.add(menuMap);
			
			menuMap = new HashMap<String, Object>();
			menuMap.put("MENU_CD", "001002000");
			menuMap.put("MENU_LEVEL", 2);
			menuMap.put("MENU_NM", "인사");
			menuMap.put("PARENT_MENU_CD", "001000000");
			menuMap.put("PROGRAM_CD", "");
			menuMap.put("SRC_PATH", null);
			menuList.add(menuMap);
			
			menuMap = new HashMap<String, Object>();
			menuMap.put("MENU_CD", "001002001");
			menuMap.put("MENU_LEVEL", 3);
			menuMap.put("MENU_NM", "조직관리");
			menuMap.put("PARENT_MENU_CD", "001002000");
			menuMap.put("PROGRAM_CD", "HM001M01");
			menuMap.put("SRC_PATH", "/ui/HM/HM001M01.xml");
			menuList.add(menuMap);
			
			menuMap = new HashMap<String, Object>();
			menuMap.put("MENU_CD", "001002002");
			menuMap.put("MENU_LEVEL", 3);
			menuMap.put("MENU_NM", "사원관리");
			menuMap.put("PARENT_MENU_CD", "001002000");
			menuMap.put("PROGRAM_CD", "HM002M01");
			menuMap.put("SRC_PATH", "/ui/HM/HM002M01.xml");
			menuList.add(menuMap);
			
			menuMap = new HashMap<String, Object>();
			menuMap.put("MENU_CD", "002000000");
			menuMap.put("MENU_LEVEL", 1);
			menuMap.put("MENU_NM", "샘플화면");
			menuMap.put("PARENT_MENU_CD", "000000000");
			menuMap.put("PROGRAM_CD", "SP001M01");
			menuMap.put("SRC_PATH", "/ui/SP/SP001M01.xml");
			menuList.add(menuMap);
			
			result.setData("dlt_menu", menuList);
			/* 메뉴관리 끝 */
			
			List<Map<String, Object>> favList = new ArrayList<Map<String, Object>>();
			Map<String, Object> favMap = new HashMap<String, Object>();
			
			/* 즐겨찾기 시작 */
			favMap.put("MENU_CD", "001001002");
			favMap.put("MENU_NM", "권한관리");
			favMap.put("SRC_PATH", "/ui/BM/BM002M01.xml");
			favList.add(favMap);
			
			favMap = new HashMap<String, Object>();
			favMap.put("MENU_CD", "001001004");
			favMap.put("MENU_NM", "메뉴관리");
			favMap.put("SRC_PATH", "/ui/BM/BM004M01.xml");
			favList.add(favMap);
			
			favMap = new HashMap<String, Object>();
			favMap.put("MENU_CD", "001001001");
			favMap.put("MENU_NM", "코드관리");
			favMap.put("SRC_PATH", "/ui/BM/BM001M01.xml");
			favList.add(favMap);
			
			favMap = new HashMap<String, Object>();
			favMap.put("MENU_CD", "001001003");
			favMap.put("MENU_NM", "프로그램관리");
			favMap.put("SRC_PATH", "/ui/BM/BM003M01.xml");
			favList.add(favMap);
			
			result.setData("dlt_fav", favList);			
			/* 즐겨찾기 끝 */
			
			Map<String, Object> defInfo = new HashMap<String, Object>();
			
			/* 로그인 데이터 시작 */
			defInfo.put("EMP_CD", "100001");
			defInfo.put("EMP_NM", "이승준");
			defInfo.put("IS_ADMIN", "Y");
						
			result.setData("dma_defInfo", defInfo);
			/* 로그인 데이터 끝 */
			
			List<Map<String, Object>> authorityList = new ArrayList<Map<String, Object>>();
			Map<String, Object> authorityMap = new HashMap<String, Object>();
			
			/* 권한 시작 */
			authorityMap.put("IS_AUTH_EXCEL", "Y");
			authorityMap.put("IS_AUTH_SAVE", "Y");
			authorityMap.put("IS_AUTH_SELECT", "Y");
			authorityMap.put("PROGRAM_CD", "BM001M01");
			authorityList.add(authorityMap);
			
			authorityMap = new HashMap<String, Object>();
			authorityMap.put("IS_AUTH_EXCEL", "Y");
			authorityMap.put("IS_AUTH_SAVE", "Y");
			authorityMap.put("IS_AUTH_SELECT", "Y");
			authorityMap.put("PROGRAM_CD", "BM002M01");
			authorityList.add(authorityMap);
			
			authorityMap = new HashMap<String, Object>();
			authorityMap.put("IS_AUTH_EXCEL", "Y");
			authorityMap.put("IS_AUTH_SAVE", "Y");
			authorityMap.put("IS_AUTH_SELECT", "Y");
			authorityMap.put("PROGRAM_CD", "BM003M01");
			authorityList.add(authorityMap);
			
			authorityMap = new HashMap<String, Object>();
			authorityMap.put("IS_AUTH_EXCEL", "Y");
			authorityMap.put("IS_AUTH_SAVE", "Y");
			authorityMap.put("IS_AUTH_SELECT", "Y");
			authorityMap.put("PROGRAM_CD", "BM004M01");
			authorityList.add(authorityMap);
			
			authorityMap = new HashMap<String, Object>();
			authorityMap.put("IS_AUTH_EXCEL", "Y");
			authorityMap.put("IS_AUTH_SAVE", "Y");
			authorityMap.put("IS_AUTH_SELECT", "Y");
			authorityMap.put("PROGRAM_CD", "BM005M01");
			authorityList.add(authorityMap);
			
			authorityMap = new HashMap<String, Object>();
			authorityMap.put("IS_AUTH_EXCEL", "Y");
			authorityMap.put("IS_AUTH_SAVE", "Y");
			authorityMap.put("IS_AUTH_SELECT", "Y");
			authorityMap.put("PROGRAM_CD", "BM006M01");
			authorityList.add(authorityMap);
			
			authorityMap = new HashMap<String, Object>();
			authorityMap.put("IS_AUTH_EXCEL", "Y");
			authorityMap.put("IS_AUTH_SAVE", "Y");
			authorityMap.put("IS_AUTH_SELECT", "Y");
			authorityMap.put("PROGRAM_CD", "BM007M01");
			authorityList.add(authorityMap);
			
			authorityMap = new HashMap<String, Object>();
			authorityMap.put("IS_AUTH_EXCEL", "Y");
			authorityMap.put("IS_AUTH_SAVE", "Y");
			authorityMap.put("IS_AUTH_SELECT", "Y");
			authorityMap.put("PROGRAM_CD", "BM008M01");
			authorityList.add(authorityMap);
			
			authorityMap = new HashMap<String, Object>();
			authorityMap.put("IS_AUTH_EXCEL", "Y");
			authorityMap.put("IS_AUTH_SAVE", "Y");
			authorityMap.put("IS_AUTH_SELECT", "Y");
			authorityMap.put("PROGRAM_CD", "HM001M01");
			authorityList.add(authorityMap);
			
			authorityMap = new HashMap<String, Object>();
			authorityMap.put("IS_AUTH_EXCEL", "Y");
			authorityMap.put("IS_AUTH_SAVE", "Y");
			authorityMap.put("IS_AUTH_SELECT", "Y");
			authorityMap.put("PROGRAM_CD", "HM002M01");
			authorityList.add(authorityMap);
			
			authorityMap = new HashMap<String, Object>();
			authorityMap.put("IS_AUTH_EXCEL", "Y");
			authorityMap.put("IS_AUTH_SAVE", "Y");
			authorityMap.put("IS_AUTH_SELECT", "Y");
			authorityMap.put("PROGRAM_CD", "HM003M01");
			authorityList.add(authorityMap);
			
			authorityMap = new HashMap<String, Object>();
			authorityMap.put("IS_AUTH_EXCEL", "Y");
			authorityMap.put("IS_AUTH_SAVE", "Y");
			authorityMap.put("IS_AUTH_SELECT", "Y");
			authorityMap.put("PROGRAM_CD", "SP001M01");
			authorityList.add(authorityMap);
			
			result.setData("dlt_programAuthority", authorityList);
			/* 권한 끝 */
			
			result.setStatusMsg(result.STATUS_SUCESS, "메뉴정보가 조회 되었습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
			result.setMsg(result.STATUS_ERROR, "");
		}

		return result.getResult();
	}
}