package LeetCode;

public class Garbage {

	public static int garbageCollection(String[] garbage, int[] travel) {
		boolean Mt = false;
		boolean Pt = false;
		boolean Gt = false;
		int t = 0;
		for (int i = garbage.length - 1; i >= 0; i--) {
			t += garbage[i].length();
			if (Mt == false || Pt == false || Gt == false) {
				for (int j = 0; j < garbage[i].length(); j++) {

					if (Mt == false && garbage[i].charAt(j) == 'M') {
						Mt = true;
						for (int l = 0; l < i; l++)
							t += travel[l];
					}
					if (Gt == false && garbage[i].charAt(j) == 'G') {
						Gt = true;
						for (int l = 0; l < i; l++)
							t += travel[l];
					}
					if (Pt == false && garbage[i].charAt(j) == 'P') {
						Pt = true;
						for (int l = 0; l < i; l++)
							t += travel[l];
					}

				}
			}

		}

		return t;
	}

}
