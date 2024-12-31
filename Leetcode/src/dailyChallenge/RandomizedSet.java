package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

	private LinkedList<Integer> linkedList;
	private Map<Integer, Integer> map;

	public RandomizedSet() {
		linkedList = new LinkedList<>();
		map = new HashMap<>();

	}

	public boolean insert(int val) {
		if (!(map.containsKey(val))) {
			linkedList.add(val);
			map.put(val, linkedList.size() - 1);
			// System.out.println(linkedList);
			return true;
		}
		return false;

	}

	public boolean remove(int val) {
		if (map.containsKey(val)) {
			// int ind = map.get(val);
			linkedList.remove(Integer.valueOf(val));
			map.remove(val);
			// System.out.println(linkedList);
			return true;
		}
		return false;

	}

	public int getRandom() {
		Random rand = new Random();
		// System.out.println(linkedList);
		return linkedList.get(rand.nextInt(linkedList.size()));

	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */
public class RandomizedSet2 extends RandomizedSet //LESS MEMORY LONGER RUNTIME {

	private LinkedList<Integer> linkedList;

	public RandomizedSet2() {
		linkedList = new LinkedList<>();

	}

	@Override
	public boolean insert(int val) {
		if (!(linkedList.contains(val))) {
			linkedList.add(val);

			// System.out.println(linkedList);
			return true;
		}
		return false;

	}

	@Override
	public boolean remove(int val) {
		if (linkedList.contains(val)) {
			// int ind = map.get(val);
			linkedList.remove(Integer.valueOf(val));

			// System.out.println(linkedList);
			return true;
		}
		return false;

	}

	@Override
	public int getRandom() {
		Random rand = new Random();
		// System.out.println(linkedList);
		return linkedList.get(rand.nextInt(linkedList.size()));

	}
}
