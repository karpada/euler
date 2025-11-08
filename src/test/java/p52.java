import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class p52 {
    @Test
    public void main() {
        int found = 0;

        for (int x=100_000; x<200_000; x++) {
            ArrayList<Integer> digits = Utils.getDigits(x);
            if (digits.stream().reduce(0, (a, b) -> a + b) % 3 != 0) {
                        continue;
            }
            if (!digits.contains(0) && !digits.contains(5)) {
                continue;
            }
            Collections.sort(digits);
            for (int m = 2; m <= 6; m++) {
                ArrayList<Integer> candidateDigits = Utils.getDigits(m * x);
                Collections.sort(candidateDigits);
                if (!candidateDigits.equals(digits)) {
                    break;
                }
                if (m == 6) {
                    System.out.println("Found: 1x= " + x + " 2x= " + (2 * x) + " 3x= " + (3 * x) + " 4x= " + (4 * x) + " 5x= " + (5 * x) + " 6x= " + (6 * x));
                    assertEquals(142857, x);
                    found = x;
                }
            }
        }
        assertNotEquals (0, found);
    }
}
