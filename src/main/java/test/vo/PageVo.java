package test.vo;

public class PageVo {
	private int page;
	private int pageSize;
	private String val;
	
	public PageVo() {}

	public PageVo(int page, int pageSize, String val) {
		this.page = page;
		this.pageSize = pageSize;
		this.val = val;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
	
}
