/**
 * 
 */
package org.dimigo.service;

import java.sql.Connection;
import java.util.List;

import org.dimigo.dao.BoardDao;
import org.dimigo.dao.BookDao;
import org.dimigo.dao.UserDao;
import org.dimigo.vo.BoardVO;
import org.dimigo.vo.BookVO;
import org.dimigo.vo.LendBookVO;
import org.dimigo.vo.RecoVO;
import org.dimigo.vo.UserVO;
import org.dimigo.vo.infoVO;

/**
 * <pre>
 * org.dimigo.service
 *  |_ LoginService
 * 
 * 1. 개요 :
 * 2. 작성일 : 2017. 10. 5.
 * </pre>
 *
 * @author : teacher
 * @version : 1.0
 */
public class UserService extends AbstractService {
	
	public UserVO login(UserVO user) throws Exception {
		
		Connection conn = null;
		try {
			// DB에서 id, pwd 조회
	//		boolean result = true;
	//		
	//		if(result) {
	//			user.setId(user.getId());
	//	    	user.setName("홍길동");
	//	    	user.setNickname("의적");
	//	    } else {
	//			throw new Exception("아이디 또는 비밀번호를 다시 확인하세요.");
	//		}
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			UserVO result = dao.searchUser(user);
			
			if(result == null)
				throw new Exception("다시 확인하세요.");
			
			return result;
			
		} finally {
			if(conn != null) conn.close();
		}
	}
	
	public void signup(UserVO user) throws Exception {

		Connection conn = null;
		
		try {
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			// 사용중인 아이디인지 먼저 체크
			UserVO result = dao.searchUserById(user);
			if(result != null) {
				throw new Exception("이미 사용중인 아이디입니다.");
			}
			
			// DB에 사용자정보 등록
			dao.insertUser(user);
			
	//		boolean result = true;
	//		
	//		if(!result) {
	//			throw new Exception("이미 사용중인 아이디입니다.");
	//		}
		} finally {
			if(conn != null) conn.close();
		}
	}
	
	
	public List<infoVO> searchInfoList() throws Exception {

		Connection conn = null;
		
		try {
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			return dao.searchInfoList();	
			
		} finally {
			if(conn != null) conn.close();
		}
	}
	public List<RecoVO> bookReco() throws Exception {

		Connection conn = null;
		
		try {
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			return dao.bookReco();	
			
		} finally {
			if(conn != null) conn.close();
		}
	}
//	이게 도서목록
	public List<RecoVO> interestList() throws Exception {

		Connection conn = null;
		
		try {
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			return dao.interestBook();	
			
		} finally {
			if(conn != null) conn.close();
		}
	}
	public List<BoardVO> BoardList() throws Exception {

		Connection conn = null;
		
		try {
			conn = getConnection();
			
			BoardDao dao = new BoardDao(conn);
			
			return dao.BoardList();	
			
		} finally {
			if(conn != null) conn.close();
		}
	}
	public List<BookVO> BookList(BookVO book) throws Exception {

		Connection conn = null;
		
		try {
			conn = getConnection();
			
			BookDao dao = new BookDao(conn);
			
			return dao.BookList(book);	
			
		} finally {
			if(conn != null) conn.close();
		}
	}
	public void insertBoard(BoardVO user) throws Exception {

		Connection conn = null;
		
		try {
			conn = getConnection();
			
			BoardDao dao = new BoardDao(conn);
			System.out.println("1.success");
			// DB에 등록
			dao.insertBoard(user);
			
		} finally {
			if(conn != null) conn.close();
		}
	}
	public void bookregister(RecoVO user) throws Exception {

		Connection conn = null;
		
		try {
			conn = getConnection();
			
			BookDao dao = new BookDao(conn);
			System.out.println("1.success");
			// DB에 등록
			dao.bookregister(user);
			
		} finally {
			if(conn != null) conn.close();
		}
	}
	public void booklend(LendBookVO user) throws Exception {

		Connection conn = null;
		
		try {
			conn = getConnection();
			
			BookDao dao = new BookDao(conn);
			System.out.println("1.success");
			// DB에 등록
			dao.booklend(user);
			
		} finally {
			if(conn != null) conn.close();
		}
	}
	public List<LendBookVO> lendBookList() throws Exception {

		Connection conn = null;
		
		try {
			conn = getConnection();
			
			BookDao dao = new BookDao(conn);
			
			return dao.lendBookList();	
			
		} finally {
			if(conn != null) conn.close();
		}
	}
	public void deletebook(LendBookVO book) throws Exception {

		Connection conn = null;
		
		try {
			conn = getConnection();
			
			BookDao dao = new BookDao(conn);
			System.out.println("1.success");
			// DB에 등록
			dao.deletebook(book);
			
		} finally {
			if(conn != null) conn.close();
		}
	}
	public void removebook(LendBookVO book) throws Exception {

		Connection conn = null;
		
		try {
			conn = getConnection();
			
			BookDao dao = new BookDao(conn);
			System.out.println("1.success");
			// DB에 등록
			dao.removebook(book);
			
		} finally {
			if(conn != null) conn.close();
		}
	}
}
