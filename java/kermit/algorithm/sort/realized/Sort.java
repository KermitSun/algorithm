package kermit.algorithm.sort.realized;

import kermit.algorithm.sort.SortMonitoring;

import java.util.Comparator;
import java.util.List;

/**
 *@Date: 13:43 2019/4/22
 *@Description: 排序父接口
 */
public interface Sort{
    <T> void sort(List<T> list, SortRule sr, int sortRuleType);

    //todo 待实现
    //<T> void sort(List<T> list, Comparable comparable);

    /**
     *@Date: 11:07 2019/4/22
     *@Description: 交换
     */
    default <T> void swap(List<T> list, int idx1, int idx2){
        T o = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, o);
    }

    /**
     *@Date: 11:08 2019/4/22
     *@Description: 检查是否为空
     */
    default void checkEmpty(List list){
        if(list == null){
            throw new NullPointerException("参数不能为空");
        }
    }

    //todo 监控
    default void sortBefore(){
        SortMonitoring.getSupperMethod();
    }

    //todo 监控
    default void sortAfter(){

    }
}
