package com.lzg.algo;

import java.util.Arrays;

/**
 * @author 刘志钢
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] a = new int[]{6, 5, 4, 1, 2, 3};
        sort(a, a.length);
        Arrays.stream(a).forEach(System.out::println);
    }


    //选择排序思想，和插入一样分为已经排序的和未排序的两个区间，从未排序里面找出最小的插入到已排序里面。
    // 时间复杂度， 最好O(n) --本来就是有序的
    // 最差 倒序 O(n*n) 平均O(n*n)
    //空间复杂度 O(1) 只有位置交换没有额外分配数组
    // 是原地排序（空间复杂度是常数阶），是稳定的排序（相同的数据会保持原来的顺序）,
    private static void sort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 0; i< n -1; i++) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j ++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            //交换
            int temp = a[i];//简单理解就是其实就是从位置开始寻找，找到最小的和当前位置交换
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

}
