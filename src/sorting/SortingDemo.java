package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import stream.Emp;

public class SortingDemo {

	public static void main(String[] args) {
		List<Emp> list= new ArrayList<Emp>();
		list.add(new Emp(1, "A", 52,"Dep1"));
		list.add(new Emp(3, "B", 31,"Dep2"));
		list.add(new Emp(2, "B", 21,"Dep1"));
		list.add(new Emp(4, "A", 42,"Dep3"));
		list.add(new Emp(5, "E", 15,"Dep3"));
		
		//Sorted List Natural Order added Comparable in Emp class
		List<Emp> sortedListNaturalOrder =list.stream().sorted().collect(Collectors.toList());
		System.out.println("sortedListNaturalOrder "+sortedListNaturalOrder);
		
		//Sorted List Natural Order added Comparable in Emp class
		Comparator<Emp> empComparator=(a,b)->{return a.getSalary()-b.getSalary();};
		List<Emp> sortedList =list.stream().sorted(empComparator).collect(Collectors.toList());
		System.out.println("sortedList "+sortedList);
		
		//Sorting List By Collections in decreament order
		Comparator<Emp> empComparator1=(a,b)->{return b.getSalary()-a.getSalary();};
		Collections.sort(list,empComparator1);
		System.out.println("list "+list);
		
		//SOrting through comparing
		Comparator<Emp> nameComparator=Comparator.comparing(e->e.getName());
		List<Emp> lstsortingOrder=list.stream().sorted(nameComparator).collect(Collectors.toList());
		System.out.println("lstsortingOrder "+lstsortingOrder);
		//Multiple Sorting
		
		Comparator<Emp> ageComparator=Comparator.comparing(e->e.getSalary());
		List<Emp> multiplesortingOrder=list.stream().sorted(nameComparator.thenComparing(ageComparator)).collect(Collectors.toList());
		System.out.println("multiplesortingOrder "+multiplesortingOrder);
		
		// Map Sorting 
		Map<String, Integer> budget = new HashMap<>(); 
		budget.put("clothes", 120); 
		budget.put("grocery", 150); 
		budget.put("transportation", 100); 
		budget.put("utility", 130); 
		budget.put("rent", 1150);
		budget.put("miscellneous", 90);
		
		//Map Sorting by key
		Map<String, Integer> sortedBudgetByKey=budget.entrySet().stream().sorted(Map.Entry.comparingByKey())
												.collect(Collectors.toMap(e->e.getKey(), e->e.getValue(), (e1,e2)->e1,LinkedHashMap::new));
		System.out.println("sortedBudgetByKey "+sortedBudgetByKey);
		
		LinkedHashMap<String, Integer> sortedBudgetByValue = budget.entrySet().stream().sorted(Map.Entry.comparingByValue())
		                           .collect(Collectors.toMap(e->e.getKey(), e->e.getValue(),(e1,e2)->e2,LinkedHashMap::new));
		System.out.println("sortedBudgetByValue "+sortedBudgetByValue);
		
		
		//Map Sorting by key (descending order)
		Map<String, Integer> sortedBudgetByValueDesc = budget.entrySet().stream()
		    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		    .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println("sortedBudgetByValueDesc " + sortedBudgetByValueDesc);
		
		
		//Map Sorting another way. not recomnded..
	    Map<String, Integer> linkedHashMap= new LinkedHashMap<>();
		budget.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(e->linkedHashMap.put(e.getKey(),e.getValue()));
		System.out.println("linkedHashMap "+linkedHashMap);

	}

}