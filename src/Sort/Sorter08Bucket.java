package Sort;

import java.lang.reflect.Array;
import java.util.*;

public class Sorter08Bucket implements Sorter {
    private ListGenerator generator;
    private int bucketSize;
    public Sorter08Bucket(ListGenerator generator) {
        this.bucketSize=1000;
        this.generator = generator;
    }
    @Override
    public List<Integer> sort(List<Integer> array) {
        int bucket = (int) Math.ceil((1.0*generator.getMaximum()-generator.getMinimum())/bucketSize);
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<bucket;i++) {
            buckets.add(new ArrayList<>());
        }
        int index, min = generator.getMinimum();
        List<Integer> temp;
        for (int num:array) {
            index = (num-min)/bucketSize;
            buckets.get(index).add(num);
        }
        LinkedList<Integer> result = new LinkedList<>();
        for(ArrayList<Integer> list:buckets) {
            list.sort(null);
            result.addAll(list);
        }
        return result;
    }

    public static void main(String[] args) {
        ListGenerator generator = new ListGenerator();
        TestPerformance test = new TestPerformance(new Sorter08Bucket(generator));
        TestPerformance.setGenerator(generator);
        test.test();
    }
}
