package myProtein.board.util;

public class PageMaker {
	// 페이지당 게시물 수
	public static final int PAGE_SCALE = 10;
	// 화면당 페이지 수
	public static final int BLOCK_SCALE = 10;
	private int totCount;  //전체게시물수
	private int curPage; // 현재 페이지
	private int prevPage; // 이전 페이지
	private int nextPage; // 다음 페이지
	private int prevGroupStartPage; // 이전 그룹시작페이지
	private int nextGroupStartPage; // 다음 그룹시작페이지
	private int totPage; // 전체 페이지 갯수
	private int totBlock; // 전체 페이지 블록 갯수
	private int curBlock; // 현재 페이지 블록
	// [이전] blockBegin -> 41 42 43 44 45 46 47 48 49 50 [다음]
	private int blockBegin; // 현재 페이지 블록의 시작번호
	// [이전] 41 42 43 44 45 46 47 48 49 50 <- blockEnd [다음]
	private int blockEnd; // 현재 페이지 블록의 끝번호
	
	private int prevBlock; // 이전 페이지 블록
	private int nextBlock; // 다음 페이지 블록
	

	
	// WHERE rn BETWEEN #{start} AND #{end}
	private int pageBegin; // #{start}
	private int pageEnd; // #{end}
	// 생성자
	// PageMaker(게시물 갯수, 현재 페이지 번호)
	
	public PageMaker(int count, int curPage) {
		curBlock = 1; // 현재 페이지 블록 번호
		this.totCount=count;
		setTotPage();// 전체 페이지 갯수 계산
		if (curPage > totPage) {
			// 현재페이지가 전체페이지보다크면 전체페이지를현재페이지로설정
			this.curPage = totPage;
		} else if (curPage < 0) {
			// 현재페이지가 음수이면 현재페이지를 1로설정
			this.curPage = 1;
		} else {
			this.curPage = curPage; // 현재 페이지 설정
		}

		setPageRange();
		setTotBlock(this.totPage); // 전체 페이지 블록 갯수 계산
		setBlockRange(); // 페이지 블록의 시작, 끝 번호 계산
		System.out.println();

		System.out.println(this.curPage+" 페이지("+pageBegin+" ~ "+pageEnd+")");
		System.out.println("***************페이지정보***********************************");
		System.out.println("01.화면당 페이지 수(BLOCK_SCALE):	"+BLOCK_SCALE);
		System.out.println("02.한페이지당 게시물 수(PAGE_SCALE):	"+PAGE_SCALE);
		System.out.println("03.현재(요청)페이지번호(curPage):	"+this.curPage);
		System.out.println("04.전체게시물수(totCount):		"+this.totCount);
		System.out.println("05.전체페이지수(totPage):		"+this.totPage);
		System.out.println("06.전체페이지블록수(totBlock):   "+this.totBlock);
		System.out.println("06.현재(요청)페이지블록번호(curBlock):			"+this.curBlock);
		System.out.println("07.현재(요청)페이지블록시작번호(blockBegin):	"+this.blockBegin);
		System.out.println("08.현재(요청)페이지블록끝번호(blockEnd):	"+this.blockEnd);
		System.out.println("09.이전블록시작페이지번호(prevGroupStartPage):  "+this.prevGroupStartPage);
		System.out.println("10.다음블록시작페이지번호(nextGroupStartPage):  "+this.nextGroupStartPage);
		System.out.println("11.이전페이지번호(prevPage):			"+this.prevPage);
		System.out.println("12.다음페이지번호(nextPage):			"+this.nextPage);
		System.out.println("13.DB에서select할게시물시작번호(pageBegin):"+this.pageBegin);
		System.out.println("14.DB에서select할게시물끝번호(pageEnd):   "+this.pageEnd);
		
		System.out.println("*************************************************************");

	}

	public void setTotPage() {
		// Math.ceil(실수) 올림 처리
		totPage = (int) Math.ceil(this.totCount * 1.0 / PAGE_SCALE);
	}

	public void setPageRange() {
		// WHERE rn BETWEEN #{start} AND #{end}
		// 시작번호 = (현재페이지-1)*페이지당 게시물수 +1
		pageBegin = (curPage - 1) * PAGE_SCALE + 1;
		// 끝번호 = 시작번호+페이지당 게시물수 -1
		pageEnd = pageBegin + PAGE_SCALE - 1;
		if(pageEnd>totCount) {
			pageEnd=totCount;
		}
	}

	// 페이지 블록의 갯수 계산(총 91페이지이고 화면당 페이지 수10개이면 10개의 블록)
	public void setTotBlock(int page) {
		// 전체 페이지 갯수(91) / 화면당 페이지 수(10)
		// 91 / 10 => 9.1 => 10개
		this.totBlock = (int) Math.ceil(page*1.0 / BLOCK_SCALE);
	}

	public void setBlockRange() {
		// *현재 페이지가 몇번째 페이지 블록에 속하는지 계산
		curBlock = (int) Math.ceil((curPage - 1) / BLOCK_SCALE) + 1;
		// *현재 페이지 블록의 시작, 끝 번호 계산
		blockBegin = (curBlock - 1) * BLOCK_SCALE + 1;
		// 페이지 블록의 끝번호
		blockEnd = blockBegin + BLOCK_SCALE - 1;
		// *마지막 블록이 범위를 초과하지 않도록 계산
		if (blockEnd > totPage)
			blockEnd = totPage;
		// *이전을 눌렀을 때 이동할 페이지 번호
		prevPage = curPage - 1;
		// *다음을 눌렀을 때 이동할 페이지 번호
		nextPage = curPage + 1;
		// 마지막 페이지가 범위를 초과하지 않도록 처리
		/***********************************************/
		// 이전다음 화면그룹의 시작페이지와 끝페이지
		prevGroupStartPage = blockBegin - BLOCK_SCALE;
		// if(prevGroupStartPage < 0){// groupNo이 0인 경우(페이지 인덱스가 0~10사이)
		// prevGroupStartPage = 0;
		// }
		nextGroupStartPage = blockBegin + BLOCK_SCALE;
		// if(nextGroupStartPage > totPage)nextGroupStartPage=totPage;
		/***********************************************/
	}

	/*
	 * 이전그룹존재하는지여부
	 */
	public boolean isShowPreviousGroup() {
		if (prevGroupStartPage > 0) {
			return true;
		}
		return false;
	}

	/*
	 * 다음그룹존재하는지여부
	 */
	public boolean isShowNextGroup() {
		if (totPage > nextGroupStartPage) {
			return true;
		}
		return false;
	}
	// Getter/Setter
	
	public int getPrevGroupStartPage() {
		return prevGroupStartPage;
	}

	

	public int getTotCount() {
		return totCount;
	}

	public void setTotCount(int totCount) {
		this.totCount = totCount;
	}

	public void setPrevGroupStartPage(int prevGroupStartPage) {
		this.prevGroupStartPage = prevGroupStartPage;
	}

	public int getNextGroupStartPage() {
		return nextGroupStartPage;
	}

	public void setNextGroupStartPage(int nextGroupStartPage) {
		this.nextGroupStartPage = nextGroupStartPage;
	}

	
	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotPage() {
		return totPage;
	}

	public int getTotBlock() {
		return totBlock;
	}

	public int getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}

	public int getPrevBlock() {
		return prevBlock;
	}

	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}

	public int getNextBlock() {
		return nextBlock;
	}

	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public int getBlockBegin() {
		return blockBegin;
	}

	public void setBlockBegin(int blockBegin) {
		this.blockBegin = blockBegin;
	}

	public int getBlockEnd() {
		return blockEnd;
	}

	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}
}
