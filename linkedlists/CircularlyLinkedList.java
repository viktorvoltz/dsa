

public class CircularlyLinkedList<T> {

    private static class Node<T> {
        private T element;
        private Node<T> next;

        public Node(T e, Node<T> n) {
            element = e;
            next = n;
        }

        public T getElement() {
            return element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> n) {
            next = n;
        }
    }

    private Node<T> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T first() {
        if (isEmpty())
            return null;
        return tail.getNext().getElement();
    }

    public T last() {
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    public void addFirst(T element) {
        if (isEmpty()) {
            tail = new Node<T>(element, null);
            tail.setNext(tail);
        } else {
            Node<T> newHead = new Node<T>(element, tail.getNext());
            tail.setNext(newHead);
        }
        size++;
    }

    public void addLast(T element) {
        addFirst(element);
        tail = tail.getNext();
    }

    public T removeFirst() {
        if (isEmpty())
            return null;
        Node<T> head = tail.getNext();
        if (head == tail)
            tail = null;
        else
            tail.setNext(head.getNext());
        size--;
        return head.getElement();
    }
}