package week02;

import java.util.*;

/**
 * @Param: leetcode 590
 * @Author: fanshu.kong
 * @Date: 2020.07.26
 */

public class NTreePostorderTraversal {
    // 递归
    public List<Integer> postorder01(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> list) {
        if (root == null) return ;
        for (Node node : root.children) {
            helper(node, list);
        }
        list.add(root.val);
    }

    // 栈模拟递归
    public List<Integer> postorder02(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        Deque<Node> stack = new LinkedList<>();
        if (root == null) return  res;
        stack.addLast(root);
        while (!stack.isEmpty()) {
            Node temp = stack.removeLast();
            res.addFirst(temp.val);
            for (Node node : root.children) {
                stack.addLast(node);
            }
        }
        return res;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}