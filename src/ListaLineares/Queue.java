package ListaLineares;

public class Queue<T> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node first;
    private Node top;
    private int size;

    public Queue() {
        first = null;
        top = null;
        size = 0;
    }

    public void enqueue(T e) {
        Node newNode = new Node(e);

        if (isEmpty()) {
            first = newNode;
            top = newNode;
        } else {
            top.next = newNode;
            top = newNode;
        }

        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia");
        }

        T value = first.data;
        first = first.next;

        if (first == null) {
            top = null;
        }

        size--;
        return value;
    }

    public T front() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia");
        }
        return first.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        first = null;
        top = null;
        size = 0;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node current = first;

        int i = 0;
        while (current != null) {
            arr[i++] = current.data;
            current = current.next;
        }

        return arr;
    }

    public String toString() {
        String result = "[";
        Node current = first;

        while (current != null) {
            result += current.data;
            if (current.next != null) {
                result += ", ";
            }
            current = current.next;
        }

        result += "]";
        return result;
    }

    public static void main(String[] args) {

        Queue<Integer> q = new Queue<>();

        System.out.println("Fila vazia? " + q.isEmpty());

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Fila: " + q.toString());
        System.out.println("Front: " + q.front());
        System.out.println("Size: " + q.size());

        System.out.println("Removido: " + q.dequeue());
        System.out.println("Fila: " + q.toString());

        q.enqueue(40);
        System.out.println("Fila após enqueue: " + q.toString());

        Object[] arr = q.toArray();
        System.out.println("Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        while (!q.isEmpty()) {
            System.out.println("Removendo: " + q.dequeue());
        }

        System.out.println("Fila vazia? " + q.isEmpty());

        try {
            q.dequeue();
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        q.enqueue(100);
        q.enqueue(200);
        q.clear();

        System.out.println("Após clear: " + q.toString());
        System.out.println("Size: " + q.size());
    }
}