import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class ArraySolution {
    /* Given an array of integers nums, write a method that returns the "pivot" index of this array.
    If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.*/
    public int pivotIndex(int[] nums) {
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

    /* Find whether the largest element in the array is at least twice as much as every other number in the array.
    If it is, return the index of the largest element, otherwise return -1.*/
    public int dominantIndex(int[] nums) {
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

    /* Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
    The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
    You may assume the integer does not contain any leading zero, except the number 0 itself.*/
    public int[] plusOne(int[] digits) {
        //Create a string from int array
        StringBuilder s = new StringBuilder();
        for (int i : digits) {
            s.append(i);
        }
        //Convert String to BigInteger and add one, because LeetCode tests use huge arrays
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

    //Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
    public int[] findDiagonalOrder(int[][] matrix) {
        int elementCount = 0;
        for (int[] i : matrix) {
            elementCount = elementCount + i.length;
        }
        int[] order = new int[elementCount];
        int k = 0;
        int i = 0, j = 0;
        String move = "first";

        while (k < order.length) {
            switch (move){
                //first element is always [0][0]
                case "first":
                    order[k] = matrix[i][j];
                    //if there are columns on the right, shift one column right
                    if (j < matrix[i].length - 1) {
                        move = "oneColumnRight";
                    }
                    //if there are rows beneath, shift one row down
                    else if (i < matrix.length - 1) {
                        move = "oneRowDown";
                    }
                    break;

                case "oneColumnRight":
                    j++;
                    order[k] = matrix[i][j];
                    //if we're at the top and there are rows below, go diagonally down
                    if (i == 0 && i < matrix.length - 1) {
                        move = "diagonalDown";
                    }
                    //if this is a single row matrix
                    else if (i == 0 && i == matrix.length - 1) {
                        move = "oneColumnRight";
                    }
                    //if we're at the bottom, go diagonally up
                    else if (i == matrix.length - 1) {
                        move = "diagonalUp";
                    }
                    break;

                case "oneRowDown":
                    i++;
                    order[k] = matrix[i][j];
                    //if we're at the most left column and there are columns on the right, go diagonally up
                    if (j == 0 && j < matrix[i].length - 1) {
                        move = "diagonalUp";
                    }
                    //if this is a single column matrix
                    else if (j == 0 && j == matrix[i].length - 1) {
                        move = "oneRowDown";
                    }
                    //if we're at the most right column, go diagonally down
                    else if (j == matrix[i].length - 1){
                        move = "diagonalDown";
                    }
                    break;

                case "diagonalDown":
                    i++;
                    j--;
                    order[k] = matrix[i][j];
                    //if we're at the most left column but there are still rows beneath, shift one row down
                    if (j == 0 && i < matrix.length - 1) {
                        move = "oneRowDown";
                    }
                    //if we're at the bottom row but there are still columns on the right, shift one column right
                    else if (i == matrix.length - 1 && j < matrix[i].length - 1) {
                        move = "oneColumnRight";
                    }
                    break;

                case "diagonalUp":
                    i--;
                    j++;
                    order[k] = matrix[i][j];
                    //if we're at the top row but there are still columns on the right, shift one column right
                    if (i == 0 && j < matrix[i].length - 1) {
                        move = "oneColumnRight";
                    }
                    //if we're at the most right column but there are still rows beneath, shift one row down
                    else if (j == matrix[i].length - 1 && i < matrix.length - 1) {
                        move = "oneRowDown";
                    }
                    break;
            }

            k++;

        }
        return order;
    }

    //Print two-dimensional array as matrix
    public static void printArray(int[][] matrix) {
        for (int[] i : matrix) {
            for (int j = 0; i != null && j < i.length; ++j) {
                if (i[j] < 10)
                    System.out.print(i[j] + "  ");
                else
                    System.out.print(i[j] + " ");
            }
            System.out.println();
        }
    }

    //Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
    public List<Integer> spiralOrder(int[][] matrix) {
        int elementCount = 0;
        for (int[] i : matrix) {
            elementCount = elementCount + i.length;
        }

        List<Integer> spiralOrder = new ArrayList<>(elementCount);
        int spiral = 0;
        int i, j;
        String move = "right";

        while (elementCount > 0) {
            switch (move){

                case "right":
                    //Go one row from left to right adding all elements that haven't been added yet
                    for (j = spiral; j < matrix[0].length - spiral; j++) {
                        spiralOrder.add(matrix[spiral][j]);
                        elementCount--;
                    }
                    move = "down";
                    break;

                case "down":
                    //Go one column from top to bottom adding all elements that haven't been added yet
                    for (i = 1 + spiral; i < matrix.length - spiral; i++) {
                        spiralOrder.add(matrix[i][matrix[0].length - 1 - spiral]);
                        elementCount--;
                    }
                    move = "left";
                    break;

                case "left":
                    //Go one row from right to left adding all elements that haven't been added yet
                    for (j = spiral; j < matrix[0].length - 1- spiral; j++) {
                        spiralOrder.add(matrix[matrix.length - 1 - spiral][matrix[0].length - 2 - j]);
                        elementCount--;
                    }
                    move = "up";
                    break;

                case "up":
                    //Go one column from bottom to top adding all elements that haven't been added yet
                    for (i = matrix.length - 2 - spiral; i > spiral; i--) {
                        spiralOrder.add(matrix[i][spiral]);
                        elementCount--;
                    }
                    move = "right";
                    spiral++;
                    break;
            }
         }

        return spiralOrder;
    }

    //Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>(numRows);
        /* Every element of Pascal's Triangle can be calculated with binomial coefficient C(n,k),
            where n is the row number and k is row's element number and counting starts from 0.
        */
        int elementValue;
        for (int row = 0; row < numRows; row++) {
            List<Integer> newRow = new ArrayList<>();
            for (int rowElement = 0; rowElement <= row; rowElement++) {
                elementValue = binomialCoeff(row, rowElement);
                newRow.add(elementValue);
            }
            pascalTriangle.add(newRow);
        }

        return pascalTriangle;
    }

    //Thanks google
    public int binomialCoeff(int n, int k) {
        // Base Cases
        if (k == 0 || k == n)
            return 1;

        // Recur
        return binomialCoeff(n - 1, k - 1) + binomialCoeff(n - 1, k);
    }
}