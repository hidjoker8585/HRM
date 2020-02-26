package dto;
/**
 * @brief 게시글정보를 담을 dto
 * @author 이현우
 * @version v1.00 2020.02.21
 * @see 
 */

import java.util.Date;

public class Board {
	
	private int boardNo;
	private String title;
	private Date writtenDate;
	private String writerNo;
	private String writerName;
	private String content;

	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getWrittenDate() {
		return writtenDate;
	}
	public void setWrittenDate(Date writtenDate) {
		this.writtenDate = writtenDate;
	}
	public String getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", writtenDate=" + writtenDate + ", writerNo="
				+ writerNo + ", writerName=" + writerName + ", content=" + content + "]";
	}
	

	
	
}
