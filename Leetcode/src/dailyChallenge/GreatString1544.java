package LeetCode;

public class GreatString1544 {
	public String makeGood(String s) {
	char[] charArray = s.toCharArray();
	List<Character> charList = new ArrayList<>();
	for(char c:charArray)
	{
		charList.add(c);
	}
	// System.out.println(charList);
	int i = 0;
	int j = 1;
	
	while(j<charList.size())
	{

		if ((int) (Math.abs(charList.get(i) - 32)) == charList.get(j)
				|| (int) (Math.abs(charList.get(i) + 32)) == charList.get(j)) {
			// System.out.println("True");
			charList.remove(j);
			charList.remove(i);
			if (i > 0) {
				i = i - 1;
				j = i + 1;
			}
		} else {
			i++;
			j++;
		}
	}

	StringBuilder sb = new StringBuilder();
	for(
	Character c:charList)
	{
		sb.append(c);
	}return sb.toString();

}
