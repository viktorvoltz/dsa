package stack;

public interface Stack<T> {
    int size();
    boolean isEmpty();
    void push(T e);
    T top();
    T pop();
}
