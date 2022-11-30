package stack;

public class ReverseArray {
    public static <T> void reverse(T[] array){
        Stack<T> buffer = new ArrayStack<>(array.length);
        for (int i = 0; i < array.length; i++){
            buffer.push(array[i]);
        }
        for (int i = 0; i < array.length; i++){
            array[i] = buffer.pop();
        }
    }
}
