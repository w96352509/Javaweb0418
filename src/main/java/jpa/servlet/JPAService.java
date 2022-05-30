package jpa.servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import jpa.entity.Person;


public class JPAService {

	private static EntityManagerFactory emf;
	private EntityManager em;
	
	public JPAService() {
		if(emf==null) {
			// 對應 persistence.xml persistence-unit 名稱
			emf = Persistence.createEntityManagerFactory("demo");
		}
		    em = emf.createEntityManager();
	}
	
	public EntityManager getEntityManager() {
		return em;
	}
	
	public void addPerson(Person person) {
		//防止衝線
				synchronized (em) {

					// 進行資料交易
					EntityTransaction etx = em.getTransaction();
					// 交易開始
					etx.begin();

					// 注入資料(person)
					em.persist(person);

					// 交易提交
					etx.commit();
				}
	}
	
}
