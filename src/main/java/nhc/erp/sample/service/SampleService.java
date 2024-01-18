package nhc.erp.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nhc.erp.sample.mapper.SampleMapper;
import nhc.erp.sample.vo.SampleVo;
import prunus.datasource.annotation.DataSourceName;
import prunus.persistence.data.pagination.Paging;

@Service
@DataSourceName("nhcerp")
public class SampleService {
	@Autowired
	private SampleMapper mapper;

    public List<SampleVo> getAll(SampleVo sampleVo) {
        // DataSourceNameContextHolder.set("tibero");
        return mapper.selectAll(sampleVo);
    }
    
    public List<SampleVo> getPageList(SampleVo sampleVo, Pageable pageable) {
        // DataSourceNameContextHolder.set("tibero");
        return mapper.selectPageList(sampleVo, pageable);
    }
    
    public Page<SampleVo> getPage(SampleVo sampleVo, Pageable pageable) {
    	// DataSourceNameContextHolder.set("tibero");
        return new Paging<>(mapper.selectPage(sampleVo, pageable));
    }
    
    public void insertSampleData(SampleVo sampleVo) {
    	// DataSourceNameContextHolder.set("tibero");
        mapper.insertSampleData(sampleVo);
    }
    
    public void updateSampleData(SampleVo sampleVo) {
    	// DataSourceNameContextHolder.set("tibero");
        mapper.updateSampleData(sampleVo);
    }
    
    public void deleteSampleData(String id) {
    	// DataSourceNameContextHolder.set("tibero");
        mapper.deleteSampleData(id);
    }
}