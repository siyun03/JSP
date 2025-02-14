package jdbcboard.listener;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String databaseProp = sce.getServletContext().getInitParameter("databaseProp");
		String sqlProp = sce.getServletContext().getInitParameter("sqlProp");
		String commandProp = sce.getServletContext().getInitParameter("commandProp");
		
		
		Properties databaseProperties = new Properties();
		Properties sqlProperties = new Properties();
		Properties commandProperties = new Properties();
		
		try {
			
			databaseProperties.load(new FileReader(sce.getServletContext().getRealPath(databaseProp)));
			sqlProperties.load(new FileReader(sce.getServletContext().getRealPath(sqlProp)));
			commandProperties.load(new FileReader(sce.getServletContext().getRealPath(commandProp)));
			
			// 3개의 Properties를 appProperties이라는 Properties로 합쳐서 서블릿컨텍스트에 appProp속성변수로 저장하기!
//			Properties appProperties = new Properties();
//			appProperties.putAll(databaseProperties);
//			appProperties.putAll(sqlProperties);
//			appProperties.putAll(commandProperties);
			
			sce.getServletContext().setAttribute("databaseProperties", databaseProperties);
			sce.getServletContext().setAttribute("sqlProperties", sqlProperties);
			sce.getServletContext().setAttribute("commandProperties", commandProperties);
			//sce.getServletContext().setAttribute("appProp", appProperties);
			
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
}
