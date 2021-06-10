package top.mumudm.datastructure.stack;

/**
 * @author mumu
 * @date 2021-6-10 11:31
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
