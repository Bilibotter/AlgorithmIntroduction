package Sort;

import java.util.Arrays;
import java.util.List;

public class Sorter05Quick implements Sorter {

    @Override
    public List<Integer> sort(List<Integer> array) {
        quickSort(array, 0, array.size()-1);
        return array;
    }

    void quickSort(List<Integer> array, int left, int right) {
        if (left < right) {
            int pivot = this.partition(array, left, right);
            this.quickSort(array, left, pivot-1);
            this.quickSort(array, pivot+1, right);
        }
    }

    int partition(List<Integer> array, int left, int right) {
        int num, temp, swapPosition=left, pivot = array.get(right);
        for(int index=left;index<right;index++) {
            num = array.get(index);
            if (num < pivot) {
                temp = array.get(swapPosition);
                array.set(index, temp);
                array.set(swapPosition, num);
                swapPosition++;
            }
        }
        array.set(right, array.get(swapPosition));
        array.set(swapPosition, pivot);
        return swapPosition;
    }

    public static void main(String[] args) {
        TestPerformance test = new TestPerformance(new Sorter05Quick());
        test.test();
    }
}
