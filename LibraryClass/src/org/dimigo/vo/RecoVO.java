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
public class RecoVO {

	private String title;
	private String writer;
	private String date;
	
	
	public RecoVO(){
		
	}
	
	/**
	 * @param name
	 * @param title
	 * @param date
	 */
	public RecoVO(String title, String writer, String date) {
		super();
		this.title = title;
		this.writer = writer;
		this.date = date;
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

	/**
	 * @return the name
	 */
	public String getWriter() {
		return writer;
	}
	/**
	 * @param name the name to set
	 */
	public void setWriter(String writer) {
		this.writer = writer;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "infoVO [title=" + title + ", writer=" + writer + "]";
	}
	
	

	
}
