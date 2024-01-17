package nhc.erp.sample.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhc.erp.persistence.mybatis.datasource.DataSourceNameContextHolder;
import nhc.erp.sample.mapper.SampleMenuMapper;
import nhc.erp.sample.vo.SampleMenuVo;

@Service
public class SampleMenuService {
	@Autowired
	private SampleMenuMapper mapper;

	public List<Map<String, Object>> selectMenuList(SampleMenuVo sampleMenuVo) {
        DataSourceNameContextHolder.set("tibero");
        return mapper.selectMenuList(sampleMenuVo);
    }
	
	public List<Map<String, Object>> selectFavoriteListByEmpCd(SampleMenuVo sampleMenuVo) {
        DataSourceNameContextHolder.set("tibero");
        return mapper.selectFavoriteListByEmpCd(sampleMenuVo);
    }
	
	public List<Map<String, Object>> selectProgramAuthorityList(SampleMenuVo sampleMenuVo) {
        DataSourceNameContextHolder.set("tibero");
        return mapper.selectProgramAuthorityList(sampleMenuVo);
    }
}