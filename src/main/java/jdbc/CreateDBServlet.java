package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jdbc/createdb")
public class CreateDBServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// DataBase 放置位置
		String db_path = "C:\\Users\\user\\git\\JavaWeb-20220418\\db";
		// DataBase 名稱
		String db_name = "webdb.db";
		// 建立 DataBase 連線參數
		String db_url = "jdbc:sqlite:" + db_path + "\\" + db_name;
		// DataBase 連線物件
		Connection conn = null;
		try {
			// 建立 driver(驅動)
			// Java JDBC 4.0一定版本可以不寫
			// jar 包取得 sql driver
			// 動態建立有利於更改版本更改("可變變數")
			Class.forName("org.sqlite.JDBC");
			// sqlite(無 username/password)
			conn = DriverManager.getConnection(db_url);
			resp.getWriter().print("SQLite create success");
		} catch (Exception e) {
			resp.getWriter().print(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					// 關閉資料庫連線
					conn.close();
				} catch (Exception e2) {
					resp.getWriter().print(e2.getMessage());
				}
			}
		}
	}
}
