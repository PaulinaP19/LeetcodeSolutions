package LeetCode;

public class WaterBottle1518 {
	public int numWaterBottles(int numBottles, int numExchange) {
		int n = 0;
		while (numBottles / numExchange > 0) {
			n += numBottles / numExchange;
			numBottles = numBottles % numExchange + numBottles / numExchange;
		}
		return n;
	}

}
