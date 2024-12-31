package LeetCode;

public class LemonadeChange860 {
	public boolean lemonadeChange(int[] bills) {
		int five = 0;
		int ten = 0;
		int res;
		for (int i = 0; i < bills.length; i++) {
			res = bills[i] - 5;
			if (bills[i] == 5)
				five++;
			else if (bills[i] == 10) {
				ten++;
				if (five > 0)
					five--;

				else
					return false;
			} else {
				if (ten > 0 && five > 0) {
					ten--;
					five--;
				} else if (five > 2)
					five -= 3;
				else
					return false;

			}

		}
		return true;
	}

}
