package LeetCode;

import java.util.HashSet;

public class uncommonWords884 {
	public String[] uncommonFromSentences(String s1, String s2) {
		String[] sent1 = s1.split(" ");
		String[] sent2 = s2.split(" ");

		HashSet<String> oneTime = new HashSet<String>();
		HashSet<String> seen = new HashSet<String>();

		for (String word : sent1) {
			if (seen.contains(word)) {
				continue;
			}
			if (oneTime.contains(word)) {
				oneTime.remove(word);
				seen.add(word);
				continue;
			}
			oneTime.add(word);

		}

		for (String word : sent2) {
			if (seen.contains(word)) {
				continue;
			}
			if (oneTime.contains(word)) {
				oneTime.remove(word);
				seen.add(word);
				continue;
			}
			oneTime.add(word);
		}

		String[] unique = new String[oneTime.size()];

		return oneTime.toArray(unique);
	}

}
