package top.mumudm.datastructure.array;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 自己实现的 list
 *
 * @author mumu
 * @date 2021-5-17 14:47
 */
public class Array<E> {

    /**
     * 数据
     */
    private E[] data;
    /**
     * 大小
     */
    private int size;

    /**
     * 默认容量为 10
     */
    public Array() {
        this(10);
    }

    /**
     * 创建指定大小的列表
     *
     * @param capacity 能力
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 获取数组大小
     *
     * @return int
     */
    public int getSize() {
        return size;
    }

    /**
     * 在指定位置添加元素
     *
     * @param index 索引下标
     * @param e     待添加元素
     */
    public void add(int index, E e) {
        checkIndex(index);
        if (size == data.length) {
            reSize(BigDecimal.valueOf(Math.ceil(1.5 * data.length)).intValue());
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        // if (size - index >= 0) {
        //     System.arraycopy(data, index, data, index + 1, size - index);
        // }
        data[index] = e;
        size++;
    }

    /**
     * check if the index is correct
     *
     * @param index 指数
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index");
        }
    }

    /**
     * 在数组第一位添加
     *
     * @param e e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在数组最后一位添加
     *
     * @param e e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在数组最后一位添加
     *
     * @param e e
     */
    public void add(E e) {
        addLast(e);
    }

    /**
     * 获取指定索引位置的元素
     *
     * @param index 指数
     * @return {@link E}
     */
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    /**
     * 获取最后一位的元素
     *
     * @return {@link E}
     */
    public E getLast() {
        return get(size -1);
    }

    /**
     * 获取第一位元素
     *
     * @return {@link E}
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取指定元素在数组中的索引位置
     *
     * @param e e
     * @return int
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if(Objects.equals(data[i], e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除指定位置的数据
     *
     * @param index 索引下标
     * @return {@link E}
     */
    public E remove(int index) {
        E e = get(index);

        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;

        if(size < data.length/2){
            reSize(data.length / 2);
        }
        return e;
    }

    /**
     * 删除元素
     *
     * @param e e
     * @return int
     */
    public int removeElement(E e){
        int index = find(e);
        if(index == -1){
            return index;
        }
        remove(index);
        return index;
    }

    /**
     * 确定数组中是否包含指定元素
     *
     * @param e e
     * @return boolean
     */
    public boolean contains(E e){
        int index = find(e);
        return index != -1;
    }

    /**
     * 清空数组元素
     */
    public void clear(){
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /**
     * 判断数组是否为空
     *
     * @return boolean
     */
    public boolean isEmpty(){
        return size == 0;
    }


    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.addFirst(4);
        array.remove(1);
        array.remove(0);
        System.out.println(array);
        System.out.println(array.find(2));
        array.removeElement(2);

        System.out.println(array);
    }


    /**
     * 根据给定的大小修改数组的长度
     *
     * @param capacity 数组容量
     */
    private void reSize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        // for (int i = 0; i < size; i++) {
        //     newData[i] = data[i];
        // }
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * remove first element
     *
     * @return {@link E}
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * remove last element
     *
     * @return {@link E}
     */
    public E removeLast() {
        return remove(size - 1);
    }
}
