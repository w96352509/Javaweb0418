package jpa.servlet;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
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

	// 單筆
	public Person getPersonById(Integer id) {
	  return em.find(Person.class, id);
	}
	
	// 全搜(1)
	public List<Person> queryAll(){
		Query query = em.createQuery("select p from Person p");
		List<Person> list = query.getResultList();
		return list;
	}
	
	// 全搜(2)
	public List<Person> queryAll2(){
		Query query = em.createQuery("from Person p" , Person.class);
		List<Person> list = query.getResultList();
		return list;
	}
	
	public List<Person> queryPersonByAge(Integer age){
		// :... JPQL 語法
		String sql = "select p from Person p where p.age= :age";
		Query query = em.createQuery(sql);
		query.setParameter("age", age); // 對應 :age
		List<Person> list = query.getResultList();
	    return list;
	}
	
	
}
