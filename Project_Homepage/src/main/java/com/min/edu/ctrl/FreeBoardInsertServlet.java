package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.fileupload2.core.DiskFileItem;
import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.JakartaServletDiskFileUpload;
import org.apache.log4j.Logger;

import com.min.edu.dto.FileDto;
import com.min.edu.dto.FreeBoardDto;
import com.min.edu.dto.UserDto;
import com.min.edu.model.FreeBoardDaoImpl;
import com.min.edu.model.IFreeBoardDao;

public class FreeBoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("FreeBoardInsertServlet GET");
		HttpSession session = request.getSession(false);
		UserDto loginInfo = (UserDto) session.getAttribute("loginInfo");
		request.setAttribute("id", loginInfo.getId());
		request.getRequestDispatcher("/WEB-INF/views/freeBoardInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("FreeBoardInsertServlet POST");
		
		String path = getServletContext().getRealPath("/upload/");
		System.out.println("파일업로드 경로설정 : "+path);
				
		File savedirectory = new File(path);
		if(!savedirectory.exists()) {
			savedirectory.mkdirs();
		}
		
		DiskFileItemFactory factory = DiskFileItemFactory.builder()
					.setPath(path)
					.setBufferSize(1024*8)
					.get();
		
		JakartaServletDiskFileUpload upload = new JakartaServletDiskFileUpload(factory);
		upload.setFileSizeMax(1024*1024*5);
		List<DiskFileItem> items = upload.parseRequest(request);
		
		String fileName = null;
		int fileSize = (int)savedirectory.length();
		FreeBoardDto bDto = new FreeBoardDto();
		for(FileItem fi : items) {
			if(fi.isFormField()) {
				String fieldName = fi.getFieldName();
				String fieldValue = fi.getString(StandardCharsets.UTF_8);
				
				switch (fieldName) {
					case "id": {
						bDto.setId(fieldValue);
						break;
					}
					case "title": {
						if(fieldValue.isEmpty()) {
							fieldValue = "제목없음";
						}
						bDto.setTitle(fieldValue);
						break;
					}
					case "content": {
						if(fieldValue.isEmpty()) {
							fieldValue = "내용없음";
						}
						bDto.setContent(fieldValue);
						break;
					}
				}
				
			}else {
				System.out.println(fi.getFieldName());
				
				fileName = fi.getName();
				
				if(fileName != null && !fileName.isEmpty()) {
					System.out.println("파일의 이름 : "+fileName);
					File uploadFile = new File(savedirectory,fileName);
					try {
						Path uploadPath = Paths.get(path+"/"+fileName);
						fi.write(uploadPath);
						System.out.println("파일 업로드 성공! "+uploadFile.getAbsolutePath());
					} catch (IOException e) {
						System.out.println("파일 업로드 실패ㅠ");
					}
				}
			}
		}
		
		IFreeBoardDao dao = new FreeBoardDaoImpl();
		FileDto fDto = new FileDto();
		fDto.setFilename(fileName);
		fDto.setFilesize(fileSize);
		int n = dao.insertFB(bDto, fDto);
		System.out.println(fDto);
		System.out.println(bDto);
		
		if(n>0) {
			response.sendRedirect("./freeBoard.do");
		}else {
			response.sendRedirect("./main.do");
		}
	}
}
