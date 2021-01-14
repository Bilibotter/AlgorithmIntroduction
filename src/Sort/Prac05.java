package Sort;

import java.util.List;

public class Prac05 implements Sorter {

    @Override
    public List<Integer> sort(List<Integer> array) {
        this.quickSort(array, 0, array.size()-1);
        return array;
    }

    void quickSort(List<Integer> array, int left, int right) {
        if (left<right) {
            int position = partition(array, left, right);
            quickSort(array, left, position-1);
            quickSort(array, position+1, right);
        }
    }

    int partition(List<Integer> array, int left, int right) {
        int pivot = array.get(right),insertPosition = left;
        for(int index=left;index<right;index++) {
            if (array.get(index) < pivot) {
                swap(array, index, insertPosition);
                insertPosition++;
            }
        }
        swap(array, insertPosition, right);
        return insertPosition;
    }

    void swap(List<Integer> array, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    public static void main(String[] args) {
        TestPerformance test = new TestPerformance(new Prac05());
        test.test();
    }
}
