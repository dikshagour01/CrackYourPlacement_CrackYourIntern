import java.util.*;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> duplicates = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) >= 2) {
                duplicates.add(key);
            }
        }
        return duplicates;
    }
}
