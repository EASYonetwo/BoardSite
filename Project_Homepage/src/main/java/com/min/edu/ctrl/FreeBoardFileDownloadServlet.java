package com.min.edu.ctrl;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;


import org.apache.log4j.Logger;

import com.min.edu.dto.FileDto;
import com.min.edu.model.FreeBoardDaoImpl;
import com.min.edu.model.IFreeBoardDao;

public class FreeBoardFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("FreeBoardFileDownloadServlet GET");
		
		String fileSeq = request.getParameter("fileSeq");
		logger.info("전달받은 요청값:"+fileSeq);
		
		IFreeBoardDao dao = new FreeBoardDaoImpl();
		FileDto dto = dao.getFile(fileSeq);
		
		System.out.println("찾은 파일의 정보 : "+dto);
		
		String path = request.getServletContext().getRealPath("/upload/");
		String filePath = path + dto.getFilename();
		
		FileInputStream in = null;
		ServletOutputStream out = null;
		
		
		
		try {
			File file = new File(filePath);
			byte[] b = new byte[(int) file.length()];
			
			response.reset();
			response.setContentType("application/octet-stream");
			String encoding = new String(dto.getFilename().getBytes("UTF-8"), "8859_1"); //인코딩 필수
			response.setHeader("Content-Disposition", "attachment; filename="+encoding); //이렇게 처리해주세요!
			
			in = new FileInputStream(file);
			out = response.getOutputStream();
			
			int numRead = 0;
			while ((numRead = in.read(b, 0, b.length)) != -1) { // 다시받기 기능을 위한 fn
				out.write(b, 0, numRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			out.flush();
			out.close();
			in.close();
		}
	}
}
