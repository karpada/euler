import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class p102 {
	@Test
	public void main() {
        long origin_count = 0;
        for (String l: Utils.fileLines("src/test/resources/0102_triangles.txt")) {
            long[] coords = Arrays.stream(l.split(",")).mapToLong(Long::parseLong).toArray();
            double a = Math.atan2(coords[0], coords[1]);
            double b = Math.atan2(coords[2], coords[3]);
            double c = Math.atan2(coords[4], coords[5]);
            double aa = getAngle(a, b);
            double bb = getAngle(b, c);
            double cc = getAngle(c, a);
            if (  getAngle(a, b) + getAngle(b, c) + getAngle(c, a) >= 2*Math.PI-1e-5 ) {
                origin_count++;
            }
        }
		assertEquals(228, origin_count);
	}

    private static double getAngle(double b, double a) {
        return Math.abs((b - a + 3 * Math.PI) % (2 * Math.PI) - Math.PI);
    }
}
