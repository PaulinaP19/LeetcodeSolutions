package LeetCode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class sortStudents {

	public static void main(String[] args) {
	        List<YourObject> score = /* Your list of objects */;
	        int k = 2/* Your key index */;
	        
	        Collections.sort(score, Comparator.comparing(obj -> obj.getK()).reversed());
	    }
}

class YourObject {
	private int k;

	// constructor, getters, setters, etc.

	public int getK() {
		return k;
	}
}

}
