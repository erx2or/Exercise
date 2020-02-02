import java.math.BigInteger;

class Solution {
    public int pivotIndex(int[] nums) {
        //If pivot not found must return its index as -1
        int pivotIndex = -1;
        int leftSum = 0;
        int rightSum;

        for (int i = 0; i < nums.length; i++) {
            //If index is 0 then leftSum is 0 (nonexistent). Otherwise add previous element to leftSum
            if (i != 0)
                leftSum = leftSum + nums[i-1];
            //Reset rightSum and calculate it again starting from next element
            rightSum = 0;
            int j = i + 1;
            while (j < nums.length) {
                rightSum = rightSum + nums[j];
                j++;
            }
            //If leftSum equals rightSum we found our first pivot, end loop
            if (leftSum == rightSum) {
                pivotIndex = i;
                break;
            }
        }

        return pivotIndex;
    }

    public int dominantIndex(int[] nums) {
        //If dominant not found must return its index as -1
        int dominantIndex = -1;
        int max = -1;

        for (int i = 0; i < nums.length; i++) {
            //Find the new max value, ignoring 0 value elements
            if (max < nums[i] && nums[i] != 0) {
                max = nums[i];
                dominantIndex = i;
                //Compare other array elements with current max
                int j = 0;
                while (j < nums.length) {
                    //If element is larger more than twice end comparison, max doesn't suit us
                    if (j != dominantIndex && nums[j]*2 > max) {
                        dominantIndex = -1;
                        break;
                    }
                    j++;
                }
            }
        }
        return dominantIndex;
    }

    //Given a non-empty array of digits representing a non-negative integer. Add plus one.
    public int[] plusOne(int[] digits) {
        //Create a string from int array
        StringBuilder s = new StringBuilder();
        for (int i : digits) {
            s.append(i);
        }
        //Convert String to BigInteger and add one, because Leetcode tests use huge arrays
        BigInteger number = new BigInteger(s.toString());
        BigInteger one = new BigInteger("1");
        number = number.add(one);
        //Convert BigInteger back to String and create String array dropping the first empty element
        String[] numberString = (String.valueOf(number)).split("(?!^)");
        //Create int array from String array
        int[] plusOne = new int[numberString.length];
        for (int i = 0; i < numberString.length; i++) {
            plusOne [i] = Integer.parseInt(numberString[i]);
        }

        return plusOne;
    }
}