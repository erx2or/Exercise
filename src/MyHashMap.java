import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Design a HashMap without using any built-in hash table libraries.
To be specific, your design should include these functions:
put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
All keys and values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashMap library.
*/
public class MyHashMap {
    //HashMap is almost like a list of arrays
    List<int[]> hashMap;

    /** Initialize your data structure here. */
    public MyHashMap() {
        hashMap = new ArrayList<>();
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        if (get(key) == -1)
            hashMap.add(new int[]{key, value});
        else {
            hashMap.stream().filter(pair -> pair[0] == key)
                    .findAny()
                    .map(pair -> pair[1] = value);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return hashMap.stream()
                .filter(pair -> pair[0] == key)
                .findAny()
                .map(pair -> pair[1])
                .orElse(-1);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hashMap.removeIf(pair -> pair[0] == key);
    }

    public void print() {
        System.out.println("HashMap is: ");
        for (int[] pair : hashMap) {
            System.out.printf("%s ", Arrays.toString(pair));
        }
        System.out.println();
    }
}

