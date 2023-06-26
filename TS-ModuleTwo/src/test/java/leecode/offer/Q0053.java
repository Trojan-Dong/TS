package leecode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * <p>
 */
public class Q0053 {
    
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int tempSum = 0;
                for (int k = i; k <= j; k++) {
                    tempSum += nums[k];
                }
                if (tempSum > max) {
                    max = tempSum;
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        Q0053 q = new Q0053();
        int[] nums = new int[]{5,4,-1,7,8};
        System.out.println(q.maxSubArray(nums));
    }
}
