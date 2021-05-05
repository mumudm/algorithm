package top.mumudm.sort;

import top.mumudm.sort.util.SortUtil;

/**
 * 插入排序
 *
 * @author mumu
 * @date 2021-5-2 19:48
 */
public class InsertionSort {
    private InsertionSort() {
    }

    public static void main(String[] args) {
        // Integer[] data = {3, 2, 7, 4, 5, 3, 2};
        // sort(data);
        Integer[] array = SortUtil.generateRandomArray(50000, 10000);
        SortUtil.sort(array);
        SortUtil.isSorted(array);
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        for (int i = 0; i < data.length; i++) {

            // for (int j = i; j > 0; j--) {
            //     if (data[j].compareTo(data[j - 1]) < 0) {
            //         swap(data, j, j - 1);
            //     } else {
            //         break;
            //     }
            // }

            // 优化 1
            // for (int j = i; j > 0 && data[j].compareTo(data[j - 1]) < 0; j--) {
            //     swap(data, j, j - 1);
            // }

            // 优化 2
            E e = data[i];
            int j = i;
            for (; j > 0 && data[j].compareTo(data[j - 1]) < 0; j--) {
                data[j] = data[j - 1];
            }
            data[j] = e;
        }
        // System.out.println(Arrays.toString(data));
    }

    private static <E extends Comparable<E>> void swap(E[] data, int i, int j) {
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
}
