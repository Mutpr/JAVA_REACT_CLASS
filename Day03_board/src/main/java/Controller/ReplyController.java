package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ReplyDAO;

/**
 * Servlet implementation class ReplyController
 */
@WebServlet("*.reply")
public class ReplyController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyDAO replyDAO = ReplyDAO.getInstance();
		String cmd = request.getRequestURI();
		HttpSession session = request.getSession(true);
		System.out.println(cmd);
		if(cmd.equals("/insert.reply")) {
			String contents =  request.getParameter("replyContents");
			String writerId = (String) session.getAttribute("userId");
			int postId= (int) session.getAttribute("postId");
			System.out.println(contents+":"+writerId+":"+postId);
			int result = replyDAO.insertReply(contents, writerId, postId);
			System.out.println(result);
			response.sendRedirect("/selectPost.boards");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
