package Heap;

import Sort.Sorter;
import Sort.TestPerformance;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap implements Sorter {

    private int heapLimit;

    int parent(int i) {
        return i / 2;
    }

    int left(int i) {
        return 2 * i;
    }

    int right(int i) {
        return 2 * i + 1;
    }

    @Override
    public List<Integer> sort(List<Integer> array) {
        buildMaxHeap(array);
        for(int i=array.size()-1;i>=0;i--) {
            swap(array,0, i);
            heapLimit -= 1;
            maxHeapify(array, 0);
        }
        return array;
    }

    void buildMaxHeap(List<Integer> array) {
        this.heapLimit = array.size()-1;
        for (int i = array.size()/2;i>=0;i--) {
            maxHeapify(array, i);
        }
    }

    void maxHeapify(List<Integer> array,int i){
        int l = left(i), r = right(i), index=i;
        if (l <= heapLimit) {
            index = array.get(i) > array.get(l) ? i:l;
        }
        else {
            return;
        }
        if (r <= heapLimit) {
            index = array.get(index) > array.get(r) ? index:r;
        }
        if (index != i) {
            swap(array, index, i);
            maxHeapify(array, index);
        }
    }

    public void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    public static void main(String[] args) {
        TestPerformance test = new TestPerformance(new BinaryHeap());
        test.test();
    }
}
