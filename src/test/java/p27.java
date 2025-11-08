import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class p27 {

    @Test
    public void main() {
        int bestN = -1;
        int bestA = -1;
        int bestBIndex = -1;

        for (int bIndex = 12 ; Utils.getPrime(bIndex) < 1000 ; bIndex++) {
            final int b = (int)Utils.getPrime(bIndex);
            for (int a = -999 ; a <= 999 ; a++) {
                for (int n = 0 ; Utils.isPrime(n*n+a*n+b) ; n++) {
                    if (bestN < n) {
                        bestN = n;
                        bestA = a;
                        bestBIndex = bIndex;
                    }
                }
            }
        }
        assertEquals(-59231, bestA*Utils.getPrime(bestBIndex));
    }
}
