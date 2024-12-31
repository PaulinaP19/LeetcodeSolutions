package LeetCode;

import java.util.HashSet;
import java.util.List;

public class destinationCity1436 {
	public String destCity(List<List<String>> paths) {
		HashSet<String> start = new HashSet<String>();
		for (int i = 0; i < paths.size(); i++) {
			start.add(paths.get(i).get(0));
		}
		int i = 0;
		for (; i < paths.size(); i++) {
			if (!(start.contains(paths.get(i).get(1))))
				break;
		}

		return paths.get(i).get(1);
	}

}
