import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class p108 {
    @Test
    public void main() {
        long n;
        for (n=180_000; ; n++) {
            long count = 0;
            long nn = n * n;
            for (long z = 1; z <= n; z++) {
                // x is n+z
                // (n + z) * n) % z  === n*n % z
                if (nn % z == 0) {
                    count++;
                }
            }
//            System.out.println(("n= " + n + "   c= " + count));
            if (count > 1000) {
                break;
            }
        }
        assertEquals(180180, n);
    }
}
