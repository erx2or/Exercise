import java.util.Arrays;

public class TwoPointerSolution {

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
