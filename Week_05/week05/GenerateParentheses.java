package week05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Param: leetcode 22
 * @Author: fanshu.kong
 * @Date: 2020.08.14
 */

public class GenerateParentheses {
    // DFS + 剪枝
    public List<String> generateParenthesis01(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        dfs(0, 0, n, "", res);
        return res;
    }
    public void dfs(int left, int right, int max, String str, List<String> list) {
        if (left == max && right == max) {
            list.add(str);
            return ;
        }
        if (left < max) dfs(left + 1, right, max, str + "(", list);
        if (left > right) dfs(left, right + 1, max, str + ")", list);
    }

    // BFS
    class Node {
        int left;
        int right;
        String str;
        public Node (int left, int right, String str) {
            this.left = left;
            this.right = right;
            this.str = str;
        }
    }
    public List<String> generateParenthesis02(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, ""));
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node.left == n && node.right == n) {
                res.add(node.str);
            }
            if (node.left < n) queue.add(new Node(node.left +1 , node.right, node.str + "("));
            if (node.right < node.left) queue.add(new Node(node.left, node.right + 1, node.str + ")"));
        }
        return res;
    }
}
