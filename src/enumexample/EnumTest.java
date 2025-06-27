package enumexample;

import java.util.Hashtable;

public class EnumTest {
	public static void main(String... arg) {
		Direction north = Direction.NORTH;
		System.out.println(north);
		
		if(north.equals("NORTH")){// Invalid
			System.out.println("NORTH");
		}
		
		Hashtable<String, String> hashtable= new Hashtable<>();
		hashtable.put(null, "A");
	}

}
