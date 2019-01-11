package Qs;
import java.util.ArrayList;
import java.util.HashMap;

import tokenizer.SimpleTokenizer;

//		Build a class that maintains a count of all bigrams (pairs of words occurring next to each 
//		other) in a TRIE (see <https://en.wikipedia.org/wiki/Trie>).  An example TRIE is below for
//			"to be or not to be Shakespeare"

//```            
/// to - be: 2
//ROOT - or - not: 1
//\ not - to: 1
//\ be - or: 1
//     \ shakespeare: 1
//```
public class Q3 {
	private ArrayList<String> _tokenlist ;
	private HashMap<String, HashMap<String,Integer>> storage;
	private SimpleTokenizer _tokenizer;
	
	public Q3( SimpleTokenizer st) { 
		storage = new HashMap<String, HashMap<String,Integer>>();
		_tokenizer = st;
		}
	
	public void buildTRIE(String s ) {
		_tokenlist = _tokenizer.tokenize(s);
		for (int i = 0; i< _tokenlist.size()-1;i++) {
			String first =_tokenlist.get(i);
			String second = _tokenlist.get(i+1);
			if (!storage.containsKey(first)){
				storage.put(first, new HashMap<String,Integer>());	
				storage.get(first).put(second, 1);
			}
			else if ((storage.get(first).containsKey(second))) {
				storage.get(first).put(second,storage.get(first).get(second)+1);
			}
			else if (storage.containsKey(first)&&!(storage.get(first).containsKey(second))) {
				storage.get(first).put(second, 1);
			}
		}
	}
	public int getFreq(String s1, String s2) {
		
		return storage.get(s1).get(s2);
		}
	
	public static void main(String [] arg) {
		String shake = "to be or not to be shakespeare";
		Q3 q = new Q3(new SimpleTokenizer() );
		q.buildTRIE(shake);
		System.out.println(q.storage);
	}
}
