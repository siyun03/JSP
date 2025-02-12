package jspbasic.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FileDownloadServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 다운로드할 파일명
		String filename = request.getParameter("filename");
		
		// 서버에 있는 파일에 대한 파일 객체
		File file = new File("D:/embededk/uploadfiles", filename);
		
		// 인코딩할 파일명 (한글파일명 처리하려면 필수 !)
		String encodedFilename
		= URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		
		// 서버에서 보내주는 컨텐츠가 첨부파일임
		response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFilename + "\"");
		
		// 서버에 있는 파일에서 바이크 입력 스트림
        InputStream  is = new FileInputStream(file);
        
        // 클라이언트에 보내줄 바이트 출력 스트림
        OutputStream fos = response.getOutputStream();
        
        // 버퍼
        byte[] buffer = new byte[1024]; // 버퍼
        int bytesRead = 0; // 읽은 바이트 수
        
        while ((bytesRead=is.read(buffer)) != -1) {
           fos.write(buffer, 0, bytesRead);
        }
        
        is.close();
        fos.close();
			}

	
	
	
	
	
	
	
}
