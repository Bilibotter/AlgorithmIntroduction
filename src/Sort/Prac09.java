package Sort;

import Heap.BinaryHeapPrac;
import Heap.PracHeap;

import java.util.List;

public class Prac09 implements Sorter {

    private PracHeap heap;
    public Prac09(PracHeap heap) {
        this.heap = heap;
    }

    @Override
    public List<Integer> sort(List<Integer> array) {
        heap.buildHeap(array);
        for (int i=0;i<array.size();i++) {
            heap.swap(array, 0, heap.getHeapLimit());
            heap.decLimit();
            heap.maxHeapify(array, 0);
        }
        return array;
    }

    public static void main(String[] args) {
        TestPerformance test = new TestPerformance(new Prac09(new PracHeap()));
        test.test();
    }
}
