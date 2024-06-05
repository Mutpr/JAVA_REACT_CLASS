package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import DTO.UserDTO;

@WebServlet("*.members")
public class UserController extends HttpServlet {
	public static final String REGEXP_EMAIL_CHAR = "^([A-Za-z0-9@$!%*#?&_]{1,15})@([a-z]{1,10}).((com)|(net))";
	public static final String REGEXP_PHONE_CHAR_FIRST = "^(010([0-9]{4})([0-9]{4}))";
	public static final String REGEXP_PHONE_CHAR_SECOND = "^(010-([0-9]{4})-([0-9]{4}))";
	public static final String REGEXP_POSTCODE_CHAR = "^([0-9]{5})";
	public static final String REGEXP_ID_CHAR = "^([a-z]{1})([a-z0-9]{1,10})";
	public static final String REGEXP_PWD_CHAR = "^([A-Za-z]){1}([A-Za-z0-9@$!%*#?&_]{1,15})";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		String cmd = request.getRequestURI();
		System.out.println(cmd);
		HttpSession session = request.getSession(true);
		if (cmd.equals("/signup.members")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String postCode = request.getParameter("postCode");
			String addr1 = request.getParameter("addr1");
			String addr2 = request.getParameter("addr2");
			String extraAddr = request.getParameter("extraAddr");

			System.out.println(id + ":" + pwd + ":" + name + ":" + email + ":" + phone + ":" + postCode + ":" + addr1
					+ ":" + addr2 + ":" + extraAddr);
			Boolean isValidId = Pattern.matches(REGEXP_ID_CHAR, id);
			Boolean isValidPwd = Pattern.matches(REGEXP_PWD_CHAR, pwd);
			Boolean isValidPhoneFirst = Pattern.matches(REGEXP_PHONE_CHAR_FIRST, phone);
			Boolean isValidPhoneSecond = Pattern.matches(REGEXP_PHONE_CHAR_SECOND, phone);
			Boolean isValidEmail = Pattern.matches(REGEXP_EMAIL_CHAR, email);
			Boolean isValidPostCode = Pattern.matches(REGEXP_POSTCODE_CHAR, postCode);

			System.out.println(isValidId + ":" + isValidPostCode + ":" + isValidPwd + ":" + isValidPhoneFirst + ":"
					+ isValidPhoneSecond + ":" + isValidEmail + ":" + isValidPostCode);
			if (isValidId == true && isValidPwd == true && isValidEmail == true && isValidPostCode == true
					&& isValidPhoneFirst == true || isValidPhoneSecond == true) {
				System.out.println("입력준비완료!");
				int result = dao.insertUser(id, pwd, name, phone, email, postCode, addr1, addr2, extraAddr);
				System.out.println(result);
				response.sendRedirect("/index.jsp");
			}

		}

		else if (cmd.equals("/isDuplicated.members")) {
			String username = request.getParameter("id");
			System.out.println(username);
			boolean isIdDuplicated = dao.isIdDuplicated(username);
			System.out.println("userList ==== " + isIdDuplicated);
			PrintWriter out = response.getWriter();
			if (isIdDuplicated == true) {
				out.print("true");
			} else {
				out.print("false");
			}
		} else if(cmd.equals("/login.members")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pw");
			System.out.println(id+":"+pwd);
			
			UserDTO userInfo = dao.selectAllById(id, pwd);
			System.out.println("테스트:"+userInfo.getName());
			session.setAttribute("userInfo", userInfo);
			session.setAttribute("userId", userInfo.getId());
			session.setAttribute("joinDate", userInfo.getJoin_date());
			
			response.sendRedirect("/index.jsp");
			
		}else if(cmd.equals("/delete.members")) {
			String id = request.getParameter("id");
			int deletionResult = dao.deleteById(id);
			System.out.println(deletionResult);
			session.setAttribute("deletionResult", deletionResult);
			session.invalidate();
			
		}else if(cmd.equals("/update.members")) {
			String id = (String) session.getAttribute("userId");
			Timestamp joinDate = (Timestamp) session.getAttribute("joinDate");
			System.out.println("접속 아이디: "+id);
			
			String updatedName = request.getParameter("update-name");
			String updatedPhone = request.getParameter("update-phone");
			String updatedEmail = request.getParameter("update-email");
			String updateZipcode = request.getParameter("update-zipcode");
			String updatedAddr1 = request.getParameter("update-addr1");
			String updatedAddr2 = request.getParameter("update-addr2");
			
			System.out.println(updatedName+":"+updatedPhone+":"+updatedEmail+":"+updatedAddr1+":"+updatedAddr2);
			UserDTO updatedUserInfo = new UserDTO(id, updatedName, updatedPhone, updatedEmail, updateZipcode ,updatedAddr1, updatedAddr2, joinDate);
			int updatedResult = dao.updateUserInfo(id, updatedUserInfo);
			System.out.println("updateResult:"+ updatedResult);
			
			response.sendRedirect("/board/mainBoard.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
