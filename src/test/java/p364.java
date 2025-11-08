import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class p364 {

//    static Map<Integer, Integer> m = new HashMap<Integer, Integer>();
//    static final int edge = 1<<30;
//
//    static int f(int n, int edges) {
//        // handle 1 or 2 vacancies
//        if (n <= 0) return 1;
//        if (n == 1) return 1;
//        if (n == 2) return edges==1 ? 1 : 2;
//
//        if (m.containsKey(edges*edge + n)) return m.get(edges*edge + n);
//
//        // 3+ vacancies in a row
//        int sum = 0;
//        for (int i = (edges > 0 ? 0 : 1) ; i < (n - (edges > 1 ? 0 : 1) ) ; i++) {
//            sum += f(i-1, edges > 0 ? 1 : 0) * f(n-i-1, edges > 1 ? 1 : 0);
//        }
//
//        System.out.println("f(" + n + ", " + edges + ") = " + sum);
//        m.put(edges*edge + n, sum);
//        return sum;
//    }
//    @Test
//    public void main() {
//        System.out.println(Utils.isPrime(Utils.mod));
//        for (int n = 0 ; n<100 ; n++)
//            System.out.println(Utils.modFactorial(n));
//
//        System.out.println(f(4,2));
//
//        assertEquals(-59231, 1);
//    }
}
