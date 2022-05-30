package jpa.servlet;

import java.io.IOException;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.javafaker.Faker;

import jpa.entity.Person;

@SuppressWarnings("serial")
@WebServlet("/jpa/personupdate")
public class JPAUpdatePersonServlet extends HttpServlet {

	private JPAService jpaService;
	
	
	
	@Override
	public void init() throws ServletException {
		// 此步驟 = spring 的 @autowired
		jpaService = new JPAService();
	}

	private void doHandel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		EntityManager em = jpaService.getEntityManager();
	    // 取得固定 ID 資料
		Person person    = em.find(Person.class, 1);
	    person.setAge(100);
	    
	    resp.getWriter().print(person);
	    // 開始進行資料交易
	    EntityTransaction etx = em.getTransaction();
	    // 交易開始
	    etx.begin();
	    // 注入資料
	    // merge(讓無關物件強制與資料庫有關係) 直到 close
	    em.persist(person); 
	    // 交易提交
	    etx.commit();
	    // close 以前操作可以被管理
	    em.close();
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
