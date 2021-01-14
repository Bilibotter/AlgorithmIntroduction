package Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestPerformance implements Sorter{

    private static ListGenerator generator;

    private Sorter sorter;

    private LinkedList linkedList;

    private static int wrapRow=10;

    private int listLength;

    static {
        generator = new ListGenerator();
    }

    public TestPerformance(Sorter sorter) {
        this.listLength = 10000;
        this.sorter = sorter;
    }


    public static void setGenerator(ListGenerator generator) {
        TestPerformance.generator = generator;
    }

    public static void setWrapRow(int wrapRow) {
        TestPerformance.wrapRow = wrapRow;
    }

    public static ListGenerator getGenerator() {
        return generator;
    }

    public void setListLength(int listLength) {
        this.listLength = listLength;
    }

    public void test() {
        List<Integer> testList = generator.getArray(listLength, false);
        List<Integer> temp = new ArrayList<>(testList);
        long start = System.currentTimeMillis();
        testList = this.sort(testList);
        System.out.println("Cost time " + (System.currentTimeMillis()-start) + "millis.");
        // display(testList);
        List<Integer> show = testList.subList(0, 20);
        display(show);
        temp.sort(null);
        if (temp.equals(testList)) {
            System.out.println("Sorted correctly!");
        }
        else {
            System.out.println("Sorted wrongly!");
        }
    }

    @Override
    public List<Integer> sort(List<Integer> l) {
        return sorter.sort(l);
    }

    static void display(List<Integer> list) {
        if(list == null || list.size()==0) {
            System.out.println("[]");
            return;
        }
        ArrayList<Integer> temp = new ArrayList<Integer>(list);
        int wrapCounter = 0;
        int end = temp.remove(temp.size()-1);
        System.out.print("[");
        for(int i: temp) {
            wrapCounter += 1;
            System.out.print(i+", ");
            if (wrapCounter == wrapRow) {
                System.out.println();
                wrapCounter = 0;
            }
        }
        System.out.println(end + "]");
    }
}
