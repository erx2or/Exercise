import java.util.HashMap;
import java.util.Map;

public class HashMapSolution {

    /* Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.*/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int key = 0;
        for (int n : nums)
                numMap.put(n, key++);

        for (int i = 0; i < nums.length; i++) {
            int search = target - nums[i];
            if (numMap.containsKey(search) && numMap.get(search) != i)
                return new int[] {i, numMap.get(search)};
        }

        return new int[] {};
    }

    public void printHashMap(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print("(" + sentry.getKey() + "," + entry.getValue() + ") ");
        }
    }
}
