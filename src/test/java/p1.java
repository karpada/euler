import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class p1 {
    @Test
    public void main() {
        int sum = 0;
        for (int i= 0 ; i <1000 ; i++)
            if ((i%3 == 0) || (i%5 == 0))
                sum += i;
        assertEquals(233168, sum);
    }

}
