/**
 * 
 */
package org.dimigo.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.service.UserService;
import org.dimigo.util.CommonUtil;
import org.dimigo.vo.BoardVO;
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
public class WriteViewAction implements IAction {

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
				List<BoardVO> list = (List<BoardVO>) session.getAttribute("boardlist");
				Integer num = Integer.parseInt(request.getParameter("num"));
				num = num - 1;
				BoardVO board = new BoardVO();
				board.setDate(list.get(num).getDate());
				board.setTitle(list.get(num).getTitle());
				board.setWriter(list.get(num).getWriter());
				board.setContent(list.get(num).getContent());
				List<BoardVO> list2= new ArrayList<BoardVO>();
				list2.add(board);
				session.setAttribute("view", list2);
				RequestDispatcher rd = request.getRequestDispatcher("jsp/writeview.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				request.setAttribute("msg", "error");
				request.setAttribute("error", e.getMessage());
				System.out.println("error");
				RequestDispatcher rd = request.getRequestDispatcher("jsp/writeview.jsp");
				rd.forward(request, response);
			}

		}

	}

}
