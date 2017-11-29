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
public class LendBookVO {
	
	private String title;
	private String writer;
	
	public LendBookVO(){
		
	}
	/**
	 * @param subject
	 * @param title
	 * @param writer
	 */
	public LendBookVO(String title, String writer) {
		super();
		this.title = title;
		this.writer = writer;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BookVO ["+"title=" + title + ", writer=" + writer + "]";
	}
	public String getTitle() {
		return title;
	}
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
	
	
	
	
}
