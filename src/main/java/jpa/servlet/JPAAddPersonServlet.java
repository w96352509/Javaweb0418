package jpa.servlet;

import java.io.IOException;
import java.util.Random;

import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.javafaker.Faker;

import jpa.entity.Person;

@WebServlet("/jpa/person/add")
public class JPAAddPersonServlet extends HttpServlet {

	private JPAService jpaService;
	
	
	
	@Override
	public void init() throws ServletException {
		// 此步驟 = spring 的 @autowired
		jpaService = new JPAService();
	}

	private void doHandel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = new Faker().name().lastName();
		int age = new Random().nextInt(80) + 1;

		Person person = new Person();
		person.setName(name);
		person.setAge(age);

		jpaService.addPerson(person);
		
		
		resp.getWriter().print("add Person Ok" + person.toString());
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
