package week02;

import java.util.Comparator;

import java.util.PriorityQueue;

/**
 * @Param: 剑指offer 40
 * @Author: fanshu.kong
 * @Date: 2020.07.25
 */

public class SmallestK {
    public int[] smallestK(int[] arr, int k) {

        // 建立大顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o2;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (heap.size() < k) {
                heap.add(arr[i]);
            } else {
                if (arr[i] < heap.peek()) {
                    heap.remove();
                    heap.add(arr[i]);
                }
            }
        }

        int[] res = new int[k];
        int i = 0;
        for (Integer n : heap) {
            res[i++] = n;
        }

        return res;
    }
}
