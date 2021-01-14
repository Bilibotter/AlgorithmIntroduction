package Tree;

import Sort.ListGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BinarySearch {
    public static int search(List<Integer> list, int key) {
        if (key < list.get(0) || key > list.get(list.size()-1)) {
            return -1;
        }
        int left=0, right=list.size()-1;
        int pivot, num;
        while (left <= right) {
            pivot = (right + left) / 2;
            num = list.get(pivot);
            if (key == num) {
                return pivot;
            }
            else if (key < num) {
                right = pivot-1;
            }
            else {
                left = pivot+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ListGenerator generator = new ListGenerator();
        List<Integer> list = generator.getArray(100000);
        generator.setMaximum(10000000);
        HashSet<Integer> set = new HashSet<>(list);
        list = new ArrayList<Integer>(set);
        list.sort(null);
        int num;
        for (int i=0;i<list.size();i++) {
            num = list.get(i);
            if (BinarySearch.search(list, num) != list.indexOf(num)) {
                System.out.println("Search wrongly in "+i);
            }
        }
        System.out.println(BinarySearch.search(list, list.get(13)));
    }
}
