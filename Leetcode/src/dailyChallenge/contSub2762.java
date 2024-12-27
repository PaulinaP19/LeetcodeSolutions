package dailyChallenge;

import java.util.TreeMap;

public class contSub2762 {
	public long continuousSubarrays(int[] nums) {
		int start = 0;
		int end = 0;

		long res = 0;

		TreeMap<Integer, Integer> freq = new TreeMap<>();

		while (end < nums.length) {

			freq.put(nums[end], freq.getOrDefault(nums[end], 0) + 1);

			while (freq.lastEntry().getKey() - freq.firstEntry().getKey() > 2) {

				freq.put(nums[start], freq.get(nums[start]) - 1);
				if (freq.get(nums[start]) == 0) {
					freq.remove(nums[start]);
				}
				start++;
			}
			res += end - start + 1;
			end++;
		}

		return res;

	}
}
