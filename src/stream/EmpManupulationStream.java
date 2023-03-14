package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmpManupulationStream {

	public static void main(String[] args) {
		List<Emp> list= new ArrayList<Emp>();
		list.add(new Emp(1, "A", 52,"Dep1"));
		list.add(new Emp(3, "B", 31,"Dep2"));
		list.add(new Emp(2, "B", 21,"Dep1"));
		list.add(new Emp(4, "A", 42,"Dep3"));
		list.add(new Emp(5, "E", 15,"Dep3"));
		
		//Get the Department wise employee list
		System.out.println("======Get the Department wise employee list");
		Map<String,List<Emp>> departmentWiseEmployee=list.stream().collect(Collectors.groupingBy(emp->emp.getDepartment()));
		departmentWiseEmployee.entrySet().stream().forEach(System.out::println);
		
		//Get department Wise Max Salary of employee
		System.out.println("======Get department Wise Max Salary of employee");
		Comparator<Emp> empSalaryComparator=(a1,a2)->{return a1.getSalary()-a2.getSalary();};
		Map<String,Optional<Emp>>departpmentWiseMaxSalary =list.stream().collect(Collectors.groupingBy(emp->emp.getDepartment(), Collectors.maxBy(empSalaryComparator)));
		departpmentWiseMaxSalary.entrySet().stream().forEach(System.out::println);
		
		//Get department Wise Employee Count
		System.out.println("======Get department Wise Employee Count");
		Map<String,Long>departpmentWiseEmployeeCount =list.stream().collect(Collectors.groupingBy(emp->emp.getDepartment(), Collectors.counting()));
		departpmentWiseEmployeeCount.entrySet().stream().forEach(System.out::println);
		
		//Employee with highest salary
	    //Integer maxSalary= list.stream().map(emp->emp.getSalary()).max((a,b)->{return a-b;}).get();
		Emp maxSalaryEmp=list.stream().sorted((a,b)->{return b.getSalary()-a.getSalary();}).findFirst().get();
		System.out.println("maxSalaryEmp "+maxSalaryEmp);
		
		//Employee with 2nd highest salary
		Comparator<Emp> com=(a,b)->{
	    	return b.getSalary()-a.getSalary();
	    };
	    Optional<Emp> secondHighestSal1=list.stream().sorted(com).skip(1).findFirst();
	    System.out.println("secondHighestSal1 "+secondHighestSal1.get());
	    
	    Optional<Emp> secondHighestSal2=list.stream().sorted(com).skip(1).max((a,b)->{return a.getSalary()-b.getSalary();});
	    System.out.println("secondHighestSal2 "+secondHighestSal2.get());
	    
	    Emp secondHighestSal3=list.stream().sorted(com).limit(2).min((a,b)->{return a.getSalary()-b.getSalary();}).get();
		System.out.println("secondHighestSal3 "+secondHighestSal3);
		
		//Increasing each emp salary by 10
		Function<Emp,Emp> fun=e->{
			e.setSalary(e.getSalary()+10);
	    	return e;
		};
		List<Emp> listEmp=list.stream().map(fun).collect(Collectors.toList());
		System.out.println("listEmp "+listEmp);
	}

}
