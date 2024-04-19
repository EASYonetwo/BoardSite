package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.min.edu.dto.UserDto;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("LoginServlet GET");
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("LoginServlet POST");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println("입력받은 값:"+id + "/"+password);
		
		if(id=="" || password=="") {
			response.getWriter().print("<script>alert('아이디와 비밀번호를 입력해주세요'); location.href='./login.do'</script>");
		}
		else {
			IUserDao dao = new UserDaoImpl();
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("password", password);
			UserDto loginInfo = dao.getLogin(map);
			System.out.println(loginInfo);
			if(loginInfo == null) {
				response.getWriter().print("<script>alert('아이디와 비밀번호를 확인해주세요'); location.href='./login.do'</script>");
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("loginInfo", loginInfo);
				response.sendRedirect("./main.do");
			}
		}
	}
}
