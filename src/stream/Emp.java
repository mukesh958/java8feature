package stream;

public class Emp {

	Integer id;
	String name;
	Integer salary;
	String department;
	
	public Emp(Integer id, String name, Integer salary, String department) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department=department;
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
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", salary=" + salary +", department="+department;
	}
	
	
	
}
