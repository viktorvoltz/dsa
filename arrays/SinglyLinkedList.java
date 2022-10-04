package arrays;

public class SinglyLinkedList<T> {
    // Node
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

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T first() {
        if (isEmpty()) {
            return null;
        } else {
            return head.getElement();
        }
    }

    public T last() {
        if (isEmpty()) {
            return null;
        } else {
            return tail.getElement();
        }
    }
}