import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class p13 {

	@Test
	public void main() {
		List<String> lines = Utils.fileLines("src/test/resources/in13.txt");
		BigInteger sum = new BigInteger("0");
		for (String line : lines) {
			sum = sum.add(new BigInteger(line));
		}
		assertEquals("5537376230390876637302048746832985971773659831892672", sum.toString());
	}
}
