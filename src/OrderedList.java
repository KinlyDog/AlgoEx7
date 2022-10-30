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
        if (v1 instanceof String) {
            return v1.toString().trim().compareTo(v2.toString().trim());
        }

        return Integer.compare((int) v1, (int) v2);
    }

    public void add(T value) {
        Node<T> item = new Node<>(value);

        if (_ascending) {
            addAsc(item);
            return;
        }

        addDesc(item);
    }

    public void addAsc(Node<T> item) {
        if (head == null || compare(head.value, item.value) >= 0) {
            insertFirst(item);
            return;
        }

        if (compare(tail.value, item.value) <= 0) {
            insertLast(item);
            return;
        }

        Node<T> node = head;

        while (node != null && compare(node.value, item.value) < 0) {
            node = node.next;
        }

        insert(item, node);
    }

    public void addDesc(Node<T> item) {
        if (head == null || compare(head.value, item.value) <= 0) {
            insertFirst(item);
            return;
        }

        if (compare(tail.value, item.value) >= 0) {
            insertLast(item);
            return;
        }

        Node<T> node = head;

        while (node != null && compare(node.value, item.value) > 0) {
            node = node.next;
        }

        insert(item, node);
    }

    public void insert(Node<T> item, Node<T> node) {
        item.prev = node.prev;
        item.next = node;

        node.prev.next = item;
        node.prev = item;
    }

    public void insertFirst(Node<T> _nodeToInsert) {
        if (head == null) {
            head = _nodeToInsert;
            tail = _nodeToInsert;

            return;
        }

        _nodeToInsert.next = head;
        head.prev = _nodeToInsert;
        head = _nodeToInsert;
    }

    public void insertLast(Node<T> _item) {
        if (head == null) {
            head = _item;
        } else {
            tail.next = _item;
            _item.prev = tail;
        }

        tail = _item;
    }

    // ok
    public Node<T> find(T val) {
        if (head == null) {
            return null;
        }

        Node<T> node = head;

        int compHead = compare(head.value, val);
        int compTail = compare(tail.value, val);

        if (_ascending && (compHead > 0 || compTail < 0)) {
            return null;
        }

        if (!_ascending && (compHead < 0 || compTail > 0)) {
            return null;
        }

        while (_ascending && node != null && compare(node.value, val) < 0) {
            node = node.next;
        }

        while (!_ascending && node != null && compare(node.value, val) > 0) {
            node = node.next;
        }

        if (node.value == val) {
            return node;
        }

        return null;
    }

    // ok
    public boolean delete(T val) {
        if (find(val) == null) {
            return false;
        }

        Node<T> node = head;

        if (node.next == null) {
            clear(_ascending);
            return true;
        }

        if (head.value == val) {
            head = node.next;
            head.prev = null;
            node.next = null;

            return true;
        }

        while (node.value != val) {
            node = node.next;
        }

        if (node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.prev = null;
            node.next = null;

            return true;
        }

        tail = node.prev;
        tail.next = null;
        node.prev = null;

        return true;
    }

    public void clear(boolean asc) {
        head = null;
        tail = null;

        _ascending = asc;
    }

    // ok
    public int count() {
        if (head == null) {
            return 0;
        }

        Node<T> node = head;
        int c = 0;

        while (node != null) {
            c++;
            node = node.next;
        }

        return c;
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
}
