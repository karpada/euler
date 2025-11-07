import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class p2 {

	/**
	 * @param args
	 */
	@Test
	public void main() {
		int sum = 0;
		for (int i = 0; Utils.getFibo(i).compareTo(BigInteger.valueOf(4_000_000)) < 0; i++)
			if (!Utils.getFibo(i).testBit(0))
				sum += Utils.getFibo(i).intValue();
		assertEquals(4613732, sum);
	}
}
