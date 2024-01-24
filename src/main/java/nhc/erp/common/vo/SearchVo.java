package nhc.erp.common.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class SearchVo implements Serializable {
	/**
	 * serialVersion UID
	 */
	private static final long serialVersionUID = 1L;

	/* 현재페이지 */
	private int page = 1;

	/* 페이지사이즈 */
	private int size = 10;

	private int firstRecordIndex = 0;
	private int lastRecordIndex = 0;

    public int getFirstRecordIndex() {
		firstRecordIndex = (getPage() - 1) * getSize();
		return firstRecordIndex;
	}

	public int getLastRecordIndex() {
		lastRecordIndex = getPage() * getSize();
		return lastRecordIndex;
	}
}