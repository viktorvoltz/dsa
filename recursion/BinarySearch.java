
class BinarySearch {

    public static boolean binarySearchIterative(int[] data, int target) {
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == data[mid])
                return true;
            else if (target < data[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }

    public static boolean binarySearch(int[] data, int target, int low, int high) {
        if (low > high) {
            return false;
        } else {
            int mid = (low + high) / 2;
            if (target == data[mid]) {
                return true;
            } else if (target < data[mid]) {
                return binarySearch(data, target, low, mid - 1);
            } else {
                return binarySearch(data, target, mid + 1, high);
            }
        }
    }

    public static void main(String[] args) {
        int LENGTH = 500;
        int[] data = new int[LENGTH];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
        long start = System.currentTimeMillis();
        boolean result = binarySearch(data, 300, 0, data.length - 1);
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.println(result + " in:: " + elapsed);
    }
}