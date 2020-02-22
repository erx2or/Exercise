import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main (String[] args){
        //Input for Array and 2D Array solutions and TwoPointer solution
        int[] nums = {0, 2, 0, 1, 0};
        int[] digits = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
        int[] digits1 = {9, 9, 9};
        int[][] matrix = { {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int pascalTriangleRows = 10;

        //Input for String solutions and TwoPointer solutions
        String firstBinaryNumber = "101000001001001101100100000101011110110110";
        String secondBinaryNumber = "1101010010111011100011111001100010101000";
        String haystack = "hello";
        String needle = "lo";
        String[] words = {"passed","passengerlalalala","pass314"};
        char[] reverseMe = {'g', 'a', 'r', 'd', 'e', 'n', 'i', 'a'};
        int[] moreNums = {7, 3, 1, 0, 0, -6};
        int[] ascArray = {2, 7, 11, 15};
        int target = 26;
        int[] changeMe = {0, 4, -13, 100, 8, 9, 4};
        int remove = 4;
        int[] binary = {1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1};
        int[] rotateMe = {1, -50, 34, 23, 0, 10};
        int step = 3;
        int row = 10;

        //Input for HasSet solutions and HashMap solutions
        int[] duplicates = {1, 2, 3, 4, 1, 1, 3, 3};
        int[] noPair = {4, 1, 2, 1, 2};

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
        TwoPointerSolution test = new TwoPointerSolution();
        test.reverseString(reverseMe);
        System.out.println("After reverse: " + Arrays.toString(reverseMe));

        System.out.println("\nFor array " + Arrays.toString(moreNums));
        int maxSumOfMinPairs = new TwoPointerSolution().arrayPairSum(moreNums);
        System.out.println("The largest sum of min pairs is " + maxSumOfMinPairs);

        int[] positions = new TwoPointerSolution().twoSum(ascArray, target);
        System.out.println("\nFor array " + Arrays.toString(ascArray) +
                "\nValues at positions: " + Arrays.toString(positions) + " sum up to " + target);

        System.out.println("\nRemove " + remove + " from array " + Arrays.toString(changeMe));
        int timesRemoved = new TwoPointerSolution().removeElement(changeMe, remove);
        int[] changedArr = Arrays.copyOfRange(changeMe, 0, timesRemoved);
        System.out.println("New array length: " + timesRemoved +
                "\nAnd its sub-array is " + Arrays.toString(changedArr));

        int maxConsecutiveOnes = new TwoPointerSolution().findMaxConsecutiveOnes(binary);
        System.out.println("\nFor array " + Arrays.toString(binary) +
                "\nThe maximum number of consecutive ones is: " + maxConsecutiveOnes);

        int minSubarrLength = new TwoPointerSolution().minSubArrayLen(target, digits);
        System.out.println("\nFor array " + Arrays.toString(digits) +
                "\nThe minimal length of a contiguous sub-array of which the sum ≥ " + target + " is " + minSubarrLength);

        System.out.println("\nBefore rotate: " + Arrays.toString(rotateMe));
        test.rotate(rotateMe, step);
        System.out.println("After rotate: " + Arrays.toString(rotateMe));

        List<Integer> pascalTriangleNRow = new ArraySolution().getRow(row);
        System.out.println("\nPascal's Triangle " + row + "nth row is:\n" + pascalTriangleNRow);

        System.out.println();
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(0);
        hashSet.add(2);
        hashSet.print();
        System.out.println("Contains 1? " + hashSet.contains(1));    // returns true
        System.out.println("Contains 3? " + hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        hashSet.print();
        System.out.println("Contains 2? " + hashSet.contains(2));    // returns true
        hashSet.remove(2);
        hashSet.print();
        System.out.println("Contains 2? " + hashSet.contains(2));    // returns false (already removed)

        System.out.println();
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.print();
        System.out.println("Value for key 1: " + hashMap.get(1));            // returns 1
        System.out.println("Value for key 3: " + hashMap.get(3));            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        hashMap.print();
        System.out.println("Value for key 2: " + hashMap.get(2));            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        hashMap.print();
        System.out.println("Value for key 2: " + hashMap.get(2));            // returns -1 (not found)

        System.out.println("\nArray: " + Arrays.toString(duplicates) + ". Has duplicates? " + new HashSetSolution().containsDuplicate(duplicates));
        System.out.println("Array: " + Arrays.toString(noPair) + ". Element without pair is: " + new HashSetSolution().singleNumber(noPair));
    }
}
