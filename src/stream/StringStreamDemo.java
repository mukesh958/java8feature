package stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringStreamDemo {

	public static void main(String[] args) {
		//Occurrence of each character in a String
				String str="iloveindialol";
				Map<String,Long> mapOfCharacterOccurence=Arrays.asList(str.split("")).stream().collect(Collectors.groupingBy(e->e,Collectors.counting()));
				System.out.println("mapOfCharacterOccurence "+mapOfCharacterOccurence);
				
				//Duplicate character from a string
				List<String> duplicateCharacter=Arrays.asList(str.split("")).stream().collect(Collectors.groupingBy(e->e,Collectors.counting())).
									entrySet().stream().filter(e->e.getValue()>1).map(e->e.getKey()).collect(Collectors.toList());
				System.out.println("duplicateCharacter "+duplicateCharacter);
				
				//First non repeated character from string
				String firstNonRepeatableCharacter=Arrays.asList(str.split("")).stream().collect(Collectors.groupingBy(e->e,LinkedHashMap::new,Collectors.counting())).
						entrySet().stream().filter(e->e.getValue()==1).map(e->e.getKey()).findFirst().get();
				System.out.println("firstNonRepeatableCharacter "+firstNonRepeatableCharacter);
				
				//Second highest number from an array
				int[] arr={12,3,31,13,34,52,45,56,98,100,106};
				Integer secondHighest=Arrays.stream(arr).boxed().
						sorted((a1,a2)->{return a2-a1;}).skip(1).findFirst().get();
				System.out.println("secondHighest "+secondHighest);

	}

}
