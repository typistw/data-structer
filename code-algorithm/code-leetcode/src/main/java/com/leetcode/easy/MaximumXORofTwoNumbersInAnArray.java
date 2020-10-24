package com.leetcode.easy;

/**
 * Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 ≤ i ≤ j < n.
 *
 * Follow up: Could you do this in O(n) runtime?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,10,5,25,2,8]
 * Output: 28
 * Explanation: The maximum result is 5 XOR 25 = 28.
 * Example 2:
 *
 * Input: nums = [0]
 * Output: 0
 * Example 3:
 *
 * Input: nums = [2,4]
 * Output: 6
 * Example 4:
 *
 * Input: nums = [8,10,2]
 * Output: 10
 * Example 5:
 *
 * Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * Output: 127
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * 0 <= nums[i] <= 231 - 1
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class MaximumXORofTwoNumbersInAnArray {

    public static void main(String[] args) {
        int[] nums = {3,10,5,25,2,8};
        System.out.println(findMaximumXOR(nums));
    }

    public static int findMaximumXOR(int[] nums) {
        if(nums.length <= 1)
            return 0;

        int max = 0;
        for(int i = 0 ;i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                int val = nums[i] ^ nums[j];
                max = Math.max(max, val);
            }
        }

        return max;
    }
}
