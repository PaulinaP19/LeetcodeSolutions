package LeetCode;

public class DecodeWays91 {
	public static int numDecodings(String s) {
		int ways = 1;
		int oldWays = 1;
		int newWays = 1;
		if (s.charAt(s.length() - 1) == '0') {
			ways = 0;
		}
		for (int i = s.length() - 2; i >= 0; i--) {

			if (s.charAt(i) == '0') {
				newWays = 0;
			} else if ((s.charAt(i) == '1') || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
				newWays = ways + oldWays;
			} else
				newWays = ways;
			oldWays = ways;
			ways = newWays;
		}
		return ways;

	}
}

/*
 * public int numDecodings2(String s) { long ways =1; long newWays= 1; long
 * oldWays; if (s.charAt(0) == '0'){ ways=0; } else if (s.charAt(0) == '*'){
 * ways=9; } for (int i = 1; i <s.length(); i++) {
 * 
 * if (s.charAt(i) == '0') { newWays = 0; } else if ((s.charAt(i) == '1') ||
 * (s.charAt(i) == '2' && s.charAt(i + 1) < '7')) { newWays = ways + oldWays; }
 * else if (s.charAt(i) == '*' && s.charAt(i + 1) < '7'){ newWays = ways + }
 * 
 * }else if(s.charAt(i) == '*' && s.charAt(i + 1) > '6') { newWays = ways *9;
 * else if(s.charAt(i) == '*' && s.charAt(i + 1) == '*') { newWays = ways *+ } }
 * else newWays = ways; oldWays = ways; ways = newWays; }
 * 
 * return ways;
 * 
 * }
 */
