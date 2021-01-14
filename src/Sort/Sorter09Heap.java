package Sort;

import Heap.BinaryHeapPrac;

import java.util.List;

public class Sorter09Heap implements Sorter {
    private BinaryHeapPrac heap;
    public Sorter09Heap(BinaryHeapPrac heap) {
        this.heap = heap;
    }

    @Override
    public List<Integer> sort(List<Integer> array) {
        heap.buildHeap(array);
        int size = array.size();
        for(int i=0;i<array.size();i++) {
            heap.swap(array, 0, size-1-i);
            heap.decLimit();
            heap.maxHeapify(array, 0);
        }
        return array;
    }

    public static void main(String[] args) {
        TestPerformance test = new TestPerformance(new Sorter09Heap(new BinaryHeapPrac()));
        test.test();
    }
}
