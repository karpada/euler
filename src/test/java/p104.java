import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class p104 {
    @Test
    public void main() {
        int i;
        long amod = 1;
        long bmod = 1;

        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;

        for (i = 3; i < 10_000_000; i++) {
            BigInteger c = a.add(b);
            a = b;
            b = c;
            long cmod = (amod + bmod) % 1_000_000_000;
            amod = bmod;
            bmod = cmod;

            if (Utils.isPandigital(Long.toString(cmod), 0b1111111110) == false)
                continue;
            if (Utils.isPandigital(c.toString().substring(0, 9), 0b1111111110)) {
                System.out.println(i);
                break;
            }
        }
        assertEquals(329468, i);
    }
}
