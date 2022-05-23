package captcha;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 自動產出 0000 ~ 9999 之間的認證碼(含干擾圖像)
// 並將該碼放到 session 屬性中以便比對

@WebServlet("/captcha/authcodeimage")
public class AuthCodeImageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 產生驗證碼 04d 位數不夠補0
		String authCode = String.format("%04d", new Random().nextInt(10000));
		System.out.println("authCode:"+authCode);
	    
		// 將驗證碼保留在 session 中以便後驗證
		req.getSession().setAttribute("authCode", authCode);
        
		// 產生驗證碼圖片
		
	}
	
	   // 產生驗證碼圖片方法
}
