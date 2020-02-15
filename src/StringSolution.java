import java.math.BigInteger;
import java.util.Arrays;

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

class TwoPointer {

    /* Write a function that reverses a string. The input string is given as an array of characters char[].
    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
    You may assume all the characters consist of printable ascii characters. */
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }
    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    /* Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
    n is a positive integer, which is in the range of [1, 10000].
    All the integers in the array will be in the range of [-10000, 10000]. */
    public int arrayPairSum(int[] nums) {
        if (nums.length == 2)
            return Math.min(nums[0], nums[1]);

        Arrays.sort(nums);
        int sum = 0;
        int i = 0;
        int j = nums.length - 1;

        //Since we need to use two pointer technique. Start adding min of pairs from the start of array with min of pairs from the end of the array
        while (i < j - 1) {
            sum += Math.min(nums[i], nums[i+1]) + Math.min(nums[j], nums[j-1]);
            i += 2;
            j -= 2;
        }

        //If number of pairs was not 2n, then add the min of last pair
        if (i == j - 1)
            sum += Math.min(nums[i], nums[i+1]);

        return sum;
    }
}