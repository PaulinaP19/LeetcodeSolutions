package LeetCode;

public class sortThePeople2418 {
	public String[] sortPeople(String[] names, int[] heights) {
		for (int i = 0; i < names.length; i++) {
			int max = heights[i];
			int ind = i;
			int j = i;
			for (; j < names.length; j++) {
				if (heights[j] > max) {
					max = heights[j];
					ind = j;
				}
			}
			// System.out.println(max + " " + ind);
			if (ind != i) {
				String name = names[ind];
				names[ind] = names[i];
				names[i] = name;
				int hig = heights[ind];
				heights[ind] = heights[i];
				heights[i] = hig;

			}

		}

		return names;
	}

}
