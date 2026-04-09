package ListaLineares;

class Stack<T> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int size;


    public Stack() {
        top = null;
        size = 0;
    }


    public void push(T e) {
        Node newNode = new Node(e);
        newNode.next = top;
        top = newNode;
        size++;
    }


    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("ListaLineares.Stack vazia");
        }
        T value = top.data;
        top = top.next;
        size--;
        return value;
    }


    public T top() {
        if (isEmpty()) {
            throw new RuntimeException("ListaLineares.Stack vazia");
        }
        return top.data;
    }


    public boolean isEmpty() {
        return top == null;
    }


    public int size() {
        return size;
    }


    public void clear() {
        top = null;
        size = 0;
    }


        public static void main(String[] args) {

            Stack<Integer> stack = new Stack<>();

            System.out.println("Pilha vazia? " + stack.isEmpty());


            stack.push(10);
            stack.push(20);
            stack.push(30);

            System.out.println("Topo: " + stack.top()); // 30
            System.out.println("Tamanho: " + stack.size()); // 3


            System.out.println("Removido: " + stack.pop()); // 30
            System.out.println("Novo topo: " + stack.top()); // 20
            System.out.println("Tamanho: " + stack.size()); // 2


            stack.push(40);
            System.out.println("Topo após push: " + stack.top()); // 40


            while (!stack.isEmpty()) {
                System.out.println("Removendo: " + stack.pop());
            }

            System.out.println("Pilha vazia? " + stack.isEmpty());


            try {
                stack.pop();
            } catch (RuntimeException e) {
                System.out.println("Erro esperado: " + e.getMessage());
            }


            stack.push(100);
            stack.push(200);
            stack.clear();

            System.out.println("Após clear, tamanho: " + stack.size());
            System.out.println("Pilha vazia? " + stack.isEmpty());
        }
    }
