import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Objects;

public class ArrayList {
    String[] data;
    int capacity;

    public ArrayList(int capacity) {
        this.capacity = capacity;
        this.data = new String[capacity];
    }



    public void add(String value) {
        for (int i = 0; i < capacity; i++) {
            if (data[i] == null) {
                data[i] = value;
                return;
            }
        }
    }

    public void remove(String value){
        for (int i = 0; i < capacity; i++){
            if (Objects.equals(data[i], value)){
                data[i] = null;
                return;
            }
        }
    }

    public boolean contains(String value) {
        for (int i = 0; i < capacity; i++) {
            if (Objects.equals(data[i], value)) {
                return true;
            }
        }
        return false;
    }

    public String[] toArray() {
        return data;
    }

    public int indexOf(String value) {
        for (int i = 0; i < capacity; i++) {
            if (Objects.equals(data[i], value)) {
                return i;
            }
        }
        return -1;
    }

    public get(int index){
        for (int i = 0; i < capacity; i++){
            if (Objects.equals(data[i],value)){
                return
            }
        }


    }



    public static void main(String[] args) {
        ArrayList list = new ArrayList(10);

        list.add("A");
        list.add("B");
        list.add("C");
        list.remove("A");
        list.contains("A");
        list.indexOf("A");

        //System.out.println(list.indexOf("C"));

        System.out.println(Arrays.toString(list.toArray()));

       // for (int i = 0; i < list.capacity; i++) {
         //   System.out.println(list.data[i]);
        //}
    }
}