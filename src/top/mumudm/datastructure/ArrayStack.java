package top.mumudm.datastructure;

/**
 * 堆栈
 * 栈是一种特殊的线性表，具有先进后出的特性，简称为 FILO（Fist in,Last out）。
 * 插入的操作叫做进栈、压栈、入栈，push() ，
 * 去除操作叫做出栈、弹栈，pop()
 * 获取第一个元素叫做 peek()
 *
 * @author mumu
 * @date 2021-5-20 10:00
 */
public class ArrayStack<E> {

    private Array<E> data;

    public ArrayStack() {
        data = new Array<E>();
    }

    public ArrayStack(int capacity) {
        data = new Array<E>(capacity);
    }

    /**
     * 获取栈的大小
     *
     * @return int
     */
    public int getSize() {
        return data.getSize();
    }

    /**
     * stack is empty
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * clear stack
     */
    public void clear() {
        data.clear();
    }

    /**
     * peek the first element
     *
     * @return {@link E}
     */
    public E peek() {
        return data.getLast();
    }

    /**
     * push into element in the stack at first
     *
     * @param e e
     */
    public void push(E e) {
        data.addLast(e);
    }

    /**
     * pop first element
     *
     * @return {@link E}
     */
    public E pop() {
        return data.removeLast();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Stack ").append(" [");
        for (int i = 0; i < data.getSize(); i++) {
            sb.append(data.get(i));
            if(data.getSize() -1 != i){
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }



    public static void main(String[] args) {
        ArrayStack<Object> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.peek());

        stack.push(2);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack);
    }

}
