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
import org.dimigo.vo.BoardVO;
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
public class StatusAction implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		if (request.getSession().getAttribute("user") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			rd.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			try {

				LendBookVO book = new LendBookVO();
				UserService service = new UserService();
				List<LendBookVO> result = service.lendBookList();
				session.setAttribute("lendlist", result);
				System.out.println(result.toString());
				RequestDispatcher rd = request.getRequestDispatcher("jsp/status.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				request.setAttribute("msg", "error");
				request.setAttribute("error", e.getMessage());
				System.out.println("error");
				RequestDispatcher rd = request.getRequestDispatcher("jsp/status.jsp");
				rd.forward(request, response);
			}

		}

	}

}
