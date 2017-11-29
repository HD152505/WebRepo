/**
 * 
 */
package org.dimigo.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.service.UserService;
import org.dimigo.util.CommonUtil;
import org.dimigo.vo.BoardVO;
import org.dimigo.vo.BookVO;
import org.dimigo.vo.RecoVO;

/**
 * <pre>
 * org.dimigo.action
 *  |_ LoginAction
 * 
 * 1. 개요 :
 * 2. 작성일 : 2017. 10. 5.
 * </pre>
 *
 * @author : teacher
 * @version : 1.0
 */
public class SearchBookAction implements IAction {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request.getSession().getAttribute("user") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			rd.forward(request, response);
		} else {
			try {
				String box = request.getParameter("box");
				if(box==null){
					box="mo";
				}
				String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				// 비지니스 로직 처리를 위한 Service 호출
				UserService service = new UserService();
				BookVO book = new BookVO();
				book.setSubject(box);
				book.setTitle(title);
				book.setWriter(writer);
				
				List<BookVO> result = service.BookList(book);
				HttpSession session = request.getSession();
				session.setAttribute("booklist", result);
		    	
				RequestDispatcher rd = request.getRequestDispatcher("jsp/searchBook.jsp");
				rd.forward(request, response);
				
			} catch(Exception e) {
				request.setAttribute("msg", "error");
				request.setAttribute("error", e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("jsp/searchBook.jsp");
				rd.forward(request, response);
			}
			
			
		}
    	
	}

}
