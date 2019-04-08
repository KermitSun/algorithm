package kermit.algorithm.sort;

import java.util.Comparator;
import java.util.List;

public interface Sort {
    <T> void sort(List<T> list, Comparator<T> comparator);

    default <T> void swap(List<T> list, int idx1, int idx2){
        T o = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, o);
    }

    default void checkEmpty(List list){
        if(list == null){
            throw new NullPointerException("参数不能为空");
        }
    }

}
