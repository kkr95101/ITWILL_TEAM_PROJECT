package myProtein.board;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class Board {
	private int board_no;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private int read_count;
	private int groupno;
	private int step;
	private int depth;
	private String u_id;
	
	public Board() {
		
	}

	public Board(int board_no, String title, String writer, String content, Date regdate, int read_count, int groupno,
			int step, int depth, String u_id) {
		super();
		this.board_no = board_no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.read_count = read_count;
		this.groupno = groupno;
		this.step = step;
		this.depth = depth;
		this.u_id = u_id;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getRead_count() {
		return read_count;
	}

	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}

	public int getGroupno() {
		return groupno;
	}

	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	@Override
	public String toString() {
		return "Board [board_no=" + board_no + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", regdate=" + regdate + ", read_count=" + read_count + ", groupno=" + groupno + ", step=" + step
				+ ", depth=" + depth + ", u_id=" + u_id + "]";
	}
	

}
