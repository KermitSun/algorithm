package kermit.algorithm.sort;

import kermit.algorithm.sort.realized.SortRule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Date: 2019/4/2211:06
 * @Author: BoyuSun
 * @Description: 测试函数
 */
public class Main {
    SortRule<Integer> sortRule = new SortRule<Integer>() {
        public Integer getSortItem(Integer integer) {
            return integer;
        }
    };
    List<Integer> list = Arrays.asList(1,2,6,3,10,3,5,4,6,8,4,3,5,23,4,5);

    @Test
    public void bubble(){
        System.out.println("===============冒泡排序===============");
        SortUtil.getBubbleSort().sort(list, sortRule, SortRule.DESC);
        System.out.println(list);
        System.out.println("===============冒泡排序===============");
    }

    @Test
    public void selection(){
        System.out.println("===============选择排序===============");
        SortUtil.getSelectionSort().sort(list, sortRule, SortRule.ASC);
        System.out.println(list);
        System.out.println("===============选择排序===============");
    }


}
