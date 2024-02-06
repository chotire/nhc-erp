package nhc.erp.sample.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nhc.erp.common.Constants;
import nhc.erp.sample.mapper.SampleCodeMapper;
import nhc.erp.sample.vo.SampleCodeVo;
import prunus.persistence.data.pagination.Paging;

@Service
public class SampleCodeService {
	@Autowired
	private SampleCodeMapper mapper;
	
	public Page<Map<String, Object>> selectCommonCodeList(SampleCodeVo sampleCodeVo, Pageable pageable) {
		return new Paging<>(mapper.selectCommonCodeList(sampleCodeVo, pageable));
    }
	
	public int selectCommonCodeCnt(SampleCodeVo sampleCodeVo) {
		return mapper.selectCommonCodeCnt(sampleCodeVo);
    }
	
	public List<Map<String, Object>> selectCommonCodeList1(SampleCodeVo sampleCodeVo) {
		return mapper.selectCommonCodeList1(sampleCodeVo);
    }
	
	public List<Map<String, Object>> selectSampleCommonCodeList() {
		return mapper.selectSampleCommonCodeList();
    }
	
	public List<Map<String, Object>> selectCodeDetailList(String commonCodeId) {
		return mapper.selectCodeDetailList(commonCodeId);
    }
	
	@Transactional
	public void saveCommonCodeDetailList(SampleCodeVo sampleCodeVo) throws Exception {
		if (sampleCodeVo.getCommonCodeList().size() > 0) {
			for (Map<String, Object> dataMap : sampleCodeVo.getCommonCodeList()) {
				SampleCodeVo commonCodeTempVo = new SampleCodeVo();
				commonCodeTempVo.setCommonCodeId(Objects.toString(dataMap.get("commonCodeId")));
				commonCodeTempVo.setCommonCodeNm(Objects.toString(dataMap.get("commonCodeNm")));
				commonCodeTempVo.setUseYn(Objects.toString(dataMap.get("useYn")));

				String status = Objects.toString(dataMap.get("rowStatus"));
				if (Constants.DATA_STATUS_CREATE.equals(status)) {
					mapper.insertCommonCodeData(commonCodeTempVo);
				} else if (Constants.DATA_STATUS_UPDATE.equals(status)) {
					mapper.updateCommonCodeData(commonCodeTempVo);
				} else if (Constants.DATA_STATUS_DELETE.equals(status)) {
					mapper.deleteCodeDetailList(commonCodeTempVo);
					mapper.deleteCommonCodeData(commonCodeTempVo);
				}
			}
		}

		if (sampleCodeVo.getCodeDetailList().size() > 0) {
			for (Map<String, Object> dataMap : sampleCodeVo.getCodeDetailList()) {
				SampleCodeVo commonCodeTempVo = new SampleCodeVo();
				commonCodeTempVo.setCommonCodeId(Objects.toString(sampleCodeVo.getCommonCodeId()));
				commonCodeTempVo.setCode(Objects.toString(dataMap.get("code")));
				commonCodeTempVo.setCodeNm(Objects.toString(dataMap.get("codeNm")));
				commonCodeTempVo.setCodeSort(Objects.toString(dataMap.get("codeSort")));
				commonCodeTempVo.setUseYn(Objects.toString(dataMap.get("useYn")));
				commonCodeTempVo.setAttr1(Objects.toString(dataMap.get("attr1")));
				commonCodeTempVo.setAttr2(Objects.toString(dataMap.get("attr2")));
				commonCodeTempVo.setAttr3(Objects.toString(dataMap.get("attr3")));
				commonCodeTempVo.setAttr4(Objects.toString(dataMap.get("attr4")));
				commonCodeTempVo.setAttr5(Objects.toString(dataMap.get("attr5")));
				commonCodeTempVo.setCodeDesc(Objects.toString(dataMap.get("codeDesc")));

				String status = Objects.toString(dataMap.get("rowStatus"));
				
				if (Constants.DATA_STATUS_CREATE.equals(status)) {
					mapper.insertCodeDetailData(commonCodeTempVo);
				} else if (Constants.DATA_STATUS_UPDATE.equals(status)) {
					mapper.updateCodeDetailData(commonCodeTempVo);
				} else if (Constants.DATA_STATUS_DELETE.equals(status)) {
					mapper.deleteCodeDetailData(commonCodeTempVo);
				}
			}
		}
    }
}
