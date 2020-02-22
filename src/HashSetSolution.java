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
}
