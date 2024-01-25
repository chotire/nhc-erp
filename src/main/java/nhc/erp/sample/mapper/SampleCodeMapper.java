package nhc.erp.sample.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nhc.erp.sample.vo.SampleCodeVo;

@Mapper
public interface SampleCodeMapper {
	int selectCommonCodeCnt(SampleCodeVo sampleCodeVo);
	
	List<Map<String, Object>> selectCommonCodeList(SampleCodeVo sampleCodeVo);
	
	// List<Map<String, Object>> selectCommonCodeList(SampleCodeVo sampleCodeVo, Pageable pageable);
	Page<Map<String, Object>> selectCommonCodeList1(SampleCodeVo sampleCodeVo, Pageable pageable);
	
	List<Map<String, Object>> selectSampleCommonCodeList();
	
	List<Map<String, Object>> selectCodeDetailList(String commonCodeId);
	
	void insertCommonCodeData(SampleCodeVo sampleCodeVo);
	
	void updateCommonCodeData(SampleCodeVo sampleCodeVo);
	
	void deleteCommonCodeData(SampleCodeVo sampleCodeVo);
	
	void deleteCodeDetailList(SampleCodeVo sampleCodeVo);
		
	void insertCodeDetailData(SampleCodeVo sampleCodeVo);
	
	void updateCodeDetailData(SampleCodeVo sampleCodeVo);
	
	void deleteCodeDetailData(SampleCodeVo sampleCodeVo);
}