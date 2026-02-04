package Package1;

import java.util.HashSet;

public class TC_Hashset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  HashSet<Integer> numbers= new HashSet<>();
  numbers.add(10);
  numbers.add(20);
  numbers.add(120);
  numbers.add(30);
  numbers.add(40);
  numbers.add(50);
  for( Integer l1:numbers) {
	  System.out.println(l1);
  }
  System.out.println(numbers);
	}

}
