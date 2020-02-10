import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main (String[] args){
        //Input for Array and 2D Array solutions
        int[] nums = {0, 2, 0, 1, 0};
        int[] digits = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
        int[] digits1 = {9, 9, 9};
        int[][] matrix = { {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int pascalTriangleRows = 10;

        //Input for String solutions
        String firstBinaryNumber = "101000001001001101100100000101011110110110";
        String secondBinaryNumber = "1101010010111011100011111001100010101000";
        String haystack = "hello";
        String needle = "lo";
        String[] words = {"passed","passengerlalalala","pass314"};
        char[] reverseMe = {'g', 'a', 'r', 'd', 'e', 'n', 'i', 'a'};

        int pivot = new ArraySolution().pivotIndex(nums);
        System.out.println("The pivot index for " + Arrays.toString(nums) + " is " + pivot);

        int dominant = new ArraySolution().dominantIndex(nums);
        System.out.println("The dominant index for " + Arrays.toString(nums) + " is " + dominant);

        int[] number = new ArraySolution().plusOne(digits);
        System.out.println("The plus one of " + Arrays.toString(digits) + " is " + Arrays.toString(number));

        int[] number1 = new ArraySolution().plusOne(digits1);
        System.out.println("The plus one of " + Arrays.toString(digits1) + " is " + Arrays.toString(number1));

        System.out.println();
        System.out.println("Matrix");
        ArraySolution.printArray(matrix);
        int[] order = new ArraySolution().findDiagonalOrder(matrix);
        System.out.println("Diagonal (zig-zag) traverse is " + Arrays.toString(order));
        List<Integer> spiralOrder = new ArraySolution().spiralOrder(matrix);
        System.out.println("Spiral traverse is " + spiralOrder);

        System.out.println();
        System.out.println("Number of Pascal's Triangle rows: " + pascalTriangleRows);
        List<List<Integer>> pascalTriangle = new ArraySolution().generate(pascalTriangleRows);
        System.out.println(pascalTriangle);

        System.out.println();
        String binarySum = new StringSolution().addBinary(firstBinaryNumber, secondBinaryNumber);
        System.out.println("Sum of binary numbers: " + firstBinaryNumber + " + " + secondBinaryNumber + " = " + binarySum);

        int subStringIndex = new StringSolution().strStr(haystack, needle);
        System.out.println("In string \"" + haystack + "\" the substring's \"" + needle + "\" index is: " + subStringIndex);

        String longestPrefix = new StringSolution().longestCommonPrefix(words);
        System.out.println(Arrays.toString(words) + " longest common prefix is: " + longestPrefix);
        System.out.println("Before reverse: " + Arrays.toString(reverseMe));
        TwoPointer test = new TwoPointer();
        test.reverseString(reverseMe);
        System.out.println("After reverse: " + Arrays.toString(reverseMe));
    }
}
