package jdbc;

import java.util.Date;

public class User {
	private Integer id;
	private String name;
	private Integer age;
	private Date createtime;
	
	public User() {
		
	}
	
	public User(Integer id, String name, Integer age, Date createtime) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.createtime = createtime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", createtime=" + createtime + "]";
	}
	
	
	
	
}