package leecode.offer;

import java.util.ArrayList;
import java.util.List;

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
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(q.maxSubArray(nums));
    }
}
