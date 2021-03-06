package jpa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/jpa/person/query")
public class JPAQueryPersonServlet extends HttpServlet {

	private JPAService jpaService;
	
	
	
	@Override
	public void init() throws ServletException {
		// 此步驟 = spring 的 @autowired
		jpaService = new JPAService();
	}

	private void doHandel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html;charset=utf-8");
      PrintWriter out = resp.getWriter();
	  out.print(jpaService.getPersonById(1)+"<p/>");
	  out.print(jpaService.queryPersonByAge(20)+"<p/>");
	  out.print(jpaService.queryAll2()+"<p/>");
	  
	  out.print(jpaService.findAll()+"<p/>");
	  // % 字元 字元在尾巴
	  // 字元 % 字元在字首
	  // %字元% 包含
	  out.print(jpaService.findByName("%er%")+"<p/>");
	  out.print(jpaService.findByAgeBetween(10,30)+"<p/>");
	  
	  
	}
		

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandel(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandel(req, resp);
	}

}
