package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.min.edu.dto.PersonalBoardDto;
import com.min.edu.dto.UserDto;
import com.min.edu.model.IPersonalBoardDao;
import com.min.edu.model.PersonalBoardDaoImpl;

public class PersonalBoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("PersonalBoardInsertServlet GET");
		HttpSession session = request.getSession(false);
		UserDto loginInfo = (UserDto) session.getAttribute("loginInfo");
		request.setAttribute("id", loginInfo.getId());
		request.getRequestDispatcher("/WEB-INF/views/personalBoardInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("PersonalBoardInsertServlet POST");
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		if(title == "") {
			title="제목없음";
		}
		if(content=="") {
			content = "내용없음";
		}
		System.out.println("title"+title);
		System.out.println("content"+content);
		IPersonalBoardDao dao = new PersonalBoardDaoImpl();
		PersonalBoardDto dto = new PersonalBoardDto();
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);
		int n = dao.insertPB(dto);
		
		if(n>0) {
			response.sendRedirect("./personalBoard.do?id="+id);
		}else {
			response.sendRedirect("./main.do");
		}
		
	}

}
