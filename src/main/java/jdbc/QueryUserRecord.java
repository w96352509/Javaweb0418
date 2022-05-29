package jdbc;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.javafaker.Faker;
import com.google.gson.Gson;

// 多筆查詢
@WebServlet("/query/user/record")
public class QueryUserRecord extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sql = "select id, name, age, createtime from user order by id";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			List<User> users = new ArrayList<>();
			int count = 0;
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setCreatetime(rs.getDate("createtime"));
				users.add(user);
				count++;
			}
			//resp.getWriter().print("count = " + count);
			//resp.getWriter().print(users);
			// 轉化為 json 結構
			Gson gson = new Gson();
			String jsonString = gson.toJson(users);
			resp.setContentType("application/json;charset=utf-8");
			resp.getWriter().print(jsonString);
		} catch (Exception e) {
			resp.getWriter().print(e);
		}
	}

}