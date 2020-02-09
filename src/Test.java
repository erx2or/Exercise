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
        String firstBinaryNumber = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String secondBinaryNumber = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";

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
    }
}
