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

@WebServlet("/guestbook/update")
public class UpdateGuestbook extends HttpServlet {
	private JPAService service = new JPAService();
	
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 擷取網頁表單內容
		Integer id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		String content = req.getParameter("content");
		// 建立 guestbook 物件
		Guestbook guestbook = new Guestbook();
		guestbook.setId(id);
		guestbook.setUsername(username);
		guestbook.setContent(content);
		// 修改 guestbook 資料
		service.updateGuestbook(guestbook);
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