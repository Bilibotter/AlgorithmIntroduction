package Sort;

import java.util.List;

public class Sorter06Select implements Sorter {
    @Override
    public List<Integer> sort(List<Integer> array) {
        int size = array.size(), num, max, index;
        for (int i=0;i<size;i++) {
            index = -1;
            max = -Integer.MAX_VALUE;
            for (int j=0;j<size-i;j++) {
                num = array.get(j);
                if (num > max) {
                    max = num;
                    index = j;
                }
            }
            if (index >= 0) {
                swap(array, index, size-i-1);
            }
        }
        return array;
    }

    void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    public static void main(String[] args) {
        TestPerformance test = new TestPerformance(new Sorter06Select());
        test.test();
    }
}
