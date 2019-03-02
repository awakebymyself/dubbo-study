package com.lzg.algo;

import java.util.Arrays;

/**
 * @author 刘志钢
 */
public class BubbleSort {

    //冒泡排序
    // n为数组长度
    // 思想：两两比较大的往后移动，第一次排完之后最大的在最后面
    private static int[] sort(int[] a, int n) {//最开始从数组第一个元素开始两两比较for结束即第一轮冒泡结束
        if (n <= 1) {
            return a;
        }
        for (int i = 0; i < n; i++) {
            boolean exchanged = false;
            int temp;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    exchanged = true;
                }
            }
            if (!exchanged) {
                break;
            }

        }
        return a;
    }

    // 时间复杂度， 最好O(n) --本来就是有序的
    // 最差 倒序 O(n*n) 平均O(n*n)
    //空间复杂度 O(1) 只有位置交换没有额外分配数组
    // 是原地排序（空间复杂度是常数阶），是稳定的排序（相同的数据会保持原来的顺序）,
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 6, 5};
        int[] sort = BubbleSort.sort(a, a.length);
        Arrays.stream(sort).forEach(System.out::println);

    }

}
