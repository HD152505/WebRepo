/**
 * 
 */
package org.dimigo.vo;

/**
 * <pre>
 * org.dimigo.vo
 *  |_ User
 * 
 * 1. 개요 :
 * 2. 작성일 : 2017. 9. 21.
 * </pre>
 *
 * @author : teacher
 * @version : 1.0
 */
public class BoardVO {
	
	private String title;
	private String writer;
	private String content;
	private String date;
	
	public BoardVO(){
		
	}
	/**
	 * @param title
	 * @param writer
	 * @param content
	 * @param date
	 */
	public BoardVO(String title, String writer, String content, String date) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.date = date;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the writer
	 */
	public String getWriter() {
		return writer;
	}


	/**
	 * @param writer the writer to set
	 */
	public void setWriter(String writer) {
		this.writer = writer;
	}


	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}


	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}


	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BoardVO ["+ "title=" + title + ", writer=" + writer + ", content=" + content + ", date="
				+ date + "]";
	}
	
	
	
}
