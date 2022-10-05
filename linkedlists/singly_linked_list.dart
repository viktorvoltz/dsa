class Node<T> {
  T _element;
  Node<T>? _next;

  Node(this._element, this._next);

  T getElement() {
    return _element;
  }

  Node<T>? getNext() {
    return _next;
  }

  void setNext(Node<T>? n) {
    _next = n;
  }
}

class SinglyLinkedList<T> extends Node<T> {
  SinglyLinkedList(T element, Node<T> next) : super(element, next);

  int size = 0;
  Node<T>? head, tail = null;

  int getSize() {
    return size;
  }

  // check is size of list is empty
  bool isEmpty() {
    return size == 0;
  }

  T? first() {
    if (isEmpty()) return null;
    return head!.getElement();
  }

  T? last() {
    if (isEmpty()) return null;
    return tail!.getElement();
  }

  void addFirst(T element) {
    Node<T> newHead = Node<T>(element, head);
    if (isEmpty()) {
      tail = head;
    } else {
      newHead.setNext(head);
      head = newHead;
    }
    size++;
  }

  void addLast(T element) {
    Node<T> newTail = new Node<T>(element, null);
    if (isEmpty()) {
      head = newTail;
    } else {
      tail!.setNext(newTail);
    }
    tail = newTail;
    size += 1;
  }

  T? removeFirst() {
    if (isEmpty()) {
      return null;
    }
    T nextHead = head!.getElement();
    head = head!.getNext();
    size -= 1;
    if (isEmpty()) {
      tail = null;
    }
    return nextHead;
  }
}
