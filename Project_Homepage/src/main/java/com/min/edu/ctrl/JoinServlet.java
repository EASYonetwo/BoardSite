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

import org.apache.log4j.Logger;

import com.min.edu.dto.UserDto;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("JoinServlet GET");
		request.getRequestDispatcher("/WEB-INF/views/join.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("JoinServlet POST");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		String id= request.getParameter("id");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		
		if(id=="" || password==""||name==""||phone=="") {
			response.getWriter().print("<script>alert('필수값은 모두 입력해주세요');location.href='./join.do' </script>");
		}else {
			IUserDao dao = new UserDaoImpl();
			UserDto dto = new UserDto(id, password, name, address, phone);
			if(dao.joinIdCheck(id)>0) {
				response.getWriter().print("<script>alert('아이디 중복검사를 진행해주세요');location.href='./join.do' </script>");
			};
			
			int row = dao.insertUser(dto);
			if(row>0) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", id);
				map.put("password", password);
				UserDto loginInfo = dao.getLogin(map);
				HttpSession session = request.getSession();
				session.setAttribute("loginInfo", loginInfo);
				response.sendRedirect("./main.do");
			}else {
				response.getWriter().print("<script>alert('회원가입에 실패하셨습니다'); location.href='./main.do';</script>");
			}
		}
	}
}
