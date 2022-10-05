/**
 * @author viktorvoltz
 */

public class ReverseArray {
    public static void reverse(int[] data) {
        int low = 0, high = data.length - 1;
        while (low < high) {
            int temp = data[low];
            data[low++] = data[high];
            data[high--] = temp;
        }

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public static void main(String[] args) {
        int[] foo = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
        reverse(foo);
    }
}