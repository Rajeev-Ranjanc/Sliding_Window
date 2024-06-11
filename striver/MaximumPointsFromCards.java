package Sliding_Window.striver;
/*
    https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
    First sliding window problem from striver.
    First I have store the points from 0 to k-1 into a variable named leftSum.And after that I have started a
    loop from k-1 to 0 and everytime I was subtracting the ith from leftSum and adding the last element from
    array and rightIndex -- and string max into ans var and finally returned ans variable

 */

public class MaximumPointsFromCards {
    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }

    public static int maxScore(int[] cardPoints, int k) {

        int ans;

        int leftSum = 0;

        int n = cardPoints.length;

        int rightIndex = n - 1;

        for (int i = 0; i < k; i++) {

            leftSum += cardPoints[i];

        }

//        Now we will shrink the window
        ans = leftSum;
        for (int i = k - 1; i >= 0; i--) {

            leftSum -= cardPoints[i];

            leftSum += cardPoints[rightIndex];

            rightIndex--;

            ans = Math.max(leftSum, ans);

        }
        return ans;

    }
}
