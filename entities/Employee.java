package entities;

public class Employee {

	private String name;
	private String email;
	private Double salary;
	
	public Employee() {
		
	}
	
	public Employee(String name, String email, double salary) {
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double getSalary() {
		return salary;
	}
	
	
	
}
