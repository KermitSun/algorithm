package kermit.algorithm.sort;

import java.util.Comparator;
import java.util.List;

public class SortFactory {
    //冒泡排序
    private final static BubbleSort bubble;
    static{
        bubble = new BubbleSort();
    }

    private SortFactory(){}

    public static <T> Sort sort(List<T> list, Comparator comparator, String sortType){
        switch(sortType){
            case "bubble":
                bubble.sort(list, comparator);
        }
        return null;
    }

    /**
     * @Author: Kermit
     * @Description: 根据长度自动选择排序算法
     * @Create by: 10:41 2019/4/6
     */
    public static <T> void sort(List<T> list, Comparator comparator){
        Sort sortClass = getInstance(list.size());
        sortClass.sort(list, comparator);
    }

    private static Sort getInstance(int size){
        if(size < 1000){
            return bubble;
        }else{
            return null;
        }
    }
}
