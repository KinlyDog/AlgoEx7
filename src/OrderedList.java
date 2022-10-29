import java.util.ArrayList;

class Node<T> {
    public T value;
    public Node<T> next;
    public Node<T> prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head;
    public Node<T> tail;
    private boolean _ascending;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {

        return 0;
    }

    public void add(T value) {

    }

    public Node<T> find(T val) {

        return null;
    }

    public void delete(T val) {

    }

    public void clear(boolean asc) {
        _ascending = asc;


    }

    public int count() {

        return 0;
    }

    ArrayList<Node<T>> getAll() {
        ArrayList<Node<T>> r = new ArrayList<>();
        Node<T> node = head;

        while (node != null) {
            r.add(node);
            node = node.next;
        }

        return r;
    }

    public static void main(String[] args) {
        OrderedList list = new OrderedList(true);

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

    }

}
