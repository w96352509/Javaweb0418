package servlet.cart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/cart/view")
public class ViewCartServlet extends HttpServlet {

	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 重導 "/jsp/cart/cart.jsp"
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/cart/cart.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

}
