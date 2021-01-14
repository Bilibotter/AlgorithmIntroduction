package Sort;

import java.util.ArrayList;
import java.util.List;

public class Sorter04Bubble implements Sorter {
    @Override
    public List<Integer> sort(List<Integer> array) {
        ArrayList<Integer> result = (ArrayList<Integer>) array;
        int size = array.size(), left, right;
        boolean flag;
        for(int i = 1; i< size; i++) {
            flag = true;
            for (int j = 0; j< size -i; j++) {
                left = result.get(j);
                right = result.get(j+1);
                if (left>right) {
                    result.set(j, right);
                    result.set(j+1, left);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TestPerformance test = new TestPerformance(new Sorter04Bubble());
        test.test();
    }
}
