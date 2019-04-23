package kermit.algorithm.sort.realized;

/**
 * @Date: 2019/4/2315:31
 * @Author: BoyuSun
 * @Description: 排序规则
 */
public interface SortRule<T> {
    //升序
    int ASC = -1;
    //降序
    int DESC = 1;

    Comparable getSortItem(T obj);
}
