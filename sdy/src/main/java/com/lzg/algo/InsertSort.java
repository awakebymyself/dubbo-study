package com.lzg.algo;

import java.util.Arrays;

/**
 * @author 刘志钢
 */
public class InsertSort {

    //插入排序
    // n为数组长度
    // 思想：将数组分为两段，已排序的和未排序的，将未排序的的插入到已排序的位置，分为比较和交换两阶段
    // 假设拿到的第一个数就是已经排序好的
    private static int[] sort(int[] a, int n) {
        for (int i = 1; i < n; i++) { //n-1此扫描，依次向前插入n-1个元素
            // 待排序的数字，每趟将a[i]插入到前面的排序子序列中
            int temp = a[i];
            // 查找插入的位置
            int j = i -1;
            for (; j >= 0; j--) { //从尾巴到头遍历已有的有序数据
                if (a[j] > temp) { //把a[j]往后移动
                    a[j + 1] = a[j]; //数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = temp; //插入数据
        }
        return a;
    }

    // 时间复杂度， 最好O(n) --本来就是有序的
    // 最差 倒序 O(n*n) 平均O(n*n)
    //空间复杂度 O(1) 只有位置交换没有额外分配数组
    // 是原地排序（空间复杂度是常数阶），是稳定的排序（相同的数据会保持原来的顺序）,
    public static void main(String[] args) {
        int[] a = new int[]{6, 4, 5, 1, 3, 2};
        int[] sort = InsertSort.sort(a, a.length);
        Arrays.stream(sort).forEach(System.out::println);

    }


}
