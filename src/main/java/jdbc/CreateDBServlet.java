package jdbc;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jdbc/createdb")
public class CreateDBServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String db_path = "C:\\Users\\user\\git\\JavaWeb-20220418\\db"; // database路徑
		Connection conn;
		try {
            // 建立 driver
			// jar 包取得 sql driver
			Class.forName("org.sqlite.JDBC");
		} catch (Exception e) {

		}
	}
}
