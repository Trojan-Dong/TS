package leecode.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class Q0003 {
    
    public static int getNoDumplicateSubStr(String s) {
        StringBuilder subStr = new StringBuilder();
        int subLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (subStr.toString().contains(String.valueOf(s.charAt(i)))) {
                subLen = Math.max(subStr.length(), subLen);
                String append = subStr.substring(subStr.toString().indexOf(s.charAt(i)));
                subStr = new StringBuilder().append(append);
            } else {
                subStr.append(s.charAt(i));
            }
        }
        return Math.max(subStr.length(), subLen);
    }
    
    public static int localSolution(String str) {
        int len = 0;
        for (int i = 0; i < str.length(); i++) {
            String temStr = "";
            for (int j = i; j < str.length(); j++) {
                if (!temStr.contains(String.valueOf(str.charAt(j)))) {
                    temStr += str.charAt(j);
                } else {
                    if (len < temStr.length()) {
                        len = temStr.length();
                    }
                    break;
                }
                if (len < temStr.length()) {
                    len = temStr.length();
                }
            }
        }
        return len;
    }
    
    /**
     * 官方题解 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
    
    
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(localSolution(str));
        //        System.out.println(getNoDumplicateSubStr(str));
    }
}
