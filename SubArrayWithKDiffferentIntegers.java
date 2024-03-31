import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarrays-with-k-different-integers/description/?envType=daily-question&envId=2024-03-30
/*
This problem is saying that we count the number of Subarray which contains the k number of different elements
so in this the toughest part is finding/getting understanding that we find total no of such subarray which
contains k different elements and if we subtract the subarray which contains k-1 different elements then we can get
as result the number of subarray which contains the K no of different elements, and we know to find the such subarray
which contains kth unique elements or such conditions using sliding window algorithm lets write the code

Or to elaborate, these problems first find all the subarray ending with j using khandani template of sliding window and
later remove all those which does not contain K no of different elements
 */
public class SubArrayWithKDiffferentIntegers {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return SlidingWindow(nums, k) - SlidingWindow(nums, k - 1);
    }

    public static int SlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int i = 0;
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();//Space complexity :0(n)
        int count = 0;

        while (j < n) {

            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.size() > k) {
//              Shrink the window
                map.put(nums[i], map.get(nums[i]) - 1);

                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            count += j - i + 1;// subarray ending at j
            j++;

        }

        return count;
    }
}
