package org.dimigo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.action.BookRegisterAction;
import org.dimigo.action.DeleteAction;
import org.dimigo.action.IAction;
import org.dimigo.action.InfoAction;
import org.dimigo.action.InterestAction;
import org.dimigo.action.LendBookAction;
import org.dimigo.action.LoginAction;
import org.dimigo.action.LogoutAction;
import org.dimigo.action.RecoAction;
import org.dimigo.action.SearchBookAction;
import org.dimigo.action.SignupAction;
import org.dimigo.action.StatusAction;
import org.dimigo.action.WriteAction;
import org.dimigo.action.WriteListAction;
import org.dimigo.action.WriteViewAction;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("*.do")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map<String, IAction> actions = new HashMap<>();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	
    	actions.put("login", new LoginAction());
    	actions.put("logout", new LogoutAction());   	
    	actions.put("signup", new SignupAction());
    	actions.put("info", new InfoAction());
    	actions.put("recoBook", new RecoAction());
    	actions.put("write", new WriteAction());
    	actions.put("writeList", new WriteListAction());
    	actions.put("bookregister", new BookRegisterAction());
    	actions.put("interest", new InterestAction());
    	actions.put("writeview", new WriteViewAction());
    	actions.put("searchbook", new SearchBookAction());
    	actions.put("status", new StatusAction());
    	actions.put("lendbook", new LendBookAction());
    	actions.put("delete", new DeleteAction());
    	
    	
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			
			// /WebClass/login.do인 경우 login.do만 추출
			String uri = request.getRequestURI();
			String actionName = uri.substring(uri.lastIndexOf("/") + 1);
			actionName = actionName.substring(0, actionName.indexOf("."));
			System.out.println("actionName : " + actionName);
			
			// action 클래스 가져오기
			IAction action = actions.get(actionName);
			
			if(action == null) {
				throw new Exception(actionName + "에 해당하는 Action 클래스가 없습니다.");
			}
			
			// Action의 execute() 실행
			action.execute(request, response);		        
		    
		} catch(Exception e) {
			e.printStackTrace();			
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<html><head><title>Error</title></head><body><h3>");
		        //e.printStackTrace(out);
				out.println(e.getMessage());
		        out.println("</h3></body></html>");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
    }
	
}