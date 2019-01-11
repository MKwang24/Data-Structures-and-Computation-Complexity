package Qs;

import java.util.ArrayList;

//Given two sorted lists of Integers as input, write a method that produces a sorted list of 
//Integers as output that represents the union of the two input lists.  If the size of the two input 
//lists are respectively a and b, the running time and space required by the algorithm should both be 
//O(a + b).
public class Q1 {
	
public ArrayList<Integer> union(ArrayList<Integer> al1, ArrayList<Integer> al2){
	ArrayList<Integer> ali = new ArrayList<Integer>();
	do{
		int ii = Math.min(al1.get(0), al2.get(0));
		ali.add(ii);
		if (al1.contains(ii)) {
			al1.remove(0);
		}
		if (al2.contains(ii)) {
			al2.remove(0);
		}
	}while (al1.size()!=0 && al2.size() !=0) ;
	ali.addAll(((al1.size()==0)? al2:al1));
	return ali;	
}
	
public static void main(String[]args) {
	

	ArrayList<Integer> al1 = new ArrayList<Integer>();
	ArrayList<Integer> al2 = new ArrayList<Integer>();
	al1.add(1);
	al1.add(3);al1.add(5); al1.add(7);al1.add(9);
	al2.add(1);
	al2.add(4);al2.add(9);al2.add(16);al2.add(25);
	Q1 q = new Q1();
	System.out.println(al1);//1 3 5 7 9 
	System.out.println(al2);// 1 4 9 16 25
	System.out.println(q.union(al1, al2));  //1 3 4 5 7 9 16 25
}
}
