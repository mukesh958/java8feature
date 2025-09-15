package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelStreamDemo {

	public static void main(String[] args) {
		List<Integer> lists= new ArrayList<>();
		for(int i=0;i<50;i++){
			lists.add(i);
		}
		long strat1=System.currentTimeMillis(); 
		normalStreaming(lists);
		long end1=System.currentTimeMillis(); 
		System.out.println("\nTotal Time1 "+(end1-strat1)/1000 +"s");
		
		System.out.println("==============");
		
		long strat2=System.currentTimeMillis(); 
		parallelStreaming(lists);
		long end2=System.currentTimeMillis(); 
		System.out.println("\nTotal Time2 "+(end2-strat2)/1000 +"s");

	}
	public static void normalStreaming(List<Integer> lists){
		lists.stream().forEach(ls->{
			System.out.print(ls+" ");
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	public static void parallelStreaming(List<Integer> lists){
		AtomicInteger a=new AtomicInteger();
		lists.parallelStream().forEach(ls->{
			System.out.print(ls+" ");
			a.incrementAndGet();
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		System.out.println("a "+a.get());
	}
}
