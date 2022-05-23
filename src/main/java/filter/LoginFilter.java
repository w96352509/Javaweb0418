package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/report/*"} )
public class LoginFilter extends HttpFilter{

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
        // 1. 判斷是否此人已登入
		HttpSession session = req.getSession();
		// 得到前端的屬性: "pass"
		Object data =  session.getAttribute("pass");
		// Object 轉 Boolean 前要加+""改回String
		// 2.此人尚未登入或登入已過時
		if(data == null || Boolean.parseBoolean(data+"") != true) {
	     // 2.1有把 username , password , usercode 傳遞過來
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String userCode = req.getParameter("usercode");
		String authCode = session.getAttribute("authCode")+"";
		if( username.equals("admin") && password.equals("1234") && userCode.equals(usercode)) {
			// 通過驗證
			chain.doFilter(req, res);
		}
		 // 2.2重導到登入頁面
		 RequestDispatcher rd = req.getRequestDispatcher("/login");
		 rd.forward(req, res);
		 
		}else {
			// 3.反之通過驗證
			chain.doFilter(req, res);
		}
		
	}
}
