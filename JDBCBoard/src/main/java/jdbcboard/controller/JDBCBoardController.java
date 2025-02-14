package jdbcboard.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbcboard.service.impl.ArticleServiceimpl;
import jdbcboard.service.impl.BoardServiceimpl;
import jdbcboard.service.impl.MemberServiceimpl;

public class JDBCBoardController extends HttpServlet{
	
	// 요청에 따라 서비스를 호출
	// 서비스의 결과를 request에 저장
	// 결과를 보여줄 뷰로 포워딩
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		process(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String requestURI = (String)request.getAttribute("requestURI");
		Object resultObj = null;
		String viewPage = (String)request.getAttribute("viewPage");
		
		System.out.println(requestURI);
		System.out.println(viewPage);
		
		switch(requestURI) {
		
		case "selectMember.do" :
			resultObj = new MemberServiceimpl().selectMember();
			request.setAttribute("memberList", resultObj);
			break;
				
		case "getMember.do" :
			String mid = request.getParameter("mid");
			resultObj = new MemberServiceimpl().getMember(mid);
			request.setAttribute("member", resultObj);
			break;
			
		case "selectBoard.do" :
			resultObj = new BoardServiceimpl().selectBoard();
			request.setAttribute("boardList", resultObj);
			break;
			
		case "getBoard.do" :
			
			resultObj = new BoardServiceimpl().getBoard(Integer.parseInt(request.getParameter("bid")));
			request.setAttribute("board", resultObj);
			break;
			
		case "selectArticle.do" :
			resultObj = new ArticleServiceimpl().selectArticle();
			request.setAttribute("articleList", resultObj);
			break;
			
		case "getArticle.do" :
			resultObj = new ArticleServiceimpl().getArticle(Integer.parseInt(request.getParameter("aid")));
			request.setAttribute("article", resultObj);
			break;	
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // class
