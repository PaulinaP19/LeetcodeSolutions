package dailyChallenge;

public class bestSightseeing1014 {
	public int maxScoreSightseeingPair(int[] values) {
		int maxScore = 0;

		for (int i = 0; i < values.length; i++) {
			for (int j = i + 1; j < values.length && j < i + 1000; j++) {
				int curSum = values[i] + values[j] + i - j;
				if (curSum > maxScore) {
					maxScore = curSum;
				}

			}

		}
		return maxScore;
	}

}
