package top.mumudm.datastructure.array;

/**
 * 使用虚拟头结点的数组
 *
 * @author mumu
 * @date 2021-6-7 16:39
 */
public class LinkedArray<E> {

    /**
     * 数据
     */
    private final Node dummyHead;

    /**
     * 大小
     */
    private int size;

    /**
     * 清除数组所有元素
     */
    public void clear() {
        dummyHead.next = null;
        this.size = 0;
    }

    /**
     * 节点
     *
     * @author mumu
     * @date 2021/06/07
     */
    private class Node {
        private E data;
        private Node next;

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

    }

    public LinkedArray() {
        dummyHead = new Node();
        size = 0;
    }

    public LinkedArray(E e) {
        this.dummyHead = new Node();
        this.dummyHead.next = new Node(e);
        size = 1;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        // 正常逻辑
        // Node node = new Node<>(e);
        // node.next = head;
        // head = node;

        // 简化版    把元素添加到第一位，头放到下一位
        dummyHead.next = new Node(e, dummyHead.next);
        size++;
    }

    public void add(int index, E e) {
        checkIndex(index);

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }

        Node tmp = dummyHead;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        // 如果删除的是最后一个，直接置为空
        Node deleted = tmp.next;
        tmp.next = deleted.next;
        deleted.next = null;
        size--;
        return deleted.data;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        Node tmp = dummyHead;
        while (tmp.next != null) {
            if (tmp.next.data.equals(e)) {
                break;
            }
            tmp = tmp.next;
        }

        if (tmp.next != null) {
            Node deleted = tmp.next;
            tmp.next = deleted.next;
            deleted.next = null;
            size--;
        }

    }

    public E get(int index) {
        checkIndex(index);
        Node tmp = dummyHead;
        for (int i = 0; i <= index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public boolean contains(E e) {
        Node tmp = dummyHead;
        for (int i = 0; i < size; i++) {
            tmp = tmp.next;
            if (tmp.data.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }
        Node tmp = dummyHead.next;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        tmp.data = e;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append("[");
        Node tmp = dummyHead.next;
        while (tmp != null) {
            sb.append(tmp.data).append("->");
            tmp = tmp.next;
        }

        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedArray<Object> array = new LinkedArray<>();
        array.addFirst("A");
        array.addFirst("B");
        array.addFirst("C");
        System.out.println(array);
        array.addFirst(10);
        System.out.println(array);
        System.out.println(array.getSize());
        array.add(1, "T");
        System.out.println(array);
        System.out.println(array.getSize());
        array.addLast("L");
        System.out.println(array);
        System.out.println(array.getSize());
        System.out.println(array.remove(2));
        System.out.println(array);
        System.out.println(array.remove(4));
        System.out.println(array);
        array.add(4, "ttt");
        System.out.println(array);
        array.removeLast();
        System.out.println(array);
        System.out.println(array.get(0));
        System.out.println(array.get(1));
        System.out.println(array.get(2));
//        System.out.println(array.get(5));
        System.out.println("array.getFirst() = " + array.getFirst());
        System.out.println("array.getLast() = " + array.getLast());
        System.out.println("array.contains(\"T\") = " + array.contains("T"));
        System.out.println("array.contains(\"S\") = " + array.contains("S"));
        array.set(0, "set");
        System.out.println("array = " + array);
        array.removeElement("set");
        System.out.println("array.removeElement(\"set\") = ");
        System.out.println("array = " + array);
        array.removeElement("A");
        System.out.println("array.removeElement(\"A\") = ");
        System.out.println("array = " + array);
        array.clear();
        System.out.println("array = " + array);
    }

}
