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
import org.dimigo.vo.UserVO;
import org.dimigo.vo.infoVO;

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
public class InfoAction implements IAction {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			// 비지니스 로직 처리를 위한 Service 호출
			UserService service = new UserService();
			List<infoVO> result = service.searchInfoList();
			
			request.setAttribute("list2", result);
	    	
	    	RequestDispatcher rd = request.getRequestDispatcher("jsp/info.jsp");
			rd.forward(request, response);
			
		} catch(Exception e) {
			request.setAttribute("msg", "error");
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/info.jsp");
			rd.forward(request, response);
		}
    	
	}

}
