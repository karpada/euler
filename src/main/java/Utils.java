import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import static java.lang.Long.valueOf;


public class Utils {
    public final static int mod = 100000007;
    final static List<Integer> modFactorial;

    static List<Long> primeList;
    static Set<Long> primeSet;
    static List<BigInteger> fiboList;
    static {
        modFactorial = new ArrayList<Integer>();
        modFactorial.add(1);
        primeList = new ArrayList<Long>();
        primeList.add(2L);
        primeSet = new HashSet<Long>();
        primeSet.add(2L);
        fiboList = new ArrayList<BigInteger>();
        fiboList.add(BigInteger.ZERO);
        fiboList.add(BigInteger.ONE);
    }

    public static long getPrime(final int index) {
        return getPrimes(index).get(index);
    }

    public static int getPrimeIndex(final long value) {
        if (!isPrime(value)) {
            return -1;
        }
        return primeList.indexOf(value);
    }

    public static List<Long> getPrimes(final int count) {
        for (long n = primeList.get(primeList.size()-1) + 1 ; primeList.size() <= count ; n++ ) {
            for (int dIndex = 0 ; n % primeList.get(dIndex) != 0 ; dIndex++) {
                if (primeList.get(dIndex)*primeList.get(dIndex) > n) {
                    primeList.add(n);
                    primeSet.add(n);
                    break;
                }
            }
        }
        return primeList;
    }

    public static boolean isPrime(final long p) {
        for (long n = primeList.get(primeList.size()-1) + 1 ; primeList.get(primeList.size()-1) <= p ; n++ ) {
            for (int dIndex = 0 ; n % primeList.get(dIndex) != 0 ; dIndex++) {
                if (primeList.get(dIndex)*primeList.get(dIndex) > n) {
                    primeList.add(n);
                    primeSet.add(n);
                    break;
                }
            }
        }
        return primeSet.contains(p);
    }

    public static Map<Long, Integer> factor(long n) {
        Map<Long, Integer> factors = new HashMap<Long, Integer>();
        int i = 0;
        while (getPrime(i) <= (long) Math.sqrt(n)) {
            if (n % getPrime(i) != 0) {
                i++;
                continue;
            }
            factors.put(getPrime(i), factors.get(getPrime(i)) == null ? 1 : factors.get(getPrime(i)) + 1);
            n /= getPrime(i);
        }
        if (n != 1) {
            factors.put(n, factors.get(n) == null ? 1 : factors.get(n) + 1);
        }
        return factors;
    }

    public static List<Long> dividers(long n) {
        Map<Long, Integer> factors = factor(n);
        ArrayList<Long> result = new ArrayList<Long>();
        result.add(1L);

        for (Entry<Long, Integer> factor : factors.entrySet()) {
            final int origResultSize = result.size();
            for (long pow = 1 ; pow <= factor.getValue() ; pow++) {
                final int basePosition = result.size()-origResultSize;
                for (int i = 0 ; i < origResultSize ; i++) {
                    result.add(result.get(basePosition+i) * factor.getKey());
                }
            }
        }

        return result;
    }

    public static List<String> fileLines(final String fileName) {
        List<String> result = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            for (String strLine = in.readLine() ;  strLine != null ; strLine = in.readLine()) {
                result.add(strLine);
            }
            in.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public static int modFactorial(int n) {

        for (int i = modFactorial.size() ; i <= n ; i++) {
            modFactorial.add((int)((i*(long)modFactorial.get(i-1) % mod)));
        }
        return modFactorial.get(n);
    }

    public static int modBinom(int n, int k) {
        //        ((long)modFactorial(n)*mod)/
        for (int i = modFactorial.size() ; i <= n ; i++) {
            modFactorial.add((int)((i*(long)modFactorial.get(i-1) % mod)));
        }
        return modFactorial.get(n);
    }

    public static BigInteger getFibo(int n) {
        // F1 = 1, F2 = 1
        for (int i = fiboList.size() ; i <= n ; i++) {
            fiboList.add(fiboList.get(i-1).add(fiboList.get(i-2)));
        }
        return fiboList.get(n);
    }

    public static ArrayList<Integer> getDigits(int x) {
        ArrayList<Integer> digits = new ArrayList<>();
        while (x > 0) {
            digits.add(x % 10);
            x /= 10;
        }
        return digits;
    }

}
