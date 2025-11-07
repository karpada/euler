import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.valueOf;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;




public class p23 {

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
		Set<Integer> abundants = new HashSet<Integer>();

		for (int i = 12; i < 28123; i++) {
			if (i < d(i)) {
				abundants.add(i);
			}
		}

		long sum = 0;
		for (int i = 1 ; i <= 28123; i++) {
			boolean found = false;
			for (Iterator<Integer> aIter = abundants.iterator(); aIter.hasNext();) {
				Integer a = (Integer) aIter.next();
				if (abundants.contains(i - a)) {
					found = true;
					break;
				}
			}
			if (!found) {
				sum += i;
				//System.out.println(i);
			}
		}
		assertEquals(4179871, sum);
	}

}
