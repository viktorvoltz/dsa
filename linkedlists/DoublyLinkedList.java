public class DoublyLinkedList<T> {
    private static class Node<T> {
        private T element;
        private Node<T> next;
        private Node<T> prev;

        public Node(T e, Node<T> p, Node<T> n) {
            element = e;
            prev = p;
            next = n;
        }

        public T getElement() {
            return element;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setPrev(Node<T> p) {
            prev = p;
        }

        public void setNext(Node<T> n) {
            next = n;
        }
    }

    public Node<T> header;
    public Node<T> trailer;
    private int size = 0;

    public DoublyLinkedList(){
        header = new Node<T>(null, null, null);
        trailer = new Node<T>(null, header, null);
        header.setNext(trailer);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public T first(){
        if(isEmpty()) return null;
        return header.getNext().element;
    }

    public T last(){
        if(isEmpty()) return null;
        return trailer.getPrev().element;
    }

    public void addFirst(T element){
        addBetween(element, header, header.getNext());
    }

    public void addLast(T element){
        addBetween(element, trailer.getPrev(), trailer);
    }

    public T removeFirst(){
        if(isEmpty()) return null;
        return remove(header.getNext());
    }

    public T removeLase(){
        if(isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    public void addBetween(T element, Node<T> predecessor, Node<T> successor){
        Node<T> newNode = new Node<T>(element, predecessor, successor);
        predecessor.setNext(newNode);
        successor.setPrev(newNode);
        size++;
    }

    public T remove(Node<T> node){
        Node<T> prev = node.getPrev();
        Node<T> next = node.getNext();
        prev.setNext(next);
        next.setNext(prev);
        size--;
        return node.getElement();
    }

}
