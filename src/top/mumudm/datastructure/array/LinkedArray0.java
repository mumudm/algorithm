package top.mumudm.datastructure.array;

/**
 * @author mumu
 * @date 2021-6-7 16:39
 */
public class LinkedArray0<E> {

    /**
     * 数据
     */
    private Node<E> head;

    /**
     * 大小
     */
    private int size;

    /**
     * 节点
     *
     * @author mumu
     * @date 2021/06/07
     */
    private class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

    }

    public LinkedArray0() {
        head = null;
        size = 0;
    }

    public LinkedArray0(E e) {
        this.head = new Node<>(e);
        size = 1;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(E e) {
        // 正常逻辑
        // Node node = new Node<>(e);
        // node.next = head;
        // head = node;

        // 简化版    把元素添加到第一位，头放到下一位
        head = new Node<E>(e, head);
        size++;
    }

    public void add(int index, E e) {
        checkIndex(index);
        if(index == 0){
            addFirst(e);
        } else {
            Node pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            pre.next = new Node<>(e, pre.next);
            size++;
        }
    }

    public void addLast(E e){
       add(size, e);
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append("[");
        if (head.data != null) {
            Node tmp = head;
            sb.append(tmp.data);
            while (tmp.next != null) {
                tmp = tmp.next;
                sb.append(",");
                sb.append(tmp.data);
            }
        }

        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedArray0<Object> array = new LinkedArray0<>();
        array.addFirst("A");
        array.addFirst("B");
        array.addFirst("C");
        System.out.println(array);
        array.addFirst(10);
        System.out.println(array);
        System.out.println(array.getSize());
        array.add(1,"T");
        System.out.println(array);
        System.out.println(array.getSize());
        array.addLast("L");
        System.out.println(array);
        System.out.println(array.getSize());
    }

}
