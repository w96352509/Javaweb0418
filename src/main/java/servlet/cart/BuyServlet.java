package servlet.cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/cart/buy")
public class BuyServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session = req.getSession(true);
		 // 購物車內容
		 List<String> products = null;
		 synchronized(session) {
			// 步驟二
			// 是否 product 的 session 變數是否已經存在
			if (session.getAttribute("products") == null) { //第一次買東西
				products = new ArrayList<>(); //支援多執行續
				}else {
					products=(List<String>)session.getAttribute("products"); 
				}
			// 步驟一
			// 取得購買商品
			String product = req.getParameter("product");
			//將商品放到購物內容中
			products.add(product);
			//回存到 session 變數中
			session.setAttribute("products", products);
		 }
		 // 重導 "servlet/cart/vi"
		 RequestDispatcher rd  = req.getRequestDispatcher("/servlet/cart/view");
		 rd.forward(req, resp);
	}
}
