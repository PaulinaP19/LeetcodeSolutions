package LeetCode;

import java.util.Collections;
import java.util.PriorityQueue;

public class presents {

	public long pickGifts(int[] gifts, int k) {
		long tot = 0;

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < gifts.length; i++) {
			maxHeap.add(gifts[i]);
		}
		while (k > 0) {
			maxHeap.add((int) Math.sqrt(maxHeap.poll()));
			k--;
		}

		while (!maxHeap.isEmpty()) {

			int Value = maxHeap.poll();
			System.out.println(Value);

			tot += Value;

		}

		return tot;
	}

	public long pickGifts2(int[] gifts, int k) {

		long tot = 0;

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < gifts.length; i++) {
			// System.out.println(gifts[i]);
			maxHeap.add(gifts[i]);
		}

		while (k > 0) {
			int Value = maxHeap.poll();
			// System.out.println(Value);
			int V2 = (int) Math.sqrt(Value);
			// System.out.println(V2);
			maxHeap.add(V2);
			k--;
		}

		while (!maxHeap.isEmpty()) {

			int Value = maxHeap.poll();
			// System.out.println(Value);
			tot += Value;

		}

		return tot;
	}

}
