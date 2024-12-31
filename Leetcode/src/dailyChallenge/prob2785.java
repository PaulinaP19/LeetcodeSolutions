package LeetCode;

import java.util.HashSet;
import java.util.PriorityQueue;

public class prob2785 {
	public static String sortVowels(String s) {
		HashSet<Character> charSet = new HashSet<>();

		charSet.add('A');
		charSet.add('E');
		charSet.add('I');
		charSet.add('O');
		charSet.add('U');
		charSet.add('a');
		charSet.add('e');
		charSet.add('i');
		charSet.add('o');
		charSet.add('u');

		PriorityQueue<Character> charHeap = new PriorityQueue<>();

		for (int i = 0; i < s.length(); i++) {
			if (charSet.contains(s.charAt(i)))
				charHeap.add(s.charAt(i));
		}

		StringBuilder a = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (charSet.contains(s.charAt(i))) {
				a.append(charHeap.poll());
			} else {
				a.append(s.charAt(i));
			}
		}
		String originalString = "aode";

		String modifiedString = s.replace('o', 'X');
		System.out.println(modifiedString);

		/*
		 * for(int i=0; i< s.length(); i++){ if (charSet.contains(s.charAt(i))) {
		 * s.charAt(i) = charHeap.poll() ; } }
		 */

		return a.toString();

	}

	public static void main(String[] args) {

		System.out.println(prob2785.sortVowels("lEetcOde"));
		String originalString = "aode";

		String modifiedString = originalString.replace('o', 'X');
		System.out.println(modifiedString);
		// System.out.println(a.countVowelPermutationB(1));
		// System.out.println(a.countVowelPermutationB(2));
		// System.out.println(a.countVowelPermutationB(20));
	}

}
