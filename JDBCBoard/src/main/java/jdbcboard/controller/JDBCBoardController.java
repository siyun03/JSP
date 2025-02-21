package jdbcboard.controller;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jdbcboard.model.Article;
import jdbcboard.model.Board;
import jdbcboard.model.Member;
import jdbcboard.model.Reply;
import jdbcboard.service.ArticleService;
import jdbcboard.service.impl.ArticleServiceimpl;
import jdbcboard.service.impl.BoardServiceimpl;
import jdbcboard.service.impl.MemberServiceimpl;
import jdbcboard.service.impl.ReplyServiceimpl;

public class JDBCBoardController extends HttpServlet implements Serializable {
   
   private static final long serialVersionUID = 239487932473924L;
   
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
      int result = 0;
      String viewPage = (String)request.getAttribute("viewPage");
      
      Member member = null;
      Board board = null;
      Article article = null;
      Reply reply = null;
      
      Gson gson = new GsonBuilder().create();
      PrintWriter pw = null;
      String jsonStr = null;
      
      switch (requestURI) {
      
      	 case "index.do" :
      		 response.sendRedirect("/selectArticle.do");
      		 break;
      	
         case "selectMember.do":
            resultObj = MemberServiceimpl.getMemberServiceImpl().selectMember();
            request.setAttribute("memberList", resultObj);
            forward(request, response, viewPage);
            break;
            
         case "getMember.do":
            resultObj = MemberServiceimpl.getMemberServiceImpl().getMember(request.getParameter("mid"));
            request.setAttribute("member", resultObj);
            forward(request, response, viewPage);
            break;
            
         case "insertMemberForm.do":
            response.sendRedirect(viewPage);
            break;
            
         case "insertMember.do":
            member = new Member(
               request.getParameter("mid"),
               request.getParameter("mname"),
               request.getParameter("malias"),
               request.getParameter("mpass"),
               request.getParameter("memail"),
               request.getParameter("mcp"),
               "N"
            );
            MemberServiceimpl.getMemberServiceImpl().insertMember(member);      
            response.sendRedirect("/selectMember.do");
            break;
            
         case "updateMemberForm.do":
            resultObj = MemberServiceimpl.getMemberServiceImpl().getMember(request.getParameter("mid"));
            request.setAttribute("member", resultObj);   
            forward(request, response, viewPage);
            break;
            
         case "updateMember.do":
            member = new Member(
               request.getParameter("mid"),
               request.getParameter("mname"),
               null,
               request.getParameter("malias"),
               request.getParameter("memail"),
               request.getParameter("mcp"),
               "N"
            );
            MemberServiceimpl.getMemberServiceImpl().updateMember(member);
            response.sendRedirect("/selectMember.do");
            break;
            
         case "deleteMember.do":
            MemberServiceimpl.getMemberServiceImpl().deleteMember(request.getParameter("mid"));
            response.sendRedirect("/selectMember.do");
            break;
            
         case "login.do" : 
        	 boolean loginResult = MemberServiceimpl.getMemberServiceImpl().checkLogin(
        			 request.getParameter("mid"),
        			 request.getParameter("mpass")
        			 );
        	 	if(loginResult) {
        	 		request.getSession().setAttribute("ss_mid", request.getParameter("mid"));
        	 		request.setAttribute("loginResult", true);
        	 	}else {
        	 		request.setAttribute("loginResult", false);
				}
        	 	response.sendRedirect("/selectArticle.do");
        	 break;
            
         case "logout.do" :
        	 HttpSession hs = request.getSession();
        	 if(hs!=null) hs.invalidate();
     	 	 response.sendRedirect("/selectArticle.do");
        	 break;
            
         case "selectBoard.do" :
            resultObj = BoardServiceimpl.getBoardServiceImpl().selectBoard();
            request.setAttribute("boardList", resultObj);
            forward(request, response, viewPage);
            break;
            
         case "selectBoardJson.do" :
        	 resultObj = BoardServiceimpl.getBoardServiceImpl().selectBoard();
             jsonStr = gson.toJson(resultObj);
             response.setContentType("application/json");
             pw = response.getWriter();
             pw.write(jsonStr);
             pw.flush();
             break;
        	 
         case "getBoard.do":
             resultObj = BoardServiceimpl.getBoardServiceImpl().getBoard(Integer.parseInt(request.getParameter("bid")));
             request.setAttribute("board", resultObj);
             forward(request, response, viewPage);
             break;
            
         case "insertBoardForm.do":
            response.sendRedirect(viewPage);
            break;            
            
         case "insertBoard.do":
            board = new Board(
            		0, 
            		request.getParameter("bname"), 
            		0
            		);
            BoardServiceimpl.getBoardServiceImpl().insertBoard(board);
            response.sendRedirect("/selectBoard.do");
            break;
            
         case "updateBoardForm.do":
        	resultObj = BoardServiceimpl.getBoardServiceImpl().getBoard(Integer.parseInt(request.getParameter("bid")));
            request.setAttribute("board", resultObj);
            forward(request, response, viewPage);
            break;
            
         case "updateBoard.do":
            board = new Board(
               Integer.parseInt(request.getParameter("bid")), 
               request.getParameter("bname"), 
               0
            );
            BoardServiceimpl.getBoardServiceImpl().updateBoard(board);
            response.sendRedirect("/selectBoard.do");
            break;
            
         case "deleteBoard.do":
            result = BoardServiceimpl.getBoardServiceImpl().deleteBoard(
               Integer.parseInt(request.getParameter("bid"))
            );
            response.sendRedirect("/selectBoard.do");   
            break;
            
         case "selectArticle.do":
        	 String searchBoard = request.getParameter("bid");
        	 String searchClass = request.getParameter("searchClass");
        	 String searchVal = request.getParameter("searchVal");
             resultObj = ArticleServiceimpl.getArticleServiceImpl().selectArticle(searchBoard,searchClass,searchVal);
             request.setAttribute("articleList", resultObj);
             request.setAttribute("searchBoard", searchBoard);
             request.setAttribute("searchClass", searchClass);
             request.setAttribute("searchVal", searchVal);
             forward(request, response, viewPage);
             break;
             
          case "getArticle.do":
        	 int aid = Integer.parseInt(request.getParameter("aid"));
        	 ArticleService as = ArticleServiceimpl.getArticleServiceImpl();
        	 result = as.increaseAvcnt(aid);
        	 resultObj = as.getArticle(aid);
             request.setAttribute("article", resultObj);
             forward(request, response, viewPage);
             break;
             
             
          case "insertArticleForm.do":
             response.sendRedirect(viewPage);
             break;            
             
          case "insertArticle.do":
             article = new Article(
                   0,
                   request.getParameter("asubject"),
                   request.getParameter("acontent"),
                   0,
                   0,
                   0,
                   null,
                   "N",
                   request.getParameter("mid"),
                   Integer.parseInt(request.getParameter("bid")),
                   null
             );
             result = ArticleServiceimpl.getArticleServiceImpl().insertArticle(article);
             request.setAttribute("result", result);
             response.sendRedirect("/selectArticle.do");   
             break;
             
          case "updateArticleForm.do" :
             resultObj = ArticleServiceimpl.getArticleServiceImpl()
                   .getArticle(Integer.parseInt(request.getParameter("aid")));
             request.setAttribute("article", resultObj);
             forward(request, response, viewPage);            
             break;            
             
          case "updateArticle.do" :
             article = new Article(
                   Integer.parseInt(request.getParameter("aid")),
                   request.getParameter("asubject"),
                   request.getParameter("acontent"),
                   0,
                   0,
                   0,
                   null,
                   "N",
                   null,
                   0,
                   null
             );
             result = ArticleServiceimpl.getArticleServiceImpl().updateArticle(article);
             request.setAttribute("result", result);
             response.sendRedirect("/selectArticle.do");
             break;
             
          case "deleteArticle.do" :
             result = ArticleServiceimpl.getArticleServiceImpl().deleteArticle(
                Integer.parseInt(request.getParameter("aid"))
             );
             request.setAttribute("result", result);
             response.sendRedirect("/selectArticle.do");
             break;
            
         case "selectReply.do" :
            resultObj = ReplyServiceimpl.getReplyServiceImpl().selectReply();
            jsonStr = gson.toJson(resultObj);
            response.setContentType("application/json");
            pw = response.getWriter();
            pw.write(jsonStr);
            pw.flush();
            break;
            
         case "insertReply.do" :
        	BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        	gson = new GsonBuilder().create();
        	reply = gson.fromJson(reader.readLine(), Reply.class);
            reply = new Reply(
               0,
               reply.getRcontent(),
               null,
               "N",
               reply.getMid(),
               reply.getAid()
            );
            ReplyServiceimpl.getReplyServiceImpl().insertReply(reply);
            break;
            
         case "deleteReply.do" :
            ReplyServiceimpl.getReplyServiceImpl().deleteReply(Integer.parseInt(request.getParameter("rid")));
            break;
            
      }
      
   } // process
   
   private void forward(HttpServletRequest request, HttpServletResponse response, 
         String viewPage) throws ServletException, IOException {
      RequestDispatcher rd = request.getRequestDispatcher(viewPage);
      rd.forward(request, response);      
   }

} // class






































