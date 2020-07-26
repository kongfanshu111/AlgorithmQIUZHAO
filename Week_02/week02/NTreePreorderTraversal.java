package week02;

import java.util.*;

/**
 * @Param: leetcode 589
 * @Author: fanshu.kong
 * @Date: 2020.07.26
 */

public class NTreePreorderTraversal {
    // 递归
    public List<Integer> preorder01(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(Node root, List<Integer> list) {
        if (root == null) return ;
        list.add(root.val);
        for (Node node : root.children) {
            helper(node, list);
        }
    }

    // 栈模拟递归
    public List<Integer> preorder02(Node root) {
        List<Integer> res = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        if (root == null) return res;
        stack.addLast(root);
        while (!stack.isEmpty()) {
            Node temp = stack.removeLast();
            res.add(temp.val);
            Collections.reverse(temp.children);
            for (Node node : temp.children) {
                stack.addLast(node);
            }
        }
        return res;
    }
}

