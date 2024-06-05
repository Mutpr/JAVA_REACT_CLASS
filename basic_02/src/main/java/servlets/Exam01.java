package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Exam01")
public class Exam01 extends HttpServlet {

	//부모 클래스가 상속해준 메서드
	//protected = 접근 제한자가 맞긴한데 메서드를 상속할것을 추천함(오버라이딩)이라는 뜻으로 많이 쓰임
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String message = request.getParameter("message");
		System.out.println("작성자: "+writer+", 메세지: "+message);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
