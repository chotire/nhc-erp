package nhc.erp.sample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nhc.erp.common.inswave.util.Result;
import nhc.erp.common.login.annotation.LoginInfo;
import nhc.erp.common.login.vo.UserInfo;
import nhc.erp.common.util.StringUtil;
import nhc.erp.sample.service.SampleCodeService;
import nhc.erp.sample.service.SampleService;
import nhc.erp.sample.vo.SampleCodeParam;
import nhc.erp.sample.vo.SampleCodeVo;
import nhc.erp.sample.vo.SampleVo;

/**
 * @author 이승준
 */
@RestController
public class SampleController {
	@Autowired
	private SampleService service;
	
	@Autowired
	private SampleCodeService codeService;

	/*
	 * GET
	 * http://localhost:8080/sample?vendor=lg
	 */
    @GetMapping(value = "/sample")
    public List<SampleVo> getAll(SampleVo sampleVo) {
        return service.getAll(sampleVo);
    }
    
    /*
     * GET
     * http://localhost:8080/samplePageList?vendor=lg&page=2&size=10&sort=id,ASC&sort=displaySize,ASC
     */
    @GetMapping(value = "/samplePageList")
    public List<SampleVo> getPageList(SampleVo sampleVo, Pageable pageable, @LoginInfo UserInfo userInfo) {
    	System.err.println(userInfo.toString());
    	return service.getPageList(sampleVo, pageable);
    }
    
    /*
     * GET
     * http://localhost:8080/samplePage?vendor=lg&page=1&size=10&sort=id,ASC&sort=displaySize,ASC
     */
    @GetMapping(value = "/samplePage")
    public Page<SampleVo> getPage(SampleVo sampleVo, Pageable pageable) {
    	return service.getPage(sampleVo, pageable);
    }
    
    /*
     * POST
     * http://localhost:8080/insertSampleData
     * BODY : {"vendor": "lg", "displaySize": 15}
     */
    @PostMapping(value = "/insertSampleData")
    public void insertSampleData(@RequestBody SampleVo sampleVo) {
        service.insertSampleData(sampleVo);
    }
    
    /*
     * POST
     * http://localhost:8080/updateSampleData
     * BODY : {"id": 106, "vendor": "samsung", "displaySize": 20}
     */
    @PostMapping(value = "/updateSampleData")
    public void updateSampleData(@RequestBody SampleVo sampleVo) {
        service.updateSampleData(sampleVo);
    }
    
    /*
     * DELETE
     * http://localhost:8080/deleteSampleData/106
     */
    @DeleteMapping(value = "/deleteSampleData/{id}")
    public void deleteSampleData(@PathVariable String id) {
        service.deleteSampleData(id);
    }
    
    @PostMapping("/sample/useYnList")
	public Map<String, Object> getUseYnList() {
		Result result = new Result();
		try {
			List<Map<String, Object>> useYnList = new ArrayList<Map<String,Object>>();
			
			Map<String, Object> useYnMap = new HashMap<String, Object>();
			useYnMap.put("code", "Y");
			useYnMap.put("codeNm", "사용");
			useYnList.add(useYnMap);
			
			useYnMap = new HashMap<String, Object>();
			useYnMap.put("code", "N");
			useYnMap.put("codeNm", "사용안함");
			useYnList.add(useYnMap);
			
			result.setData("useYnList", useYnList);
			
			/* 결과 메시지 세팅 */
			result.setStatusMsg(result.STATUS_SUCESS, "코드정보가 조회 되었습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
			result.setMsg(result.STATUS_ERROR, "");
		}
		
		return result.getResult();
	}
    
    @PostMapping(value = "/sample/commonCode/commonCodeList")
    @SuppressWarnings("unchecked")
	public Map<String, Object> getCommonCodeList(@RequestBody Map<String, Object> param) {
		Result result = new Result();
		
		try {
			Map<String, Object> searchMap = (Map<String, Object>)param.get("searchMap");
			String searchCondition = StringUtil.nullCheck(searchMap.get("searchCondition"));
			String searchKeyword = StringUtil.nullCheck(searchMap.get("searchKeyword"));

			Map<String, Object> paginationhMap = (Map<String, Object>)param.get("pagination");
			String page = StringUtil.nullCheck(paginationhMap.get("page"));
			String size = StringUtil.nullCheck(paginationhMap.get("size"));
			
			SampleCodeVo sampleCodeVo = new SampleCodeVo();
			sampleCodeVo.setSearchCondition(searchCondition);
			sampleCodeVo.setSearchKeyword(searchKeyword);
			sampleCodeVo.setPage(Integer.parseInt(page));
			sampleCodeVo.setSize(Integer.parseInt(size));
			
			int totalCnt = codeService.selectCommonCodeCnt(sampleCodeVo);
			
			List<Map<String, Object>> codeList = new ArrayList<Map<String, Object>>(); 
			if (totalCnt > 0) {
				codeList = codeService.selectCommonCodeList(sampleCodeVo);
			}			
			result.setData("totalCnt", String.valueOf(totalCnt));
			result.setData("commonCodeList", codeList);
			
			/* 결과 메시지 세팅 */
			result.setStatusMsg(result.STATUS_SUCESS, "코드정보가 조회 되었습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
			result.setMsg(result.STATUS_ERROR, "");
		}

		return result.getResult();
	}
    
    @PostMapping(value = "/sample/commonCode/commonCodeList1")
    @SuppressWarnings("unchecked")
	public Map<String, Object> getCommonCodeList1(@RequestBody SampleCodeParam param) {
		Result result = new Result();
		
		try {
			Map<String, Object> searchMap = (Map<String, Object>)param.getSearchMap();
			String searchCondition = StringUtil.nullCheck(searchMap.get("searchCondition"));
			String searchKeyword = StringUtil.nullCheck(searchMap.get("searchKeyword"));
			
			SampleCodeVo sampleCodeVo = new SampleCodeVo();
			sampleCodeVo.setSearchCondition(searchCondition);
			sampleCodeVo.setSearchKeyword(searchKeyword);
			
			Page<Map<String, Object>> codeList = codeService.selectCommonCodeList1(sampleCodeVo, param.getPagination().pageable());
			result.setData("totalCnt", String.valueOf(codeList.getTotalElements()));
			result.setData("commonCodeList", codeList.getContent());
			
			/* 결과 메시지 세팅 */
			result.setStatusMsg(result.STATUS_SUCESS, "코드정보가 조회 되었습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
			result.setMsg(result.STATUS_ERROR, "");
		}

		return result.getResult();
	}
    
    @PostMapping(value = "/sample/sampleCommonCode/commonCodeList")
	public Map<String, Object> getSampleCommonCodeList() {
		Result result = new Result();
		
		try {
			List<Map<String, Object>> codeList = codeService.selectSampleCommonCodeList();
			// result.setData("totalCnt", String.valueOf(codeList.getTotalElements()));
			// result.setData("commonCodeList", codeList.getContent());
			
			/* 결과 메시지 세팅 */
			result.setStatusMsg(result.STATUS_SUCESS, "코드정보가 조회 되었습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
			result.setMsg(result.STATUS_ERROR, "");
		}

		return result.getResult();
	}
    
    @PostMapping(value = "/sample/commonCode/selectCodeDetailList")
    @SuppressWarnings("unchecked")
	public Map<String, Object> selectCodeDetailList(@RequestBody Map<String, Object> param) {
    	Result result = new Result();
		
		try {
			Map<String, Object> commonCodeMap = (Map<String, Object>)param.get("commonCodeMap");
			String commonCodeId = (String)commonCodeMap.get("commonCodeId");
			
			List<Map<String, Object>> codeList = codeService.selectCodeDetailList(commonCodeId);
			result.setData("codeDetailList", codeList);
			
			/* 결과 메시지 세팅 */
			result.setStatusMsg(result.STATUS_SUCESS, "코드정보가 조회 되었습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
			result.setMsg(result.STATUS_ERROR, "");
		}

		return result.getResult();
	}
    
    @PostMapping(value = "/sample/commonCode/saveCommonCodeDetailList")
    @SuppressWarnings("unchecked")
	public Map<String, Object> saveCommonCodeDetailList(@RequestBody Map<String, Object> param) {
    	Result result = new Result();
		
		try {
			Map<String, Object> commonCodeMap = (Map<String, Object>)param.get("commonCodeMap");
			String commonCodeId = (String)commonCodeMap.get("commonCodeId");
			
			List<Map<String, Object>> commonCodeList = (List<Map<String, Object>>)param.get("commonCodeList");
			List<Map<String, Object>> codeDetailList = (List<Map<String, Object>>)param.get("codeDetailList");
			
			SampleCodeVo sampleCodeVo = new SampleCodeVo();
			sampleCodeVo.setCommonCodeId(commonCodeId);
			sampleCodeVo.setCommonCodeList(commonCodeList);
			sampleCodeVo.setCodeDetailList(codeDetailList);
			
			codeService.saveCommonCodeDetailList(sampleCodeVo);
			
			/* 결과 메시지 세팅 */
			result.setStatusMsg(result.STATUS_SUCESS, "코드정보가 저장 되었습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
			result.setMsg(result.STATUS_ERROR, "");
		}

		return result.getResult();
	}
}