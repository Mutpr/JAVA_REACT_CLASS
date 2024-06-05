package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BoardDAO;
import DAO.ReplyDAO;
import DTO.BoardDTO;
import DTO.ReplyDTO;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.boards")
public class BoardController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO boardDAO = BoardDAO.getInstance();
		ReplyDAO replyDAO = ReplyDAO.getInstance();
		String cmd = request.getRequestURI();
		HttpSession session = request.getSession(true);
		System.out.println(cmd);
		if(cmd.equals("/mainBoard.boards")) {
			try {
				List<BoardDTO> postList = boardDAO.selectAllPost();
				session.setAttribute("postList", postList);
				request.getRequestDispatcher("/board/mainBoard.jsp").forward(request, response);
//				response.sendRedirect("");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("/selectPost.boards")) {
			int postId = (int) session.getAttribute("postId");
			System.out.println("postId:"+postId);
			try {
				BoardDTO post =boardDAO.selectOnePost(postId);
				session.setAttribute("post", post);
				session.setAttribute("postId", postId);
				session.setAttribute("writer", post.getWriter());
				
				List<ReplyDTO> replyList = replyDAO.selectAllReply(postId);
				session.setAttribute("replyList", replyList);
				request.getRequestDispatcher("/board/post.jsp").forward(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}

		}else if(cmd.equals("/insertPost.boards")) {
			String userId = (String) session.getAttribute("userId");
			String title = request.getParameter("title");
			String contents = request.getParameter("contents");
			System.out.println(userId+":"+title+":"+contents);
			
			int result = boardDAO.insertPost(title, contents, userId);
			System.out.println(result);
			
			response.sendRedirect("/selectPost.boards");
		}
		else if(cmd.equals("/updatePost.boards")) {
			int postId = (int) session.getAttribute("postId");
			String updatedTitle = request.getParameter("title");
			String updatedContent = request.getParameter("contents");
			
			System.out.println(postId+":"+updatedTitle+":"+updatedContent);
			
			int result = boardDAO.updatePost(postId, updatedContent, updatedTitle);
			System.out.println(result);
			try {
				List<BoardDTO> postList = boardDAO.selectAllPost();
				session.setAttribute("postList", postList);
				response.sendRedirect("/mainBoard.boards");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("/deletePost.boards")) {
			int postId = (int) session.getAttribute("postId");
			System.out.println("deleteTargetId:"+postId);
			try {
				int result = boardDAO.deletePost(postId);
				System.out.println(result);
				response.sendRedirect("/mainBoard.boards");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
