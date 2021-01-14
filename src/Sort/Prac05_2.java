package Sort;

import java.util.List;

public class Prac05_2 implements Sorter {

    @Override
    public List<Integer> sort(List<Integer> array) {
        quickSort(array, 0, array.size()-1);
        return array;
    }

    void quickSort(List<Integer> array, int left, int right) {
        int position;
        if (left < right) {
            position = partition(array, left, right);
            quickSort(array, left, position-1);
            quickSort(array, position+1, right);
        }
    }

    int partition(List<Integer> array, int left, int right) {
        int pivot = array.get(right), position=left, num=pivot;
        for (int i=left;i<right;i++) {
            num = array.get(i);
            if (num < pivot) {
                swap(array, position, i);
                position++;
            }
        }
        swap(array, position, right);
        return position;
    }

    void swap(List<Integer> array, int i, int j) {
        if(i == j) {
            return;
        }
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    public static void main(String[] args) {
        TestPerformance test = new TestPerformance(new Prac05_2());
        test.test();
    }
}
