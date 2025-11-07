import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class p25 {

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
		List<BigInteger> fibo = new ArrayList<BigInteger>();
		fibo.add(new BigInteger("0"));
		fibo.add(new BigInteger("1"));

		while (fibo.get(fibo.size()-1).toString().length() < 1000) {
			fibo.add(fibo.get(fibo.size()-2).add(fibo.get(fibo.size()-1)));
		}
		assertEquals(4782, fibo.size()-1);
	}


}
