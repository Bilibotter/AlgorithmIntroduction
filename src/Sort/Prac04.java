package Sort;

import java.util.ArrayList;
import java.util.List;

public class Prac04 implements Sorter{
    @Override
    public List<Integer> sort(List<Integer> array) {
        ArrayList<Integer> result = (ArrayList<Integer>) array;
        int left, right, size = result.size();
        boolean flag = true;
        for(int exclude=1;exclude<size;exclude++) {
            flag = true;
            for(int index=0;index<size-exclude;index++) {
                left = result.get(index);
                right = result.get(index+1);
                if (left > right) {
                    result.set(index, right);
                    result.set(index+1, left);
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
        TestPerformance test = new TestPerformance(new Prac04());
        test.test();
    }
}
