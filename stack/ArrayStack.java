package stack;

public class ArrayStack<T> implements Stack<T> {
    public static final int CAPACITY = 100;
    private T[] data;
    private int t = -1;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        data = (T[]) new Object[capacity];
    }

    @Override
    public int size() {
        return t + 1;
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public void push(T e) throws IllegalStateException{
        if(size() == data.length) throw new IllegalStateException("stack is full");
        data[++t] = e;
    }

    @Override
    public T top() {
        if (isEmpty())return null;
        return data[t];
    }

    @Override
    public T pop() {
       if (isEmpty()) return null;
       T answer = data[t];
       data[t] = null;
       t--;
       return answer;
    }

}
