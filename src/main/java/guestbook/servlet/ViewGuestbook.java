package guestbook.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.service.JPAService;

@WebServlet("/guestbook/view")
public class ViewGuestbook extends HttpServlet {
	private JPAService service = new JPAService();
	
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 重導頁面
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/guestbook_view.jsp");
		req.setAttribute("guestbooks", service.queryGuestbook());
		req.setAttribute("button_name", "add");
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