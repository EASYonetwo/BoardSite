package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.min.edu.dto.FreeBoardDto;
import com.min.edu.dto.UserDto;
import com.min.edu.model.FreeBoardDaoImpl;
import com.min.edu.model.IFreeBoardDao;

public class FreeBoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("FreeBoardDetailServlet GET");
		HttpSession session = request.getSession();
		UserDto loginInfo = (UserDto) session.getAttribute("loginInfo");
		String sessionId = null;
		String sessionAuth = null;
		if(loginInfo == null) {
			sessionId ="";
			sessionAuth="";
		}else {
			sessionId = loginInfo.getId();
			sessionAuth = loginInfo.getAuth();
		}
		String seq = request.getParameter("seq");
		
		IFreeBoardDao dao = new FreeBoardDaoImpl();
		FreeBoardDto dto = dao.getOneFB(seq);
		if(dto == null) {
			dto = dao.getOneFBPost(seq);
		}
		
		request.setAttribute("dto", dto);
		request.setAttribute("sessionId", sessionId);
		request.setAttribute("sessionAuth", sessionAuth);
		request.getRequestDispatcher("/WEB-INF/views/freeBoardDetail.jsp").forward(request, response);
	}
}
