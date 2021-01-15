package Sort;

import java.util.LinkedList;
import java.util.List;

public class Sorter05QuickIterative implements Sorter {

    @Override
    public List<Integer> sort(List<Integer> array) {
        if (array == null || array.size() <= 1) {
            return array;
        }
        int left=0, right=array.size()-1;
        int position = partition(array, left, right);
        LinkedList<Integer> queue = new LinkedList<>();
        push(queue, left, position-1);
        push(queue, position+1, right);
        while (!queue.isEmpty()) {
            left = queue.pop();
            right = queue.pop();
            position = partition(array, left, right);
            push(queue, left, position-1);
            push(queue, position+1, right);
        }
        return array;
    }

    void push(LinkedList<Integer> queue, int left, int right) {
        if (right > left) {
            queue.add(left);
            queue.add(right);
        }
    }

    int partition(List<Integer> list, int left, int right) {
        int num = list.get(right), position = left;
        for(int i=left;i<right;i++) {
            if (list.get(i) < num) {
                swap(list, position, i);
                position++;
            }
        }
        swap(list, position, right);
        return position;
    }

    void swap(List<Integer> list, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        TestPerformance test = new TestPerformance(new Sorter05QuickIterative());
        test.test();
    }
}
