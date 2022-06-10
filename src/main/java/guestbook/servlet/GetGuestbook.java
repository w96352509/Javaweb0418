package guestbook.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.entity.Guestbook;
import guestbook.service.JPAService;

@WebServlet("/guestbook/get")
public class GetGuestbook extends HttpServlet {
	
	private JPAService service = new JPAService();
	
	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Guestbook guestbook = service.getGuestbookById(id);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/guestbook_view.jsp");
		req.setAttribute("guestbooks", service.queryGuestbook());
		req.setAttribute("button_name", "update"); // 改成 update
		req.setAttribute("guestbook", guestbook); // 傳給 jsp 並放到 form 表單中使用
		
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