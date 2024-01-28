import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
/*
POS-> First non-negative number in a window size K
//brute Force I can approach
//Done on gfg
Identification :
1. Problem is of Array
2. Asking the -ve number within a range
3. Talking about Subarray
 Solution:
 First I will add all the negative elements in a queue because I'm only searching about the negative elements in the array
 and Start sliding the window by j++ once I will hit the window i will check is my queue is empty if queue will empty i will put zero
 int the answer array at the first index and increase the index of the ans array and if queue will not be empty
then i will put the very first elements of the queue in the answer array and later will remove that number from queue which one i have
inserted into ans array and simply silde the window i++ within the brace of hitting the window and after getting outside of this brace
we will increase the window by j++;


 */
public class FirstNegaitveWindowK {
    public static void main(String[] args) {
        int n = 5;
        int[] nums = {-8, 2, 3, -6, 10};
        int k = 2;
        System.out.println(Arrays.toString(printFirstNegativeInteger(nums, n, k)));
    }

    public static long[] printFirstNegativeInteger(int[] nums, int size, int k) {

        /*
        //brute force would be
        long[] ans = new long[size - k + 1];
//       ans= new long[]{0};

        for (int i = 0; i < size - k; i++) {
            for (int j = i; j <=k + i; j++) {
                if (nums[j] < 0) {
                    ans[i] = nums[j];
                    break;
                }
            }
        }
        return ans;
         */

        int i = 0;
        int j = 0;
        int index = 0;
        long[] ans = new long[size - k + 1];
        Queue<Integer> q = new LinkedList<>();
        while (j<size){

            //adding negative elements in the queue
            if(nums[j]<0){
                q.add(nums[j]);
            }
            if(j-i+1<k){
                j++;
            }
            if(j-i+1==k){
                if(q.isEmpty()){
                    ans[index] = 0;
                    index++;
                }
                else{
                    int number = q.peek();
                    ans[index] = number;
                    index++;
                    if(number==nums[i]){
                        q.remove();
                    }
                }
                i++;
            }
            j++;
        }
        return ans;

    }
}
