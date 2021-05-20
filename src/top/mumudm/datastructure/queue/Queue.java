package top.mumudm.datastructure.queue;

/**
 * @author mumu
 * @date 2021-5-20 11:25
 */
public interface Queue<E> {

    /**
     * get queue size
     *
     * @return int
     */
    int getSize();


    /**
     * check queue is empty
     * @return boolean
     */
    boolean isEmpty();

    /**
     * put element into queue
     * @param e element
     */
    void enQueue(E e);

    /**
     * out put of the queue
     * @return E element
     */
    E deQueue();

    /**
     * get front element
     * @return  element
     */
    E getFront();

}
