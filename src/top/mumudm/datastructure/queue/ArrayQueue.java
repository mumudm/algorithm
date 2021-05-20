package top.mumudm.datastructure.queue;

import top.mumudm.datastructure.array.Array;

/**
 * 数组队列
 * 队列具有先进先出的特性，FIFO（Firs in,First out）
 * 
 *
 * @author mumu
 * @date 2021-5-20 10:53
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> data;

    public ArrayQueue(){
        data = new Array<E>();
    }

    public ArrayQueue(int capacity){
        data = new Array<>(capacity);
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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayQueue: front[");
        for (int i = 0; i < data.getSize(); i++) {
            sb.append(data.get(i));
            if(data.getSize() -1 != i){
                sb.append(", ");
            }
        }
        sb.append("] ");
        return sb.toString();
    }


    public static void main(String[] args) {
        ArrayQueue<Object> queue = new ArrayQueue<>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);

        System.out.println(queue);

        queue.deQueue();
        queue.deQueue();
        queue.deQueue();

        System.out.println(queue);
        System.out.println(queue.isEmpty());
        System.out.println(queue.getSize());
    }
}
