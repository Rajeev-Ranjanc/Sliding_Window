//https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/?envType=daily-question&envId=2024-03-29

import java.util.Map;

/*
    Count SubArray where Max elements appears at least K times
 */
public class SubArrayAtLeastKElements {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 3};
        int k = 2;
        System.out.println(countSubarrays(nums, k));
    }

    public static long countSubarrays(int[] nums, int k) {

        int i = 0;
        int j = 0;
        long n = nums.length;
        long maxelement = Long.MIN_VALUE;
        long count = 0;

        //finding maximum elements
        for (long num : nums) {
           maxelement  = Math.max(maxelement , num);
        }

        ///now apply sliding window
        long countmaximum = 0;
        while (j < nums.length) {
            if (nums[j] == maxelement) {
                countmaximum++;
            }

            while (countmaximum >= k) {

                count += n - j;
                if (nums[i] == maxelement) {
                    countmaximum--;
                }

                i++;
            }

            j++;
        }

        return count;
    }
}
