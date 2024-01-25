package nhc.erp.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nhc.erp.sample.vo.SampleVo;

@Mapper
public interface SampleMapper {
	List<SampleVo> selectAll(SampleVo sampleVo);
	
	List<SampleVo> selectPageList(SampleVo sampleVo, Pageable pageable);
	
	Page<SampleVo> selectPage(SampleVo sampleVo, Pageable pageable);
	
	void insertSampleData(SampleVo sampleVo);
	
	void updateSampleData(SampleVo sampleVo);
	
	void deleteSampleData(String id);
}