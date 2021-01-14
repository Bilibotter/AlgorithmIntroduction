package Sort;

import java.util.ArrayList;
import java.util.List;

// 升序
public class Sorter01Insert implements Sorter {
    @Override
    public List<Integer> sort(List<Integer> array) {
        if (array == null || array.size() <= 1) {
            return array;
        }
        ArrayList<Integer> result = (ArrayList) array;
        /*
        * index为新插入的值
        * temp为排序好的末尾数
        * */
        int current, temp, num, index=1, end=result.size();
        while (index < end) {
            temp = index - 1;
            current = result.get(index);
            while (temp >= 0) {
                num = result.get(temp);
                if (current >= num) {
                    break;
                }
                //result.set(temp, current);
                result.set(temp+1, num);
                temp--;
            }
            result.set(temp+1, current);
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        TestPerformance util = new TestPerformance(new Sorter01Insert());
        ArrayList<Integer> test =  new ArrayList<>();
        test.add(13);
        test.add(2);
        test.add(1);
        Sorter01Insert sorter = new Sorter01Insert();
        TestPerformance.display(sorter.sort(test));
        util.test();
    }
}
