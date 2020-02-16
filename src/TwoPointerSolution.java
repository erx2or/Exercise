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

    /* Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
    Your returned answers (both index1 and index2) are not zero-based.
    You may assume that each input would have exactly one solution and you may not use the same element twice. */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;

        while (i < numbers.length - 1) {
            if (numbers[i] <= target) {
                int j = numbers.length - 1;
                while (i < j) {
                    if (numbers[i] + numbers[j] == target)
                        return new int[] {i + 1, j + 1};
                    j--;
                }
            }
            i++;
        }

        return new int[] {};
    }

    /* Given an array nums and a value val, remove all instances of that value in-place and return the new length.
    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
    The order of elements can be changed. It doesn't matter what you leave beyond the new length.*/
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    /* Given a binary array, find the maximum number of consecutive 1s in this array.
    The input array will only contain 0 and 1.
    The length of input array is a positive integer and will not exceed 10,000. */
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 1) {
                count++;
                if (i < nums.length - 1)
                    i++;
                else
                    break;
            }
            max = Math.max(count, max);
            count = 0;
        }

        return max;
    }

    /* Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead. */
    public int minSubArrayLen(int s, int[] nums) {
        int sum, tempLength, j;
        int minLength = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            tempLength = 1;
            j = i + 1;
            while (sum < s && j < nums.length) {
                sum += nums[j];
                tempLength++;
                j++;
            }
            if (sum >= s)
                minLength = (minLength == 0) ? tempLength : Math.min(tempLength,minLength);
        }

        return minLength;
    }
}
