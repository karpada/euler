import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class p12 {

	@Test
	public void main() {
		for (long i = 0 ; 1 < 100000 ; i++) {
			final long n = (i * (i+1))/2;
			int dividerCount = 1;
			for (int power : Utils.factor(n).values()) {
				dividerCount *= (power+1);
			}
			if (dividerCount >= 500) {
				assertEquals(76576500, n);
				break;
			}
		}
	}
}
