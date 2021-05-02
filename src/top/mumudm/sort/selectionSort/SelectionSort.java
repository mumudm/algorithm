package top.mumudm.sort.selectionSort;

import top.mumudm.sort.util.SortUtil;

/**
 * 选择排序
 * <p>
 * 先将将数组中最小的值放在第一位，
 * 在从第二位开始往后继续查找最小的值放在第二位，
 * 接着从第三位开始往后继续查找最小的值放在第三位，
 * 以此类推
 *
 * @author mumu
 * @date 2021-5-1 21:33
 */
public class SelectionSort {

    public static void main(String[] args) {
        Integer[] array = SortUtil.generateArray(50000, 10000);
        SortUtil.sort(array);
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = i; j < data.length; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(data, i, minIndex);
        }
        // System.out.println(Arrays.toString(data));
    }

    private static <T> void swap(T[] data, int i, int j) {
        T t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

}
