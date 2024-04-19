package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.min.edu.model.FreeBoardDaoImpl;
import com.min.edu.model.IFreeBoardDao;

public class FreeBoardFileDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("FreeBoardFileDeleteServlet GET");
		String fileSeq = request.getParameter("fileSeq");
		String seq = request.getParameter("seq");
		
		IFreeBoardDao dao = new FreeBoardDaoImpl();
		int n = dao.deleteFile(fileSeq);
		
		if(n>0) {
			response.sendRedirect("./freeBoardDetail.do?seq="+seq);
		}else {
			response.sendRedirect("./main.do");
		}
	}

}
