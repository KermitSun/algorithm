package kermit.algorithm.sort.realized;

import kermit.algorithm.sort.monitor.SortMonitorIO;

import java.util.Comparator;
import java.util.List;

/**
 *@Date: 13:43 2019/4/22
 *@Description: 排序父接口
 */
public interface Sort{
    ThreadLocal<Integer> sequentialNum = new ThreadLocal(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    <T> void sort(List<T> list, SortRule sr, int sortRuleType);

    <T> void sort(List<T> list, Comparator comparator);

    /**
     *@Date: 11:07 2019/4/22
     *@Description: 交换
     */
    default <T> void swap(List<T> list, int idx1, int idx2){
        T o = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, o);
        sequentialNum.set(sequentialNum.get()+1);
    }

    default void clearSequentialNum(){
        sequentialNum.set(0);
    }
    default Integer getSequentialNum(){
        return sequentialNum.get();
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
}
