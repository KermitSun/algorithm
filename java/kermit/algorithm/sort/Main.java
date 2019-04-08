package kermit.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Kermit
 * Description:
 * Create by: 10:44 2019/4/6
 */
public class Main {
    @Test
    public void bubble(){
        List<Integer> list = Arrays.asList(1,2,3,3,5,4,6,8,4,3,5,23,4,5);
        SortFactory.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(list);
    }
}
