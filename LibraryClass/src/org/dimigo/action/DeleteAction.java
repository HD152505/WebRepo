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
public class DeleteAction implements IAction {

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
				List<LendBookVO> list = (List<LendBookVO>) session.getAttribute("lendlist");

				Integer num = Integer.parseInt(request.getParameter("num"));
				num = num - 1;
				
				LendBookVO book = new LendBookVO();
				book.setTitle(list.get(num).getTitle());
				book.setWriter(list.get(num).getWriter());
				UserService service = new UserService();
				service.deletebook(book);

				RequestDispatcher rd = request.getRequestDispatcher("status.do");
				rd.forward(request, response);

			} catch (Exception e) {
				request.setAttribute("msg", "error");
				request.setAttribute("error", e.getMessage());
				System.out.println("error");
				RequestDispatcher rd = request.getRequestDispatcher("status.do");
				rd.forward(request, response);
			}

		}

	}

}
