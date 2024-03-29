import java.util.ArrayList;
//https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1?page=1&sortBy=submissions
/*
I need to study sliding window properly I am writing good in that but facing some issues
In this problem I solve this using sliding window concept in this we run a loop while j is less than the length of
the array and start calculating the sum and if the sum is more than the given s and i is less than then subtract the
arr of i while it is greater once it is equal to the given s then we add i and j into list and return the list if the
list is empty then we add -1 into list and then we return that list
 */
public class INdexexOfSubArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int n = nums.length;
        int s = 0;
        System.out.println(subarraySum(nums, n, s));

    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> ans = new ArrayList<>();
        // Your code here
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < n) {
            sum += arr[j];
            while (sum > s && i<j) { // this i<j was throwing an error so its most crucial point to consider
                sum -= arr[i];
                i++;
            }

            if (sum == s) {
                ans.add(i + 1);
                ans.add(j + 1);
                break;
            }
            j++;

        }
        if (ans.isEmpty()) {
            ans.add(-1);
        }
        return ans;
    }
}
