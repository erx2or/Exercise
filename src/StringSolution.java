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

    /* Implement strStr(). http://www.cplusplus.com/reference/cstring/strstr/
    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
    For the purpose of this problem, we will return 0 when needle is an empty string.*/
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /* Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".
    All given inputs are in lowercase letters a-z. */
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        String tempPrefix = "";

        if (strs.length == 0)
            return prefix;

        if (strs.length == 1)
            return strs[0];

        String firstString = strs[0];
        for (int i = 0; i < firstString.length(); i++) {
            tempPrefix = tempPrefix.concat(String.valueOf(firstString.charAt(i)));
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(tempPrefix))
                    break;
                if (j == strs.length - 1)
                    prefix = tempPrefix;
            }
        }

        return prefix;
    }
}