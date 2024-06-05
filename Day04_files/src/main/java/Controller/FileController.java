package Controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO.FileDAO;
import DTO.FileDTO;

/**
 * Servlet implementation class FileController
 */
@WebServlet("*.file")
public class FileController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getRequestURI();
		FileDAO dao = new FileDAO();
		HttpSession session = request.getSession(true);
		if (cmd.equals("/upload.file")) {
			int maxSize = 1024 * 1024 * 10;// 10메가 사이즈 제한
			String realPath = request.getServletContext().getRealPath("files");// 파일이 저장될 위치

			File uploadPath = new File(realPath); // 저장 위치 폴더를 파일 인스턴스로 생성
			if (!uploadPath.exists()) {
				uploadPath.mkdir();
			}
			MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "UTF8",
					new DefaultFileRenamePolicy());
			Enumeration<String> names = multi.getFileNames();
			while (names.hasMoreElements()) {
				String name = names.nextElement();
				String oriname = multi.getOriginalFileName(name);
				String sysname = multi.getFilesystemName(name);

				if (oriname != null) {
					try {
						int result = dao.insert(new FileDTO(0, oriname, sysname, 0));
						System.out.println(result);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} else if (cmd.equals("/list.file")) {
			try {
				List<FileDTO> list = dao.selectAll();
				session.setAttribute("list", list);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (cmd.equals("/download.file")) {
			String filepath = request.getServletContext().getRealPath("files");
			// 다운받을 파일의 위치확보
			String sysname = request.getParameter("sysname");
			String oriname = request.getParameter("oriname");
			// 다운받을 파일의 이름 확보
			oriname = new String(oriname.getBytes("UTF8"),"ISO-8859-1");
			response.reset(); //리스폰스가 원래 가지고있던 설정 리셋작업
			response.setHeader("Content-Disposition", "attachment;filename="+oriname+"");
			

			File target = new File(filepath + "/" + sysname);
			// 위치와 이름을 결합해서 타겟 파일 인스턴스 확보

			byte[] fileContents = new byte[(int) target.length()];
			// 타겟 파일의 이름 저장
			try (FileInputStream fis = new FileInputStream(target);
					// 타겟 파일에ㅔ 스트림을 연결(데이터 통신 준비)
					DataInputStream dis = new DataInputStream(fis);
					// 하드디스크에서 타겟 파일 내용을 램으로 복사
					ServletOutputStream sos = response.getOutputStream();) {

				sos.write(fileContents);
				sos.flush();
				sos.close();
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
