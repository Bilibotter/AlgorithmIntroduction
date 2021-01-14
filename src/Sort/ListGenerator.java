package Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListGenerator {
    private int minimum;
    private int maximum;

    ListGenerator() {
        minimum = 0;
        maximum = 100000;
    }

    ListGenerator(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public int getMaximum() {
        return maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    List<Integer> getArray(int length) {
        return this.getArray(length, true);
    }

    List<Integer> getArray(int length, boolean usingLinked) {
        if (usingLinked) {
            LinkedList<Integer> array = new LinkedList<>();
        }
        else {
            ArrayList<Integer> array = new ArrayList<>();
        }
        List<Integer> array = usingLinked? new LinkedList<Integer>():new ArrayList<>();
        for (int i=0; i<length; i++) {
            int num = (int) (Math.random() * (maximum - minimum) + minimum);
            array.add(num);
        }
        return array;
    }

    public static void main(String[] args) {
        ListGenerator generator = new ListGenerator();
        List list = generator.getArray(100);
        System.out.println(list.size());
        TestPerformance.display(list);
    }
}
