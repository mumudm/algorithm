package top.mumudm.datastructure.queue;

import top.mumudm.datastructure.array.LinkedArray;

/**
 * @author mumu
 * @date 2021-6-10 10:47
 */
public class LinkedQueue<E> implements Queue<E> {

    private LinkedArray<E> data;

    public LinkedQueue(LinkedArray<E> data) {
        this.data = data;
    }

    public LinkedQueue() {
        this.data = null;
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void enQueue(E e) {
        data.addLast(e);
    }

    @Override
    public E deQueue() {
        return data.removeFirst();
    }

    @Override
    public E getFront() {
        return data.getFirst();
    }
}
