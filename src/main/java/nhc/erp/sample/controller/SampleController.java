package nhc.erp.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nhc.erp.common.login.annotation.LoginInfo;
import nhc.erp.common.login.vo.UserInfo;
import nhc.erp.sample.service.SampleService;
import nhc.erp.sample.vo.SampleVo;

/**
 * @author 이승준
 */
@RestController
public class SampleController {
	@Autowired
	private SampleService service;

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
    	
    	System.out.println(userInfo.toString());
    	
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
    @DeleteMapping("/deleteSampleData/{id}")
    public void deleteSampleData(@PathVariable String id) {
        service.deleteSampleData(id);
    }
}