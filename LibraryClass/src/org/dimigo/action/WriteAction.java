/**
 * 
 */
package org.dimigo.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.service.UserService;
import org.dimigo.util.CommonUtil;
import org.dimigo.vo.BoardVO;
import org.dimigo.vo.RecoVO;
import org.dimigo.vo.UserVO;
import org.dimigo.vo.infoVO;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
public class WriteAction implements IAction {
	private void validate(String title, String content) throws Exception {
		if(CommonUtil.isEmpty(title)) throw new Exception("제목을 입력하세요");
		if(CommonUtil.isEmpty(content)) throw new Exception("내용을 입력하세요");
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
	    Gson gson = new Gson();
		JsonObject obj = new JsonObject();
		
		if(request.getSession().getAttribute("user") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			rd.forward(request, response);
		} else {
			try {
				if(request.getParameter("title")!=null){
				String name = request.getParameter("name");
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				Calendar c1 = Calendar.getInstance();
				String dTime = sdf.format(c1.getTime());
				System.out.println(dTime);
				validate(title, content);
				
				BoardVO user = new BoardVO();
				user.setWriter(name);
				user.setTitle(title);
				user.setContent(content);
				user.setDate(dTime);
				System.out.println(user.toString());
				UserService service = new UserService();
				service.insertBoard(user);

		    	
				RequestDispatcher rd = request.getRequestDispatcher("writeList.do");
				rd.forward(request, response);
				}else{
					RequestDispatcher rd = request.getRequestDispatcher("jsp/write.jsp");
					rd.forward(request, response);
				}
			} catch(Exception e) {
				System.out.println("writeaction error");
				request.setAttribute("msg", "error");
				request.setAttribute("error", e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("jsp/writeList.jsp");
				rd.forward(request, response);
			}
			
			
		}
    	
	}

}
