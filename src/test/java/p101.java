import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class p101 {
    private static long evalPoly(long x) {
        double[] n3 = new double[]{0, 0, 0, 1};
        double[] p101 = new double[]{1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1};
        return (long) Math.round((new PolynomialFunction(p101)).value(x));
    }

    @Test
    public void main() {
        long fit_sum = 1; // PolynomialFunctionLagrangeForm does not support degree 0. f(x)=1. therefore we add f(2) which is 1.
        for (int i = 2; i < 11; i++) {
            double[] x = new double[i];
            double[] y = new double[i];
            for (int j = 0; j < i; j++) {
                x[j] = j + 1;
                y[j] = evalPoly(j + 1);
            }
            PolynomialFunctionLagrangeForm op = new PolynomialFunctionLagrangeForm(x, y);

            long nominal = (long) Math.round(evalPoly(i+1));
            long fit = (long) Math.round(op.value(i+1));
             System.out.println("Degree" + (i-1) + "@" + (i+1) + "  fit=" + fit + "  nomi=" + nominal + "  coeffs:" + Arrays.toString(op.getCoefficients()));
            if (nominal != fit) {
                fit_sum += fit;
            }
        }
        assertEquals(37076114526L, fit_sum);
    }
}
