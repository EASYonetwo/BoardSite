package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class FindIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("FindIDServlet GET");
		request.getRequestDispatcher("/WEB-INF/views/findInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("FindIDServlet POST");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		IUserDao dao = new UserDaoImpl();
		//아이디찾기
		String nameId = request.getParameter("nameId");
		String phoneId = request.getParameter("phoneId");
		if(nameId == "" || phoneId == "") {
			response.getWriter().print("<script>alert('정보를 모두 입력해주세요'); location.href='./findID.do'</script>");
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", nameId);
			map.put("phone", phoneId);
			String findId = dao.getFindId(map);
			if(findId == null) {
				response.getWriter().print("<script>alert('찾으시는 정보가 없습니다. 다시 확인해주세요'); location.href='./findID.do'</script>");
			}else {
				response.getWriter().print("<script>alert('찾으시는 정보의 ID는 ["+findId+"] 입니다'); location.href='./findID.do'</script>");
			}
		}
	}
}
