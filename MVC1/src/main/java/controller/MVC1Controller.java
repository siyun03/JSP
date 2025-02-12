package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MVC1Controller extends HttpServlet{

   
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      processRequest(request, response);
   }
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      processRequest(request, response);
   }
   
   public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      
      //요청 파라미터 분석
      String paramRequest = request.getParameter("request")==null
                              ?"": request.getParameter("request");
      
      //요청 처리 후 결과를 저장할 객체
      Object resultObj = null;
      
      //처리 결과를 표현할 View인 JSP페이지의 경로를 저장
      Object viewJSP = null;
      
      //요청에 따라서 결과를 생성하고 뷰를 결정
      if(paramRequest.equals("name")) {
         resultObj="홍길동";
         viewJSP = "/jsp/name.jsp";
      }else if (paramRequest.equals("age")) {
         resultObj="30";
         viewJSP ="/jsp/age.jsp";
      }
      //request 속성변수에 처리 결과를 저장
      request.setAttribute("resultObj", resultObj);
      
      //결과를 뷰에 전달 (포워딩)
      RequestDispatcher rd = request.getRequestDispatcher((String)viewJSP);
      rd.forward(request, response);
      
   }//
}//
