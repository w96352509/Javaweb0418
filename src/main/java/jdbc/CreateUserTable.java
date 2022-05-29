package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create/user/table")
public class CreateUserTable extends BaseServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sql =  "create table if not exists user("
					+ "id integer primary key,"
					+ "name text not null,"
					+ "age integer,"
					+ "createtime datetime default current_timestamp"
					+ ")";
		
		try(Statement stmt = conn.createStatement()) {
			// 得到 sql 結果集
			boolean flag = stmt.execute(sql);
			if(flag) {
				resp.getWriter().print("select user ok");
			} else {
				resp.getWriter().print("create user ok");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}