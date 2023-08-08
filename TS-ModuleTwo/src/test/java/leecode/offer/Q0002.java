package leecode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 *   输入：l1 = [2,4,3], l2 = [5,6,4] 输出：[7,0,8] 解释：342 + 465 = 807. 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0] 输出：[0] 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] 输出：[8,9,9,9,0,0,0,1]  
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内 0 <= Node.val <= 9 题目数据保证列表表示的数字不含前导零
 * <p>
 * class Solution { public: ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
 * <p>
 * } };
 *
 * </p>
 *
 * @Author DGJ
 * @Date 2023/6/16
 * @Description
 * @Version 1.0
 **/
public class Q0002 {
    
    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        int sum;
        ListNode listNode = new ListNode();
        while (l1 != null) {
            ListNode newNode;
            if (l2 != null) {
                sum = l1.val + l2.val + temp;
                temp = sum / 10;
                l1 = l1.next;
                l2 = l2.next;
            } else {
                sum = l1.val + temp;
                temp = sum / 10;
                l1 = l1.next;
            }
            newNode = new ListNode(sum % 10, listNode);
            listNode = newNode;
        }
        while (l2 != null) {
            ListNode newNode;
            sum = l2.val + temp;
            temp = sum / 10;
            l2 = l2.next;
            newNode = new ListNode(sum % 10, listNode);
            listNode = newNode;
        }
        
        return listNode;
    }
    
    public List addTwoNumbers(int[] l1, int[] l2) {
        int temp = 0;
        int sum;
        List<Integer> list = new ArrayList();
        for (int i = 0; i < l1.length; i++) {
            if (i < l2.length) {
                sum = l1[i] + l2[i] + temp;
            } else {
                sum = l1[i] + temp;
            }
            temp = sum / 10;
            list.add(sum % 10);
            if (i == l1.length - 1 && temp == 1) {
                list.add(temp);
            }
        }
        return list;
        
    }
    
    /**
     * 官方题解
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0; //进位
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
    
    public static void main(String[] args) {
        int[] l1 = {9, 9, 9, 9, 9, 9, 9};
        int[] l2 = {9, 9, 9, 9};
        //        List<Integer> list = addTwoNumbers(l1, l2);
        //        for (int t : list) {
        //            System.out.println(t);
        //        }
        
    }
    public void initParam(ListNode l1,ListNode l2){
        l1=new ListNode(9,null);
        l1.next=new ListNode(9,null);
     
    }
    
    public static class ListNode {
        
        int val;
        
        ListNode next;
        
        ListNode() {
        }
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        
        Integer getLenth() {
            if (this != null) {
                int lenth = 1;
                if (this.next != null) {
                    lenth += 1;
                }
                return lenth;
            } else {
                return 0;
            }
        }
        
        boolean hasNext() {
            if (this.next == null) {
                return false;
            } else {
                return true;
            }
        }
    }
}
