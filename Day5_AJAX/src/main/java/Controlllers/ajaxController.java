package Controlllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ajaxController
 */
@WebServlet("*.ajax")
public class ajaxController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();
		if(cmd.equals("/exam01.ajax")) {
			System.out.println("단순 요청 확인");
		}else if(cmd.equals("/exam02.ajax")) {
			String param1 = request.getParameter("key1");
			String param2 = request.getParameter("key2");
			System.out.println(param1+":"+param2);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
