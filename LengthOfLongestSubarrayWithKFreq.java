import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/?envType=daily-question&envId=2024-03-28
public class LengthOfLongestSubarrayWithKFreq {
    public static void main(String[] args) {
        int[] nums = {1, 4, 4, 3};
        int k = 1;
        System.out.println(maxSubarrayLength(nums, k));
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        /*
        classical sliding window problem
         */
        int i = 0;
        int j = 0;
        int result = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        while (j < n) {

            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (i < j && map.get(nums[j]) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }
            result = Math.max(result, j - i + 1);
            j++;
        }
        return result;
    }
}
