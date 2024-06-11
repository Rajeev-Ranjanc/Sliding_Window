package Sliding_Window.striver;

import java.util.Arrays;

public class LongestSubt {
    public static void main(String[] args) {

    }

    /*

    https://leetcode.com/problems/longest-substring-without-repeating-characters/
    See video for better understanding

    TC : O(N)
    SC : O(256)

    */
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        int i = 0;

        int j = 0;

        int ans = 0;

        int[] hash = new int[256];

        Arrays.fill(hash, -1);

        while (j < n) {

            char ch = s.charAt(j);
// If the character has been seen before and is within the current window
            if (hash[ch] != -1) {

                if (hash[ch] >= i) {
                    // Move the start pointer 'i' to the right of the last occurrence of the current character
                    i = hash[ch] + 1;

                }
            }

            int length = j - i + 1;

            ans = Math.max(length, ans);

// Update the last seen index of the current character
            hash[ch] = j;

            // Move the end pointer to the next position
            j++;

        }

        return ans;
    }
}
