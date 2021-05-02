package top.mumudm.sort.util;

import top.mumudm.sort.selectionSort.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author mumu
 * @date 2021-5-2 12:13
 */
public class SortUtil {

    public SortUtil() {
    }

    public static void sort(Comparable[] data) {
        sort(Thread.currentThread().getStackTrace()[2].getClassName(), data);
    }


    public static void sort(String sortedName, Comparable[] data) {
        long startTime = System.currentTimeMillis();
        try {
            Class<?> aClass = Class.forName(sortedName);
            Method sort = aClass.getMethod("sort", Comparable[].class);
            sort.invoke(aClass, (Object) data);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("can not found sorted name: " + sortedName, e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("can not found sort function in " + sortedName, e);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("sorted: %s, size: %d,time: %d ms%n", sortedName, data.length, endTime - startTime);
    }

    public static  <E extends Comparable<E>> boolean isSorted(E[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i - 1].compareTo(data[i]) > 0) {
                throw new RuntimeException("sorted failed");
            }
        }
        return true;
    }


    public static Integer[] generateArray(int size, int max) {
        Integer[] data = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(max);
        }
        return data;
    }

    public static Person[] generatePersonArray(int size, int max) {
        Person[] data = new Person[size];
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = new Person("a", random.nextInt(max));
        }
        return data;
    }
}
