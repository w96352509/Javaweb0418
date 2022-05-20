package entity;

import java.util.Arrays;

public class Employee {
	
	private  String empName;
	private Integer empAge;
	private String empSex;
	private String empPos;
	private String empBirth;
	private String[] empLang;
	private String empMemo;
	
	public Employee() {
		
	}
	
	public Employee(String empName, Integer empAge, String empSex, String empPos, String empBirth, String[] empLang,
			String empMemo) {
		super();
		this.empName = empName;
		this.empAge = empAge;
		this.empSex = empSex;
		this.empPos = empPos;
		this.empBirth = empBirth;
		this.empLang = empLang;
		this.empMemo = empMemo;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getEmpAge() {
		return empAge;
	}
	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}
	public String getEmpSex() {
		return empSex;
	}
	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}
	public String getEmpPos() {
		return empPos;
	}
	public void setEmpPos(String empPos) {
		this.empPos = empPos;
	}
	public String getEmpBirth() {
		return empBirth;
	}
	public void setEmpBirth(String empBirth) {
		this.empBirth = empBirth;
	}
	public String[] getEmpLang() {
		return empLang;
	}
	public void setEmpLang(String[] empLang) {
		this.empLang = empLang;
	}
	public String getEmpMemo() {
		return empMemo;
	}
	public void setEmpMemo(String empMemo) {
		this.empMemo = empMemo;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empAge=" + empAge + ", empSex=" + empSex + ", empPos=" + empPos
				+ ", empBirth=" + empBirth + ", empLang=" + Arrays.toString(empLang) + ", empMemo=" + empMemo + "]";
	}
	
	
	
}
