package Package1;

import java.util.ArrayList;


public class TC_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ArrayList<Integer> list= new ArrayList<Integer>();
      list.add(0,new Integer(42));
      int total=list.get(0).intValue();
      System.out.println("total: "+total);
      
      ArrayList<String> l1= new ArrayList<String>();
      String str="hii";
      l1.add(str);
      l1.add("welcome to collection");
      System.out.println(l1.size());
      System.out.println(l1);
      for(String l2:l1) {
    	  System.out.println(l2);
      }
      
	}

}
