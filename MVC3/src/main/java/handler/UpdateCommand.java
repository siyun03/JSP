package handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateCommand implements CommandHandler{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		return "/jsp/update.jsp";
	}
}
