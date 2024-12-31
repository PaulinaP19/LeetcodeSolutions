package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PathCrossing1496 {
	public static boolean isPathCrossing(String path) {

		HashSet<List<Integer>> pathH = new HashSet<>();
		pathH.add(Arrays.asList(0, 0));
		int zeile = 0;
		int spalte = 0;
		for (int i = 0; i < path.length(); i++) {
			if (path.charAt(i) == 'N') {
				zeile += 1;
			} else if (path.charAt(i) == 'S') {
				zeile -= 1;
			} else if (path.charAt(i) == 'E') {
				spalte += 1;
			} else {
				spalte -= 1;
			}
			if (pathH.contains(Arrays.asList(spalte, zeile)))
				return true;
			else
				pathH.add(Arrays.asList(spalte, zeile));

		}

		return false;
	}

}
