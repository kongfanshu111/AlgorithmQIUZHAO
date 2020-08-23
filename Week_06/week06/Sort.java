package week06;

import java.util.Arrays;

/**
 * @Param: sort
 * @Author: fanshu.kong
 * @Date: 2020.08.21
 */

public class Sort {

    // 冒泡排序，每次找最大值，通过相邻的两个比较
    public int[] bubbleSort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length - i - 1; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }
        return num;
    }

    // 选择排序,每次寻找数组中的最小值,利用坐标进行记录
    public int[] selectSort(int[] num) {
        for (int i = 0; i < num.length - 1; i++) {

            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[minIndex] > num[j]) {
                    minIndex = j;
                }
            }

            // 交换
            int temp = num[minIndex];
            num[minIndex] = num[i];
            num[i] = temp;
        }
        return num;
    }

    // 插入排序
    public int[] insertSort(int[] num) {
        if (num.length <= 1) return num;
        for (int i = 1; i < num.length; i++) {
            int temp = num[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (num[j] > temp) {
                    num[j + 1] = num[j];
                } else {
                    break;
                }
            }
            num[j + 1] = temp;
        }
        return num;
    }

    // 快速排序,注意分区函数的书写
    public int[] quickSort(int[] num) {
        quickSortSlove(num, 0, num.length - 1);
        return num;
    }
    public void quickSortSlove(int[] num,int start, int end) {
        if (start >= end) {  // 递归终止条件
            return ;
        }
        int pivot = partition(num, start, end); // 处理当前层
        quickSortSlove(num, start, pivot - 1); // 递归到下一层
        quickSortSlove(num, pivot + 1, end);
    }
    public int partition(int[] num, int start, int end) {
       int pivot = num[end];
       int count = start;
       for (int i = start; i < end; i++) {
           if (num[i] < pivot) {
               int temp = num[i];
               num[i] = num[count];
               num[count] = temp;
               count++;
            }
       }
       int temp = num[end];
       num[end] = num[count];
       num[count] = temp;
       return count;
    }

    // 归并排序
    public int[] mergeSort(int[] num) {
        if (num.length <= 1) return num;
        mergeSortSolve(num, 0, num.length - 1);
        return num;
    }
    private void mergeSortSolve(int[] num, int start, int end) {
        if (start >= end) return ;
        int mid = start + ((end - start) >> 1);
        mergeSortSolve(num, start, mid);
        mergeSortSolve(num, mid + 1, end);
        merge(num, start, mid, end);
    }
    private void merge(int[] num, int start, int mid, int end) {
        int[] array = new int[end - start + 1];
        int k = 0;
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            array[k++] = num[i] <= num[j] ? num[i++] : num[j++];
        }
        while (i <= mid) array[k++] = num[i++];
        while (j <= end) array[k++] = num[j++];
        for (int p = 0; p < array.length; p++) {
            num[start + p] = array[p];
        }
    }

    // 希尔排序
    public int[] shellSort(int[] num) {
        if (num == null || num.length <= 1) return num;
        int temp;
        for (int step = num.length / 2; step >= 1; step /= 2) {
            for (int i = step; i < num.length; i++) {
                temp = num[i];
                int j = i - step;
                while (j >= 0 && num[j] > temp) {
                    num[j + step] = num[j];
                    j -= step;
                }
                num[j + step] = temp;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] num = new int[]{22,14,54,74,10,20,21,24,21,11,132};
        sort.quickSort(num);
        System.out.println(Arrays.toString(num));
    }
}
