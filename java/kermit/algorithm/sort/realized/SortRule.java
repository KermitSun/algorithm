package kermit.algorithm.sort.realized;

import kermit.algorithm.list.Property;

/**
 * @Date: 2019/4/23 15:31
 * @Author: Kermit
 * @Description: 排序规则
 */
public interface SortRule<T> extends Property<T, Comparable> {
    //升序
    int ASC = -1;
    //降序
    int DESC = 1;

    Comparable getProperty(T obj);
}
