package Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class Sorter02Merge {
    public static LinkedList<Integer> sort(List<Integer> list1, List<Integer> list2) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Integer> temp1 = (LinkedList<Integer>)list1;
        LinkedList<Integer> temp2 = (LinkedList<Integer>)list2;
        LinkedList<Integer> temp3 = temp1.getLast() > temp2.getLast()?temp2:temp1;
        int i;
        while (!temp3.isEmpty()) {
            i = temp1.getFirst() <= temp2.getFirst()?temp1.poll():temp2.poll();
            result.add(i);
        }
        if (temp1.isEmpty()) {
            result.addAll(temp2);
        }
        else {
            result.addAll(temp1);
        }
        return result;
    }

    public static void test() {
        ListGenerator generator = new ListGenerator();
        LinkedList<Integer> testList1 = (LinkedList<Integer>)generator.getArray(10000, true);
        LinkedList<Integer> testList2 = (LinkedList<Integer>)generator.getArray(10000, true);
        LinkedList<Integer> temp = new LinkedList<>();
        temp.addAll(testList1);
        temp.addAll(testList2);
        testList1.sort(null);
        testList2.sort(null);
        long start = System.currentTimeMillis();
        LinkedList<Integer>result = Sorter02Merge.sort(testList1, testList2);
        System.out.println("Cost time " + (System.currentTimeMillis()-start) + "millis.");
        // display(testList);
        List<Integer> show = result.subList(0, 20);
        TestPerformance.display(show);
        temp.sort(null);
        if (temp.equals(result)) {
            System.out.println("Sorted correctly!");
        }
        else {
            System.out.println("Sorted wrongly!");
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>(),l2 = new LinkedList<>();
        l1.add(3);
        l2.add(1);
        l2.add(2);
        l1.addAll(l2);
        System.out.println(l1);
        Sorter02Merge.test();
    }
}
