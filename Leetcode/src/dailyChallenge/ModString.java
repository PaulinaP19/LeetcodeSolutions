package LeetCode;

public class ModString {
	public static String modifS(String s) {
		return modifS(s, "");
	}

	public static String modifS(String s, String newS) {
		if (s.equals(newS)) {
			return newS;
		}
		newS = "";
		int i = 0;
		int j = 0;
		while (j < s.length()) {
			while (j < s.length() && s.charAt(i) == s.charAt(j)) {
				j++;
			}
			int c = (s.charAt(i) - '0') * (j - i);
			// System.out.println(c);

			newS += c;
			// System.out.println(" " + newS);
			i = j;

		}

		return modifS(newS, s);
	}

	public static void main(String[] args) {

		System.out.println(ModString.modifS("1223889"));
		System.out.println(ModString.modifS("19938832066"));

	}

}
