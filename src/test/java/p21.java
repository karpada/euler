import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class p21 {

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
		long sum = 0;
		for (int i = 1; i < 10000 ; i++) {
			if (i != d(i) && i == d(d(i))) {
				sum += i;
			}
		}
		assertEquals(31626, sum);
	}
}
