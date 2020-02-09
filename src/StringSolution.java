import java.math.BigInteger;

public class StringSolution {

    /* Given two binary strings, return their sum (also a binary string).
    The input strings are both non-empty and contains only characters 1 or 0.*/
    public String addBinary(String a, String b) {
        BigInteger firstDecimal = new BigInteger(a, 2);
        BigInteger secondDecimal = new BigInteger(b, 2);

        BigInteger decimalSum = firstDecimal.add(secondDecimal);

        return decimalSum.toString(2);
    }
}
