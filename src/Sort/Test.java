package Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        ArrayList<Integer> l2 = (ArrayList<Integer>) l;
        ArrayList<Integer> l3 = new ArrayList<>();
        LinkedList<Integer> l4 = new LinkedList<>();
        System.out.println("l == l2? "+(l == l2));
        System.out.println("l == l3? "+(l == l3));
        l3.add(4);
        l4.add(4);
        System.out.println("l3.equals(l4)?"+l3.equals(l4));
    }
}
