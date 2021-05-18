package top.mumudm.datastruce;

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

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void add(E e) {
        addLast(e);
    }

    public E get(int index) {
        checkIndex(index);

        return data[index];
    }

    public int getIndex(E e) {
        for (int i = 0; i < size; i++) {
            if(Objects.equals(data[i], e)){
                return i;
            }
        }
        return -1;
    }

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
        int index = getIndex(e);
        if(index == -1){
            return index;
        }
        remove(index);
        return index;
    }

    public static void main(String[] args) {
        Array<Object> array = new Array<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.addFirst(4);
        array.remove(1);
        array.remove(0);
        System.out.println(array);
        array.remove(new Integer(3));

        System.out.println(array);
    }


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

}
