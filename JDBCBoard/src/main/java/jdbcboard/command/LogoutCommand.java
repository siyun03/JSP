package jdbcboard.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutCommand implements Command{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		return "";
	}

}
