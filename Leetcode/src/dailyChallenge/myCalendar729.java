package LeetCode;

import java.util.LinkedList;

public class myCalendar729 {

	private LinkedList<LinkedList<Integer>> calendar;

	myCalendar729() {

		calendar = new LinkedList<LinkedList<Integer>>();
		LinkedList<Integer> newEvent = new LinkedList<>(); // Create a new LinkedList for the event
		newEvent.add(Integer.MAX_VALUE); // Add the start time
		newEvent.add(Integer.MAX_VALUE); // Add the end time
		calendar.add(newEvent);

	}

	public boolean book(int start, int end) {
		LinkedList<Integer> newEvent = new LinkedList<>(); // Create a new LinkedList for the event
		newEvent.add(start); // Add the start time
		newEvent.add(end); // Add the end time

		if (start >= calendar.get(calendar.size() - 1).get(0)) {
			calendar.add(newEvent);
			return true;
		}

		if (end <= calendar.get(0).get(0)) {
			calendar.add(0, newEvent);
			return true;
		}

		for (int i = 0; i < calendar.size() - 1; i++) {

			if (start >= calendar.get(i).get(1) && end <= calendar.get(i + 1).get(0)) {
				calendar.add(i + 1, newEvent);
				return true;
			}
		}

		return false;
	}

	/**
	 * Your MyCalendar object will be instantiated and called as such: MyCalendar
	 * obj = new MyCalendar(); boolean param_1 = obj.book(start,end);
	 */

}
