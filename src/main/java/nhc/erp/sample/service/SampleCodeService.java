package nhc.erp.sample.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nhc.erp.common.Constants;
import nhc.erp.common.util.StringUtil;
import nhc.erp.sample.mapper.SampleCodeMapper;
import nhc.erp.sample.vo.SampleCodeVo;
import prunus.datasource.annotation.DataSourceName;
import prunus.persistence.data.pagination.Paging;

@Service
@DataSourceName("nhcerp")
public class SampleCodeService {
	@Autowired
	private SampleCodeMapper mapper;

	public Page<Map<String, Object>> selectCommonCodeList(SampleCodeVo sampleCodeVo, Pageable pageable) {
		return new Paging<>(mapper.selectCommonCodeList(sampleCodeVo, pageable));
    }
	
	public List<Map<String, Object>> selectCodeDetailList(String commonCodeId) {
		return mapper.selectCodeDetailList(commonCodeId);
    }
	
	public void saveCommonCodeDetailList(SampleCodeVo sampleCodeVo) throws Exception {
		if (sampleCodeVo.getCommonCodeList().size() > 0) {
			for (int i = 0; i < sampleCodeVo.getCommonCodeList().size(); i++) {
				Map<String, Object> dataMap = sampleCodeVo.getCommonCodeList().get(i);
				
				SampleCodeVo commonCodeTempVo = new SampleCodeVo();
				commonCodeTempVo.setCommonCodeId(StringUtil.nullCheck(dataMap.get("commonCodeId")));
				commonCodeTempVo.setCommonCodeNm(StringUtil.nullCheck(dataMap.get("commonCodeNm")));
				commonCodeTempVo.setUseYn(StringUtil.nullCheck(dataMap.get("useYn")));

				String status = StringUtil.nullCheck(dataMap.get("rowStatus"));
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
			for (int i = 0; i < sampleCodeVo.getCodeDetailList().size(); i++) {
				Map<String, Object> dataMap = sampleCodeVo.getCodeDetailList().get(i);
				
				SampleCodeVo commonCodeTempVo = new SampleCodeVo();
				commonCodeTempVo.setCommonCodeId(StringUtil.nullCheck(sampleCodeVo.getCommonCodeId()));
				commonCodeTempVo.setCode(StringUtil.nullCheck(dataMap.get("code")));
				commonCodeTempVo.setCodeNm(StringUtil.nullCheck(dataMap.get("codeNm")));
				commonCodeTempVo.setCodeSort(StringUtil.nullCheck(dataMap.get("codeSort")));
				commonCodeTempVo.setUseYn(StringUtil.nullCheck(dataMap.get("useYn")));
				commonCodeTempVo.setAttr1(StringUtil.nullCheck(dataMap.get("attr1")));
				commonCodeTempVo.setAttr2(StringUtil.nullCheck(dataMap.get("attr2")));
				commonCodeTempVo.setAttr3(StringUtil.nullCheck(dataMap.get("attr3")));
				commonCodeTempVo.setAttr4(StringUtil.nullCheck(dataMap.get("attr4")));
				commonCodeTempVo.setAttr5(StringUtil.nullCheck(dataMap.get("attr5")));
				commonCodeTempVo.setCodeDesc(StringUtil.nullCheck(dataMap.get("codeDesc")));

				String status = StringUtil.nullCheck(dataMap.get("rowStatus"));
				
				System.out.println("status = " + status);
				
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