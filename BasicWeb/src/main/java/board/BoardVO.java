package board;

import java.time.LocalDate;

public class BoardVO {
	private int no;
	private String writer;
	private String title;
	private String content;
	private LocalDate createDate;
	private LocalDate modifyDate;
	private int hits;
	
	// 기본 생성자
	public BoardVO() {
	}

	// SELECT 용 생성자
	public BoardVO(int no, String writer, String title, String content, LocalDate createDate, LocalDate modifyDate,
			int hits) {
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.hits = hits;
	}
	
	
	// INSERT 용 생성자
	public BoardVO(String writer, String title, String content) {
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
	
	// UPDATE 용 생성자
	public BoardVO(int no, String writer, String title, String content) {
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
	
	// LIST 용 생성자(게시글 상세내역 조회)
	public BoardVO(int no, String writer, String title, LocalDate createDate, int hits) {
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.createDate = createDate;
		this.hits = hits;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", hits=" + hits + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDate modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}
	
	
}   
