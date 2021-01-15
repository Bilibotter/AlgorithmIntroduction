package Heap;

import java.util.List;

public class PracHeap {
    private int heapLimit;

    public int getHeapLimit() {
        return heapLimit;
    }

    public void decLimit() {
        heapLimit--;
    }

    int parent(int i) {
        return i / 2;
    }

    int left(int i) {
        return 2 * i;
    }

    int right(int i) {
        return 2 * i + 1;
    }

    public void buildHeap(List<Integer> list) {
        heapLimit = list.size() - 1;
        // 不是叶子结点！
        for (int i=heapLimit/2;i>=0;i--) {
            maxHeapify(list, i);
        }
    }

    public void maxHeapify(List<Integer> list, int index) {
        int position = index;
        int l = left(index);
        if (l <= heapLimit) {
            position = list.get(l) > list.get(index) ? l:index;
        }
        else {
            return;
        }
        int r = right(index);
        if (r <= heapLimit) {
            position = list.get(position) > list.get(r) ? position:r;
        }
        if (index != position) {
            swap(list, index, position);
            maxHeapify(list, position);
        }
    }

    public void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
