package nhc.erp.sample.vo;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import prunus.persistence.data.pagination.Pagination;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SampleCodeParam {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> searchMap;
	private Pagination pagination;
}