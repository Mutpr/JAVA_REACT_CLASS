package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MessagesDAO;
import DTO.MessagesDTO;

@WebServlet("*.messages")
public class MessagesController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contents = request.getParameter("contents");
		String author = request.getParameter("author");
		MessagesDAO dao = new MessagesDAO(author, contents);
		String cmd= request.getRequestURI();
		System.out.println(cmd);
		try {
			if(cmd.equals("/input.messages")) {
				int result = dao.insert();
				System.out.println(result);
				response.sendRedirect("output.messages");
			}else if(cmd.equals("/output.messages")) {
				List<MessagesDTO> list = dao.selectAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("outputview.jsp").forward(request, response);
			}
		}catch(Exception e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
