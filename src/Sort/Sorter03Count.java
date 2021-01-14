package Sort;

import java.util.List;

public class Sorter03Count implements Sorter {

    int minimum;
    int maximum;

    public Sorter03Count(ListGenerator generator) {
        this.maximum = generator.getMaximum();
        this.minimum = generator.getMinimum();
    }

    @Override
    public List<Integer> sort(List<Integer> array) {
        int[] bucketLen = new int[this.maximum-this.minimum];
        for(int i:array) {
            bucketLen[i-this.minimum]++;
        }
        int index = 0, value = 0;
        for(int count :bucketLen) {
            for (int i=0;i< count;i++){
                array.set(index++, minimum+value);
            }
            value++;
        }
        return array;
    }

    public static void main(String[] args) {
        ListGenerator generator = new ListGenerator();
        generator.setMinimum(10000);
        TestPerformance test = new TestPerformance(new Sorter03Count(TestPerformance.getGenerator()));
        test.test();
        TestPerformance test2 = new TestPerformance(new Sorter03Count(generator));
        TestPerformance.setGenerator(generator);
        test2.test();
    }
}
