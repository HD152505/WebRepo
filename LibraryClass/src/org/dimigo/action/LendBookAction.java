/**
 * 
 */
package org.dimigo.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.service.UserService;
import org.dimigo.util.CommonUtil;
import org.dimigo.vo.BookVO;
import org.dimigo.vo.LendBookVO;
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
public class LendBookAction implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		if (request.getSession().getAttribute("user") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			rd.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			try {

				// 1. 입력값 추출
				@SuppressWarnings("unchecked")
				List<BookVO> list = (List<BookVO>) session.getAttribute("booklist");
				
				List<RecoVO> list2 = (List<RecoVO>) session.getAttribute("interestlist");
				Integer num = Integer.parseInt(request.getParameter("num"));
				Integer num2 = Integer.parseInt(request.getParameter("num2"));
				num = num - 1;
				LendBookVO book = new LendBookVO();
				if(num2 == 0){	
					book.setTitle(list.get(num).getTitle());
					book.setWriter(list.get(num).getWriter());
					UserService service = new UserService();
					service.booklend(book);
				}else{
					book.setTitle(list2.get(num).getTitle());
					book.setWriter(list2.get(num).getWriter());
					
					UserService service = new UserService();
					service.booklend(book);
					service.removebook(book);
				}
				

				RequestDispatcher rd = request.getRequestDispatcher("status.do");
				rd.forward(request, response);

			} catch (Exception e) {
				request.setAttribute("msg", "error");
				request.setAttribute("error", e.getMessage());
				System.out.println("error=>lendbook");
				RequestDispatcher rd = request.getRequestDispatcher("status.do");
				rd.forward(request, response);
			}

		}

	}

}
