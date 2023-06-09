package stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class ListArrayStream {

	public static void main(String[] args) {
		List<String> listStr=Arrays.asList("Mukesh", "Rakesh","Rakesh","Rakesh","iloveyou", "Mukesh", "Dinesh", "Suresh","Suresh");
		//Collectors.joining(",")
		String joinedStrings1=listStr.stream().collect(Collectors.joining(","));
		System.out.println(joinedStrings1);
		//String.join(",", listStr);
		String joinedStrings2=String.join(",", listStr);
		System.out.println(joinedStrings2);
		
		Map<String,Long> mapOfStringOccurence=listStr.stream().collect(Collectors.groupingBy(e->e,LinkedHashMap::new,Collectors.counting()));
		System.out.println("mapOfStringOccurence \n"+mapOfStringOccurence);
		
		//reduce() method....
		//Longest String from a String Array
		String longestString=listStr.stream().reduce((s1,s2)->s1.length()>s2.length()?s1:s2).get();
		System.out.println("longestString "+longestString);
		
		String combinedString=listStr.stream().reduce((a1,a2)->a1+"-"+a2).get();
		System.out.println("combinedString "+combinedString);
	
		List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);
		int sum=array.stream().reduce((a,b)->a+b).get();
		System.out.println("sum "+sum);
		
	}

}
