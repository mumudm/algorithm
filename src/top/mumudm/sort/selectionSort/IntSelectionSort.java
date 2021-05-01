package top.mumudm.sort.selectionSort;

import java.util.Arrays;

/**
 * 数字选择排序
 *
 * 先将将数组中最小的值放在第一位，
 * 在从第二位开始往后继续查找最小的值放在第二位，
 * 接着从第三位开始往后继续查找最小的值放在第三位，
 * 以此类推
 *
 * @author mumu
 * @date 2021-5-1 21:33
 */
public class IntSelectionSort {

    public static void main(String[] args) {
        int[] data = {6, 3, 7, 5, 3, 2, 1, 7};
        sort(data);
    }

    public static void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = i; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            swap(data, i, minIndex);
        }
        System.out.println(Arrays.toString(data));
    }

    private static void swap(int[] data, int i, int j) {
        int t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

}
