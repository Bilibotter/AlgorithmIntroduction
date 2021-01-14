package Heap;

import java.util.List;

public class BinaryHeapPrac {
    private int heapLimit;

    public void decLimit() {
        heapLimit--;
    }

    public void buildHeap(List<Integer> array) {
        heapLimit = array.size()-1;
        for (int leaf = heapLimit/2;leaf >= 0;leaf--) {
            maxHeapify(array, leaf);
        }
    }

    public void maxHeapify(List<Integer> array, int i) {
        int left = 2 * i, index=i, max=array.get(i);
        if (left > heapLimit) {
            return;
        }
        else {
            index = array.get(left) > max?left:index;
        }
        int right = left+1;
        if (right <= heapLimit) {
            index = array.get(right) > array.get(index)?right:index;
        }
        if (index!=i) {
            swap(array, index, i);
            maxHeapify(array, index);
        }
    }

    public void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
