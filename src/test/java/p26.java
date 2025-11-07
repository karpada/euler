import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class p26 {

	static long d(long n) {
		if (n <= 1) {
			return 0;
		}
		List<Long> dividers = Utils.dividers(n);
		long sum = -n;
		for (Long divider : dividers) {
			sum += divider;
		}
		return sum;
	}

	@Test
	public void main() {
		int longestLoop = 0;
		int longestLoopD = 0;
		for (Integer d = 1 ; d <= 1000 ; d++) {
			Map<Integer, Integer> reminders = new HashMap<Integer, Integer>();
			for(Integer reminder = 1 ; reminder != 0 ; ) {
				while (reminder < d) {
					reminder *= 10;
				}
				if (reminders.containsKey(reminder)) {
//					System.out.println(d + " " + (reminders.size() - reminders.get(reminder)));
					if (longestLoop < reminders.size() - reminders.get(reminder)) {
						longestLoop = reminders.size() - reminders.get(reminder);
						longestLoopD = d;
					}
					longestLoop = Math.max(longestLoop, reminders.size() - reminders.get(reminder));
					break;
				}
				reminders.put(reminder, reminders.size());
				reminder %= d;
				//System.out.println(reminder);
			}
		}
		assertEquals(983, longestLoopD);
	}
}
