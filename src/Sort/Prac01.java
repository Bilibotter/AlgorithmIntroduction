package Sort;

import java.util.ArrayList;
import java.util.List;

public class Prac01 implements Sorter{
    @Override
    public List<Integer> sort(List<Integer> array) {
        if (array == null || array.size() <= 1) {
            return array;
        }
        ArrayList<Integer> result = (ArrayList<Integer>) array;
        int unsorted = 1, end=array.size(), sorted, current, num;
        while (unsorted < end) {
            current = result.get(unsorted);
            sorted = unsorted - 1;
            while (sorted >= 0) {
                num = result.get(sorted);
                if (num > current) {
                    result.set(sorted+1, num);
                    sorted--;
                }
                else {
                    break;
                }
            }
            result.set(sorted+1, current);
            unsorted++;
        }
        return result;
    }

    public static void main(String[] args) {
        TestPerformance test = new TestPerformance(new Prac01());
        test.test();
    }
}
