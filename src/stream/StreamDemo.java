package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDemo {

	public static void main(String[] args) {
		List<Emp> list= new ArrayList<Emp>();
		list.add(new Emp(1, "A", 52,"Dep1"));
		list.add(new Emp(3, "B", 31,"Dep2"));
		list.add(new Emp(2, "B", 21,"Dep1"));
		list.add(new Emp(4, "A", 42,"Dep3"));
		list.add(new Emp(5, "E", 15,"Dep3"));
		
		// Get the Department wise employee list
		Map<String,List<Emp>> departmentWiseEmployee=list.stream().collect(Collectors.groupingBy(emp->emp.getDepartment()));
		System.out.println("departmentWiseEmployee "+departmentWiseEmployee);
	}

}
