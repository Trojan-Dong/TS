package leecode.offer;

import java.util.*;

/**
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数， 并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * </p>
 *
 * @Author DGJ
 * @Date 2023/6/16
 * @Description
 * @Version 1.0
 **/
public class Q0001 {
    
    //循环遍历 时间复杂度O(N^2)
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= 0; j--) {
                System.out.println("t1:" + nums[i] + ",t2:" + nums[j]);
                if (nums[i] + nums[j] == target && i != j) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
    
    //通过map中的key值不可重复 做解 时间复杂度O(N)
    public int[] bestAnwser(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
    public static void main(String[] args) {
        Q0001 question = new Q0001();
        int[] result = question.bestAnwser(new int[] {2, 7, 11, 15}, 9);
        for (int a : result) {
            System.out.println(a);
        }
    }
    
}
