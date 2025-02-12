package controller;

import java.io.IOException;

import handler.CommandHandler;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MVC2UseFilterController extends HttpServlet {
   
   public void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // /list.do
      String command = request.getRequestURI();
      
      if (command.indexOf(request.getContextPath()) == 0) {
         // list.do
         command = command.substring(request.getContextPath().length()+1);
      }
      
      // handler.ListCommand
      String handlerClassStr = "handler." + command.substring(0, 1).toUpperCase() 
            + command.substring(1, command.indexOf(".do")) + "Command";
      
      CommandHandler handlerObj = null;
      try {
         Class handlerClass = Class.forName(handlerClassStr);
         handlerObj = (CommandHandler)handlerClass.newInstance();
      } catch (Exception ex) {
         ex.printStackTrace();
      }      
      
      String viewPage = null;
      try {
         viewPage = handlerObj.process(request, response);
         if (viewPage != null) {
            RequestDispatcher rd = request.getRequestDispatcher(viewPage);
            rd.forward(request, response);
         }
      } catch (Exception ex) {
         ex.printStackTrace();
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

} // class














