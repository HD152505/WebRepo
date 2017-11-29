package org.dimigo.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ScopeServlet", urlPatterns = "/scope")
public class ScopeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // id, pwd 값을 뽑아서 출력하기
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");

            System.out.println("id : " + id + " pwd : " + pwd);

            if (id == null || id.trim().equals("")) throw new Exception("아이디는 필수항목입니다.");


            // 1. request scope (비즈니스 거래)   한번 한번
            request.setAttribute("key", "rValue");


            // 2. session scope (사용자 정보)    세션이 유요한 기간동안만 계속 사용 가능
            request.getSession().setAttribute("key", "sValue");


            // 3. application scope
            request.getServletContext().setAttribute("key", "aValue");


        } catch (Exception e) {
            request.setAttribute("msg", e.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/scope.jsp");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}