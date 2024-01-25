package nhc.erp.sample.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import nhc.erp.sample.vo.SampleMenuVo;

@Mapper
public interface SampleMenuMapper {
	List<Map<String, Object>> selectMenuList(SampleMenuVo sampleMenuVo);
	
	List<Map<String, Object>> selectFavoriteListByEmpCd(SampleMenuVo sampleMenuVo);
	
	List<Map<String, Object>> selectProgramAuthorityList(SampleMenuVo sampleMenuVo);
}