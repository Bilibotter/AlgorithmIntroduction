package Sort;

import java.util.List;

public class Prac05_1 implements Sorter {

    @Override
    public List<Integer> sort(List<Integer> array) {
        this.quickSort(array, 0, array.size()-1);
        return array;
    }

    void quickSort(List<Integer> array, int left, int right) {
        if (left<right) {
            int position = randomPartition(array, left, right);
            quickSort(array, left, position-1);
            quickSort(array, position+1, right);
        }
    }

    int randomPartition(List<Integer> array, int left, int right) {
        int pivotPosition = (int) Math.round(left+(right-left)*Math.random());
        swap(array, left, pivotPosition);
        int pivot = array.get(left), position=left, num;
        for(int index=left+1;index<right+1;index++) {
            num = array.get(index);
            if (num<pivot) {
                position++;
                swap(array, position, index);
            }
        }
        swap(array, left, position);
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
        TestPerformance test = new TestPerformance(new Prac05_1());
        test.test();
    }
}
