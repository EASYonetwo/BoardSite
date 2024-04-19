package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.min.edu.dto.PersonalBoardDto;
import com.min.edu.model.IPersonalBoardDao;
import com.min.edu.model.PersonalBoardDaoImpl;

public class PersonalBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("PersonalBoardServlet GET");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		String id = request.getParameter("id");
		
		
		if(id=="") {
			response.getWriter().print("<script>alert('로그인된 회원만 가능합니다'); location.href='./login.do';</script>");
		}else {
			IPersonalBoardDao dao = new PersonalBoardDaoImpl();
			List<PersonalBoardDto> list = dao.selectAllPBUser(id);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/personalBoard.jsp").forward(request, response);
		}
		
	}
}
