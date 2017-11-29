/**
 * 
 */
package org.dimigo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.dimigo.vo.BoardVO;
import org.dimigo.vo.RecoVO;
import org.dimigo.vo.UserVO;
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
public class UserDao {

	private Connection conn = null;

	public UserDao(Connection conn) {
		this.conn = conn;
	}

	public UserVO searchUser(UserVO vo) throws Exception {

		String sql = "SELECT ID, NAME, NICKNAME FROM USER WHERE ID=? AND PWD=?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());

			ResultSet rs = pstmt.executeQuery();

			UserVO result = null;
			if (rs.next()) {
				result = new UserVO();
				result.setId(rs.getString(1));
				result.setName(rs.getString(2));
				result.setNickname(rs.getString(3));
			}

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 조회 시 오류가 발생하였습니다.");
		}
	}

	public UserVO searchUserById(UserVO vo) throws Exception {

		String sql = "SELECT ID, NAME, NICKNAME FROM USER WHERE ID=?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, vo.getId());
			ResultSet rs = pstmt.executeQuery();

			UserVO result = null;
			if (rs.next()) {
				result = new UserVO();
				result.setId(rs.getString(1));
				result.setName(rs.getString(2));
				result.setNickname(rs.getString(3));
			}

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 조회 시 오류가 발생하였습니다.");
		}
	}

	public void insertUser(UserVO vo) throws Exception {

		String sql = "INSERT INTO USER VALUES(?, ?, ?, ?)";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getNickname());
			int cnt = pstmt.executeUpdate();

			if (cnt == 0)
				throw new Exception("사용자 등록에 실패하였습니다.");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 등록 시 오류가 발생하였습니다.");
		}
	}

	public List<UserVO> searchUserList() throws Exception {

		String sql = "SELECT ID, NAME, NICKNAME FROM USER";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			ResultSet rs = pstmt.executeQuery();

			UserVO result = null;
			List<UserVO> list = new ArrayList<UserVO>();

			while (rs.next()) {
				result = new UserVO();
				result.setId(rs.getString(1));
				result.setName(rs.getString(2));
				result.setNickname(rs.getString(3));
				list.add(result);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 조회 시 오류가 발생하였습니다.");
		}
	}

	public List<infoVO> searchInfoList() throws Exception {

		String sql = "SELECT NAME, TITLE, DATE FROM INFORMATION";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			ResultSet rs = pstmt.executeQuery();

			infoVO result = null;
			List<infoVO> list = new ArrayList<infoVO>();

			while (rs.next()) {
				result = new infoVO();
				result.setName(rs.getString(1));
				result.setTitle(rs.getString(2));
				result.setDate(rs.getString(3));
				list.add(result);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 조회 시 오류가 발생하였습니다.");
		}
	}

	public List<RecoVO> bookReco() throws Exception {
		String sql = "SELECT TITLE, WRITER FROM RECOMMEND ORDER BY RAND() LIMIT 5 ";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			ResultSet rs = pstmt.executeQuery();

			RecoVO result = null;
			List<RecoVO> list = new ArrayList<RecoVO>();
			String a = null;
			while (rs.next()) {
				a = rs.getString(1);
				result = new RecoVO();
				result.setTitle(rs.getString(1));
				result.setWriter(rs.getString(2));
				list.add(result);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 조회 시 오류가 발생하였습니다.");
		}
	}

	public List<RecoVO> interestBook() throws Exception {
		String sql = "SELECT * FROM BOOK";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			ResultSet rs = pstmt.executeQuery();

			RecoVO result = null;
			List<RecoVO> list = new ArrayList<RecoVO>();
			while (rs.next()) {
				result = new RecoVO();
				result.setTitle(rs.getString(1));
				result.setWriter(rs.getString(2));
				result.setDate(rs.getString(3));
				list.add(result);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 조회 시 오류가 발생하였습니다.");
		}
	}
}
