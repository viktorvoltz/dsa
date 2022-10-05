

class Main {
    public static void main(String[] args) {
        // System.out.println("Hello world!");
        List l = new List();
        l.printSomething();
        l.add(3);
        l.add(3);
        l.add(3);
        l.add(3);
        l.add(3);
        l.add(14);
        l.add(15);
        l.add(16);
        l.add(14);
        l.add(15);
        l.add(16);
        l.add(1, 15);
        l.remove(6);

        System.out.println(l);
    }
}

class List {

    int[] internal;
    double threshold;
    int pos;

    public List() {
        this.internal = new int[10];
        this.threshold = 0.8;
        this.pos = 0;
    }

    /*
     * add(e): insert item e at the end of the list
     * add(n, e): insert item e at index n
     * remove(n): remove the item at index n
     * get(n):
     */
    public void add(int num) {
        // check if array is full
        // if it is full, create new arry and copy
        // array is not full
        if (isAtThreshold()) {
            createAndCopyToBiggerArray();
        }

        internal[pos] = num;
        pos++;
    }

    public void add(int idx, int num) {
        if (isAtThreshold()) {
            createAndCopyToBiggerArray();
        }

        if (idx > pos) {
            return;
        }

        // shift values
        // idx - pos
        for (int i = pos - 1; i >= idx; i--) {
            this.internal[i + 1] = this.internal[i];
        }

        this.internal[idx] = num;
    }

    public int remove(int index) {

        int[] copy = new int[this.internal.length];

        for(int i = index; i < this.internal.length - 1; i++){
            this.internal[i] = this.internal[i+1];
        }

        pos--;

        for(int j = 0; j < pos; j++){
            copy[j] = this.internal[j];
        }

        this.internal = copy;

        return index;
    }

    public int get(int idx) {
        return 0;
    }

    private void createAndCopyToBiggerArray() {
        int currLen = this.internal.length;
        int[] biggerArray = new int[currLen * 2];

        for (int i = 0; i < currLen; i++) {
            biggerArray[i] = this.internal[i];
        }

        this.internal = biggerArray;
    }

    private boolean isAtThreshold() {
        int count = pos + 1;
        int len = internal.length;

        // 80 / 100 = 0.8
        return (double) count >= (this.threshold * ((double) len));
    }

    public void printSomething() {
        System.out.println("Something");
    }

    public String toString() {
        String list = "{";
        for (int i = 0; i < pos; i++) {
            list += this.internal[i];
            if (i != pos - 1) {
                list += ", ";
            }
        }
        list += "}";

        return list;
    }
}
