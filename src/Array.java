import java.util.Arrays;

public class Array {
    public static void main (String[] args){
        int[] nums = {0, 2, 0, 1, 0};
        int[] digits = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
        int[] digits1 = {9, 9, 9};
        int[][] matrix = { { 1, 2, 3, 4}, { 5, 6, 7, 8}, {9, 0, 1, 2}};

        int pivot = new Solution().pivotIndex(nums);
        System.out.println("The pivot index for " + Arrays.toString(nums) + " is " + pivot);

        int dominant = new Solution().dominantIndex(nums);
        System.out.println("The dominant index for " + Arrays.toString(nums) + " is " + dominant);

        int[] number = new Solution().plusOne(digits);
        System.out.println("The plus one of " + Arrays.toString(digits) + " is " + Arrays.toString(number));

        int[] number1 = new Solution().plusOne(digits1);
        System.out.println("The plus one of " + Arrays.toString(digits1) + " is " + Arrays.toString(number1));

        System.out.println();
        System.out.println("Matrix");
        Solution.printArray(matrix);
        int[] order = new Solution().findDiagonalOrder(matrix);
        System.out.println("Diagonal (zig-zag) traverse is " + Arrays.toString(order));
    }
}
