public class ArrayList<T> {

    private T[] data;
    private int size;
    private int capacity;


    public ArrayList() {
        this(10);
    }


    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }


    @SuppressWarnings("unchecked")
    private void resize() {
        capacity = capacity * 2;
        T[] newData = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }


    public void add(T e) {
        if (size == capacity) {
            resize();
        }
        data[size] = e;
        size++;
    }


    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new RuntimeException("Indice invalido");
        }

        if (size == capacity) {
            resize();
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = e;
        size++;
    }


    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Indice invalido");
        }

        T removed = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;

        return removed;
    }


    public boolean remove(T o) {
        int index = indexOf(o);
        if (index == -1) return false;
        remove(index);
        return true;
    }


    public void set(int index, T e) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Indice invalido");
        }
        data[index] = e;
    }


    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Indice invalido");
        }
        return data[index];
    }


    public boolean contains(T o) {
        return indexOf(o) != -1;
    }


    public int indexOf(T o) {
        for (int i = 0; i < size; i++) {
            if (equals(data[i], o)) {
                return i;
            }
        }
        return -1;
    }


    private boolean equals(T a, T b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.equals(b);
    }


    public Object[] toArray() {
        Object[] result = new Object[size];

        for (int i = 0; i < size; i++) {
            result[i] = data[i];
        }

        return result;
    }


    public int size() {
        return size;
    }


    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>(2);

        System.out.println("== Teste add ==");
        list.add("A");
        list.add("B");
        list.add("C"); // resize
        printList(list);

        System.out.println("\n== Teste add(index, e) ==");
        list.add(1, "X");
        printList(list);

        System.out.println("\n== Teste get ==");
        System.out.println("Elemento no índice 1: " + list.get(1));

        System.out.println("\n== Teste set ==");
        list.set(1, "Y");
        printList(list);

        System.out.println("\n== Teste contains ==");
        System.out.println("Contém A? " + list.contains("A"));
        System.out.println("Contém Z? " + list.contains("Z"));

        System.out.println("\n== Teste indexOf ==");
        System.out.println("Index de C: " + list.indexOf("C"));
        System.out.println("Index de Z: " + list.indexOf("Z"));

        System.out.println("\n== Teste remove(index) ==");
        list.remove(1);
        printList(list);

        System.out.println("\n== Teste remove(obj) ==");
        list.remove("C");
        printList(list);

        System.out.println("\n== Teste toArray ==");
        Object[] array = list.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println("array[" + i + "] = " + array[i]);
        }

        System.out.println("\n== Teste size ==");
        System.out.println("Tamanho: " + list.size());

        System.out.println("\n== Teste erro ==");
        try {
            list.get(100);
        } catch (RuntimeException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }

    // Método auxiliar
    public static void printList(ArrayList<String> list) {
        System.out.println("Lista (size=" + list.size() + "):");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("[" + i + "] = " + list.get(i));
        }
    }
}