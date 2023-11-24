package myProtein.board;

// 리스트 페이지 관련 사용자 설정을 위한 DTO(VO)
public class PageInputDto{
	
	private int rowCountPerPage;   // 테이블(리스트)당 출력 행수
	private int pageCountPerPage;  // 한페이지에 보여지는 페이지 수
	private String selectPage;     // 선택한 현재 페이지 번호
	public PageInputDto() {}
	public PageInputDto(	int rowCountPerPage, 
								int pageCountPerPage,
								String selectPage,
								String searchType,
								String searchContent) {
		this.rowCountPerPage = rowCountPerPage;
		this.pageCountPerPage = pageCountPerPage;
		this.selectPage = selectPage;
	}
	
	public int getRowCountPerPage() {
		return rowCountPerPage;
	}
	public void setRowCountPerPage(int rowCountPerPage) {
		this.rowCountPerPage = rowCountPerPage;
	}
	public int getPageCountPerPage() {
		return pageCountPerPage;
	}
	public void setPageCountPerPage(int pageCountPerPage) {
		this.pageCountPerPage = pageCountPerPage;
	}
	public String getSelectPage() {
		return selectPage;
	}
	public void setSelectPage(String selectPage) {
		this.selectPage = selectPage;
	}
	
	
}