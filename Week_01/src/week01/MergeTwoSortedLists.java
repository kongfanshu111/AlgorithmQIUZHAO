package week01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Param: leetcode 21
 * @Author: fanshu.kong
 * @Date: 2020.07.19
 */

public class MergeTwoSortedLists {

    public static void main(String[] args) {

        ListNode l11 = new ListNode(1);
        ListNode l1 = l11;
        l1.next = new ListNode(1);
        l1 = l1.next;
        l1.next = new ListNode(2);
        l1 = l1.next;
        l1.next = new ListNode(4);

        ListNode l22 = new ListNode(1);
        ListNode l2 = l22;
        l2.next = new ListNode(3);
        l2 = l2.next;
        l2.next = new ListNode(4);

        MergeTwoSortedLists m1 = new MergeTwoSortedLists();
        ListNode l = m1.mergeTwoLists(l11, l22);

        List<Integer> list =new ArrayList<>();
        while(l != null) {
            list.add(l.val);
            l = l.next;
        }

        System.out.println(list.toString());
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode pre = l3;
        while (l1 != null && l2 != null) {
            int num = l1.val < l2.val ? l1.val : l2.val;
            l3.next = new ListNode(num);
            l3 = l3.next;
            if (num == l1.val) l1 = l1.next;
            else
                l2 = l2.next;
        }
        if (l1 == null) l3.next = l2;
        else l3.next = l1;
        return pre.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode (int val) {
            this.val = val;
        }
    }
}
