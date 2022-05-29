package jdbc;

import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class BaseServlet extends HttpServlet {
	protected Connection conn;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		conn = ((Connection)config.getServletContext().getAttribute("conn"));
	}
	
}