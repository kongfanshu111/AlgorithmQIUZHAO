package week02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Param: leetcode 429
 * @Author: fanshu.kong
 * @Date: 2020.07.26
 */

public class NTreeLevelOrderTraversal {
    // 使用队列
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node temp = queue.remove();
                list.add(temp.val);
                queue.addAll(temp.children);
            }
            res.add(list);
        }
        return res;
    }
}
