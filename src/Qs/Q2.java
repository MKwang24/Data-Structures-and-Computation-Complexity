package Qs;
//**Q2.** Given an unordered list of Doubles as input, produce a sorted list of the top-k Doubles
//as output.  Use a Min Heap ("Min" is not a typo -- figure out why) to maintain the top-k results
//of n doubles in O(n log k) time and O(k) space (not counting the space for the input array of n 
//numbers).
import java.util.ArrayList;
import java.util.List;
import heap.BinaryHeap;

import java.util.Collections;
public class Q2 {
	
	public List<Double> gettopkfast(ArrayList<Double> al ,int k){
		ArrayList<Double> ald= new ArrayList<Double>();
		BinaryHeap<Double> bh = new BinaryHeap<Double>();
		for (int i = 0; i<k;i++) {
			bh.add(al.get(i));
			ald.remove(al.get(i));
		}
		for (int i = 0; i<al.size();i++) {
			bh.add(al.get(i));
			if(al.indexOf(i)+1!=al.size()) 
			bh.remove();	
		}
		do {
			ald.add((Double)bh.remove());
		}while(!bh.isEmpty());
		return ald;
	}
	public List<Double> gettopkslow(List<Double> al1 ,int k){
		List<Double> all = new ArrayList<Double>();
		Collections.sort(al1);
		for (int i = al1.size()-k; i<al1.size();i++) {
			all.add(al1.get(i));
		}
		return all;
	}
	public static void main(String[]args) {
		Q2 q = new Q2();
		ArrayList<Double> bh = new ArrayList<Double>();
		bh.add(6.0);bh.add(1.0);bh.add(3.0);bh.add(7.0);bh.add(5.0);bh.add(2.0);bh.add(4.0);
		bh.add(1.0);bh.add(8.0);bh.add(9.0);bh.add(9.0);
		System.out.println(q.gettopkslow(bh, 5));// 6 7 8 9 9 
		System.out.println(q.gettopkfast(bh, 5));// 6 7 8 9 9
	}
}
