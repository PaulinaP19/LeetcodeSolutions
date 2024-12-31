package LeetCode;

import java.util.HashMap;
import java.util.List;

public class FoodRatings2353 {
	public FoodRatings2353(String[] foods, String[] cuisines, int[] ratings) {
		HashMap<String, Cuisine> cuisine = new HashMap<String, Cuisine>();
		for (int i = 0; i < foods.length; i++) {
			if (!cuisine.containsKey(cuisines[i]))
				cuisine.put(cuisines[i], new Cuisine());
			// cuisine.get(cuisines[i]).add(foods[i], ratings[i]);
		}
	}

	public void changeRating(String food, int newRating) {

	}

	public String highestRated(String cuisine) {
		return "";
	}
}

class Cuisine {
	String best;
	List foods;
	List ratings;

}