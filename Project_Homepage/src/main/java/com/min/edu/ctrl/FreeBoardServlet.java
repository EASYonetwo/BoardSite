package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.min.edu.dto.FreeBoardDto;
import com.min.edu.dto.PageDto;
import com.min.edu.dto.UserDto;
import com.min.edu.model.FreeBoardDaoImpl;
import com.min.edu.model.IFreeBoardDao;

public class FreeBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("FreeBoardServlet GET");
		HttpSession session = request.getSession();
		UserDto loginInfo = (UserDto) session.getAttribute("loginInfo");
		String sessionId = null;
		String sessionAuth = null;
		if(loginInfo == null) {
			sessionId="";
			sessionAuth="";
		}else {
			sessionId = loginInfo.getId();
			sessionAuth=loginInfo.getAuth();
		}
		IFreeBoardDao dao = new FreeBoardDaoImpl();
		String page = request.getParameter("page");
		if(page == null) {
			page ="1";
		}
		int selectPage = Integer.parseInt(page);
		PageDto p = new PageDto();
		p.setTotalCount(dao.countBoard());
		p.setCountList(5);
		p.setCountPage(5);

		p.setTotalPage(0);
		p.setPage(selectPage);
		
		p.setStagePage(0);
		p.setEndPage(0);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("first", p.getPage()*p.getCountList() - (p.getCountList()-1));
		map.put("last", p.getPage()*p.getCountList());
		List<FreeBoardDto> list = dao.getAllFB(map);
		
		request.setAttribute("list", list);
		request.setAttribute("page", p);
		request.setAttribute("sessionId", sessionId);
		request.setAttribute("sessionAuth", sessionAuth);
		request.getRequestDispatcher("/WEB-INF/views/freeBoard.jsp").forward(request, response);
	}
}
