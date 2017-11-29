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
public class BookVO {
	
	private String subject;
	private String title;
	private String writer;
	
	public BookVO(){
		
	}
	/**
	 * @param subject
	 * @param title
	 * @param writer
	 */
	public BookVO(String subject, String title, String writer) {
		super();
		this.subject = subject;
		this.title = title;
		this.writer = writer;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BookVO [subject=" + subject + ", title=" + title + ", writer=" + writer + "]";
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
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
	
	
	
	
}
