package Sort;

import java.util.List;

public class Sorter07Shell implements Sorter {
    private Sorter sorter;
    public Sorter07Shell(Sorter01Insert sorter) {
        this.sorter = sorter;
    }

    @Override
    public List<Integer> sort(List<Integer> array) {
        int size = array.size();
        for(int gap=size/2;gap>=1;gap/=2) {
            for (int i=0;i<size-gap-1;i++) {
                // TODO: 2021/1/13  
            }
        }
        return array;
    }
}
