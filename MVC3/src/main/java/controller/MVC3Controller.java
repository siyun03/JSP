package controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import handler.CommandHandler;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MVC3Controller extends HttpServlet{
	
	// 명령어(커맨드)와 명령어처리객체(ListCommand, WriteCommand, UpdateCommand, DeleteCommand)를 매핑할 맵
	Map<String, Object> commandMap = null;
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
		
		// web.xml에서 설정한 서블릿 초기화 파라미터 값
		String commandFile = sc.getInitParameter("commanFile");
		
		// .properties 파일을 읽어 저장할 Properties
		// Properties : 키와 값이 모두 문자열인 맵
		Properties prop = new Properties();
		
		// .properties 파일의 서버상의 실제 경로
		String commandFilePath = sc.getServletContext().getRealPath(commandFile);
		// System.out.println(commandFile);
		
		// .properties 파일에서 문자을 입력받을 스트림
		FileReader fr = null;
		
		try {
			
			// 파일에서 문자를 읽는 스트림 생성
			fr = new FileReader(commandFilePath);
			
			// 파일내의 키, 값을 Properties 객체에 매핑
			prop.load(fr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 프라퍼티의 키들을 반복할 Iterator 획득
		Iterator it = prop.keySet().iterator();		
		
		// 커맨드 맵을 생성
		// 명령어(맵)와 명령어처리클래스의 객체(값)를 저장할 맵
		commandMap = new HashMap<String, Object>();
		
		// 키가 있는만큼 반복
		while(it.hasNext()) {
			String command = (String)it.next(); // 키 = 명령어
			String handlerClassStr = prop.getProperty(command); // 값 = 명령어에 처리클래스 문자열
			try {
				
				// 명렁어처리클래스 문자열로 클래스를 생성
				Class handlerClass = Class.forName(handlerClassStr);
				
				// 명령어처리클래스의 객체를 생성
				CommandHandler handlerObj = (CommandHandler)handlerClass.newInstance();
				
				//명령어와 명령어처리 클래스의 객체를 맵에 등록
				commandMap.put(command, handlerObj);
				
				} catch (Exception e) {
				e.printStackTrace();
			}
			
		} // while
		
	} // init
		
		public void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
			
			// 명령어를 가져오기 위헤 요청URI 획득
			String command = request.getRequestURI();
			
			// 요청URI가 컨텍스트루트로 시작하면 (예 : /list.do는 /로 시작한다 = /의 인덱스가 0)
			if(command.indexOf(request.getContextPath())==0) {
				
				// 요청 URI에서 명령어 획득 (예 : /list.do에서 ContextPath인 /의 인덱스+1부터 끝까지 => list/do)
				command = command.substring(request.getContextPath().length()+1);
			}
			
			// 명령어를 처리할 명령어처리클래스의 객체를 맵에서 획득
			CommandHandler handler = (CommandHandler)commandMap.get(command);
			
			// 뷰페이지
			String viewPage = null;
			
			try {
				
				// 명령어처리클래스의 객체에서 view페이지 획득
				viewPage = handler.process(request, response); // 호출하는 페이지의 객체
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// view 페이지가 존재한다면
			if(viewPage !=null) {
				// view 페이지로 포워딩
				RequestDispatcher rd = request.getRequestDispatcher(viewPage);
				rd.forward(request, response);

			}
		
		} // processRequest
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			processRequest(request, response);
		}
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			processRequest(request, response);
		}
		
		
		
		
		
		
	
		
		
		
		
}
