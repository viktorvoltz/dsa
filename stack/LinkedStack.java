package stack;

public class LinkedStack<T> implements Stack<T> {
    private SinglyLinkedList<T> list = new SinglyLinkedList<T>();

    public LinkedStack() {
    }

    @Override
    public int size() {
        return list.size();
        
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(T e) {
        list.addFirst(e);

    }

    @Override
    public T top() {
        return list.first();
    }

    @Override
    public T pop() {
        return list.removeFirst();
    }

}
