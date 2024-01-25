package nhc.erp.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nhc.erp.sample.mapper.SampleMapper;
import nhc.erp.sample.vo.SampleVo;
import prunus.persistence.data.pagination.Paging;

@Service
// @DataSourceName("nhcerp")
public class SampleService {
	@Autowired
	private SampleMapper mapper;

    public List<SampleVo> getAll(SampleVo sampleVo) {
        return mapper.selectAll(sampleVo);
    }
    
    public List<SampleVo> getPageList(SampleVo sampleVo, Pageable pageable) {
        return mapper.selectPageList(sampleVo, pageable);
    }
    
    public Page<SampleVo> getPage(SampleVo sampleVo, Pageable pageable) {
    	return new Paging<>(mapper.selectPage(sampleVo, pageable));
    }
    
    public void insertSampleData(SampleVo sampleVo) {
    	mapper.insertSampleData(sampleVo);
    }
    
    public void updateSampleData(SampleVo sampleVo) {
    	mapper.updateSampleData(sampleVo);
    }
    
    public void deleteSampleData(String id) {
    	mapper.deleteSampleData(id);
    }
}