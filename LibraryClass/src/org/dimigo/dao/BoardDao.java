/**
 * 
 */
package org.dimigo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.dimigo.vo.RecoVO;
import org.dimigo.vo.BoardVO;
import org.dimigo.vo.infoVO;

/**
 * <pre>
 * org.dimigo.dao
 *  |_ UserDao
 * 
 * 1. 개요 :
 * 2. 작성일 : 2017. 10. 6.
 * </pre>
 *
 * @author : teacher
 * @version : 1.0
 */
public class BoardDao {
	
	private Connection conn = null;
	
	public BoardDao(Connection conn) {
		this.conn = conn;
	}
	
	public void insertBoard(BoardVO vo) throws Exception {
		
		String sql = "INSERT INTO BOARD VALUES(?, ?, ?, ?)";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getDate());
			int cnt = pstmt.executeUpdate();
			
			if(cnt == 0) throw new Exception("사용자 등록에 실패하였습니다.");
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 등록 시 오류가 발생하였습니다.");
		}
	}
	public List<infoVO> searchInfoList() throws Exception {
		
		String sql = "SELECT NAME, TITLE, DATE FROM INFORMATION";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			
			infoVO result = null;
			List<infoVO> list = new ArrayList<infoVO>();
			
			while(rs.next()) {
				result = new infoVO();
				result.setName(rs.getString(1));
				result.setTitle(rs.getString(2));
				result.setDate(rs.getString(3));
				list.add(result);
			}
			return list;
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 조회 시 오류가 발생하였습니다.");
		}
	}
	public List<BoardVO> BoardList() throws Exception {
		
		String sql = "SELECT TITLE, WRITER, CONTENT, DATE FROM BOARD";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			
			BoardVO result = null;
			List<BoardVO> list = new ArrayList<BoardVO>();
			
			while(rs.next()) {
				result = new BoardVO();
				result.setTitle(rs.getString(1));
				result.setWriter(rs.getString(2));
				result.setContent(rs.getString(3));
				result.setDate(rs.getString(4));
				list.add(result);
			}
			
			return list;
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 조회 시 오류가 발생하였습니다.");
		}
	}
}
