//https://leetcode.com/problems/subarray-product-less-than-k/
public class SubArrayProducLeesThanK {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
       /*classic sliding window problem exactly sliding window concept
        Khandani template
        similar questions:
                        maximum size subarray sum equals to k
                        subarrry sum equals to k
                        subarray having equals vowel & consonent
                        find longest substring contain vowels in even counts
                        maximum number of vowels in a substring of given length

                        total subarray in the window = j-i+1;

        */
        int i = 0;
        int j = 0;
        int count = 0;
        int product = 1;

        while (j < nums.length) {

            product *= nums[j];

            while (product >= k) {

                product /= nums[i];
                i++;

            }

            count += j - i + 1;
            j++;

        }
        return count;

    }
}
