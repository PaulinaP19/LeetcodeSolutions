package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class StringCompressionII1531 {
	public static int getLengthOfOptimalCompression(String s, int k) {
		if (s.length() == 1 && k > 0) {
			return 0;
		} else if (s.length() == 1 && k == 0) {
			return 1;
		}

		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);

		LinkedList<Integer> sameL = new LinkedList<Integer>();

		int same = 1;
		int i = 0;
		StringBuilder compact = new StringBuilder();

		while (i < s.length()) {
			compact.append(charArray[i]);
			while (i < charArray.length - 1 && charArray[i + 1] == charArray[i]) {
				same += 1;
				i++;
			}

			if (same > 1) {
				compact.append(same);
				sameL.add(same);
			} else {
				sameL.add(same);
			}
			i++;
			same = 1;

		}
		System.out.println(Arrays.toString(charArray));
		int len = compact.toString().length();
		if (k == 0) {
			return len;
		}
		System.out.println(compact);

		Collections.sort(sameL);
		System.out.println(Arrays.toString(sameL.toArray()));

		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(minString(sameL, len, k));

		return len;
	}

	public static int minString(LinkedList<Integer> list, Integer len, Integer k) {
	    if (len == 0 || k == 0) {
	        return len;
	    }
	    int l = 0;
	    int r =0;
	    for (int i = 0; i < list.size(); i++) {
	        if (k - list.get(i) >= 0) {
	            if (list.get(i) == 1) {
	                l = 1;
	             
	            }
	            else if (list.get(i) >1 && list.get(i) <10) {
	            	l = 2;
	            	
	            }
	            else if (list.get(i) >10 && list.get(i) <100) {
	            	l = 3;
	            }
	            r = list.get(i);
	          else {
	        	  if (list.get(i) <10 
	        			  {-k ==1) {
	        		  l = 1;
	        		  r = list.get(i) -k; 
	        		  
	        	  }
	        	  
	        	  
	        	  
	        	  
	          }
	        }
	    }
	    // Adjust the return statement based on your logic
	    return l;
	}

	public static void main(String[] args) {
		StringCompressionII1531.getLengthOfOptimalCompression("aaaabbbbbssssssss", 4);
		StringCompressionII1531.getLengthOfOptimalCompression("abcd", 4);
		StringCompressionII1531.getLengthOfOptimalCompression("a", 1);
		StringCompressionII1531.getLengthOfOptimalCompression("abcddd", 4);

	}

}
