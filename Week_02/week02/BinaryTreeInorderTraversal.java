package week02;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Param: leetcode 94
 * @Author: fanshu.kong
 * @Date: 2020.07.26
 */

public class BinaryTreeInorderTraversal {
    // 递归
    public List<Integer> inorderTraversal01(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) return ;
        helper(root.left,list);
        list.add(root.val);
        helper(root.right, list);
    }

    // 使用栈模拟递归
    public List<Integer> inorderTraversal02(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) return list;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addLast(root);
                root = root.left;
            }
            root = stack.removeLast();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
