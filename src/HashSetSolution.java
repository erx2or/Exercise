import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetSolution {
    /* Given an array of integers, find if the array contains any duplicates.
    Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct. */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int value : nums) {
            if (hashSet.contains(value))
                return true;
            hashSet.add(value);
        }
        return false;
    }

    /* Given a non-empty array of integers, every element appears twice except for one. Find that single one.
    Note:
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? */
    public int singleNumber(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int value : nums) {
            if (hashSet.contains(value))
                hashSet.remove(value);
            else
                hashSet.add(value);
        }
        return hashSet.iterator().next();
    }

    /* Given two arrays, write a function to compute their intersection.
    Each element in the result must be unique.
    The result can be in any order. */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i : nums1) {
                for (int j : nums2) {
                    if (i == j) {
                        hashSet.add(i);
                        break;
                    }
                }
        }
        return hashSet.stream().mapToInt(Number::intValue).toArray();
    }

    /* Write an algorithm to determine if a number is "happy".
    A happy number is a number defined by the following process:
    Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process
    until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those
    numbers for which this process ends in 1 are happy numbers.*/
    public boolean isHappy(int n) {
        Set<Integer> squareResult = new HashSet<>();
        int[] digits;
        while (n != 1) {
            squareResult.add(n);
            digits = toArray(n);
            n = squareSum(digits);
            //This means we're gonna loop!
            if (squareResult.contains(n))
                break;
        }

        if (n == 1)
            return true;
        return false;
    }

    public int[] toArray(int n) {
        return Integer.toString(n).chars().map(c -> c-'0').toArray();
    }

    public int squareSum(int[] n) {
        return Arrays.stream(n).map(d -> d*d).sum();
    }

}
