package jspmvc.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jspmvc.model.MVCDTO;
import jspmvc.service.MVCService;
import jspmvc.service.impl.MVCDeleteService;
import jspmvc.service.impl.MVCGetService;
import jspmvc.service.impl.MVCInsertService;
import jspmvc.service.impl.MVCSelectService;
import jspmvc.service.impl.MVCUpdateService;

public class MVCController extends HttpServlet {
	
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
		
		String uri = request.getRequestURI();
		String command = uri.substring(request.getContextPath().length()+1);
		
		if (command!=null && !command.equals("")) {
			if (command.equals("insertForm.do")) {
				response.sendRedirect("/jsp/insertForm.jsp");
			} else if (command.equals("insert.do")) {
				MVCService service = new MVCInsertService();
				MVCDTO dto = new MVCDTO();
				dto.setTitle(request.getParameter("title"));
				dto.setContent(request.getParameter("content"));
				int result = service.insert(dto);
				if (result>0) {
					response.sendRedirect("/select.do");
				}
			} else if (command.equals("select.do")) {
				MVCService service = new MVCSelectService();
				List<MVCDTO> list = service.select();
				request.setAttribute("list", list);
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/select.jsp");
				rd.forward(request, response);
			} else if (command.equals("get.do")) {
				MVCService service = new MVCGetService();
				MVCDTO dto = service.get(Integer.parseInt(request.getParameter("sid")));
				request.setAttribute("dto", dto);
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/get.jsp");
				rd.forward(request, response);
			} else if (command.equals("delete.do")) {
				MVCService service = new MVCDeleteService();
				service.delete(Integer.parseInt(request.getParameter("sid")));
				response.sendRedirect("/select.do");
			} else if (command.equals("updateForm.do")) {
				MVCService service = new MVCGetService();
				MVCDTO dto = service.get(Integer.parseInt(request.getParameter("sid")));
				request.setAttribute("dto", dto);				
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/updateForm.jsp");
				rd.forward(request, response);				
			} else if (command.equals("update.do")) {
				MVCDTO dto = new MVCDTO();
				dto.setSid(Integer.parseInt(request.getParameter("sid")));
				dto.setTitle(request.getParameter("title"));
				dto.setContent(request.getParameter("content"));
				MVCService service = new MVCUpdateService();
				service.update(dto);
				request.setAttribute("dto", dto);				
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/get.jsp");
				rd.forward(request, response);				
			}
		}
		
	} // process

} // class














