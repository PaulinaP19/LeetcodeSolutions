package LeetCode;

public class TicketTime2073 {
	public int timeRequiredToBuy(int[] tickets, int k) {
		int maxT = tickets[k];
		int ans = 0;
		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i] >= maxT && i <= k)
				ans += maxT;
			else if (tickets[i] >= maxT && i > k)
				ans += maxT - 1;

			else {
				ans += tickets[i];
			}

		}
		return ans;
	}

}
