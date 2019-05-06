package kermit.algorithm.sort.realized;

import java.util.Comparator;
import java.util.List;

/**
 * @Date: 2019/4/2213:56
 * @Author: BoyuSun
 * @Description: 桶排序
 * 需要根据list的条件把size个数据放到m个桶里，这个m如何界定才比较好。。。
 * 采用动态生成桶的方式，首先有个hash方法
 * 这个方法基于Sort是没法实现的。。。
 * 暂时停滞
 */
public class BucketSort implements Sort{
    private int bucketNum;
    private static int bucketSize = 16;

    @Override
    public <T> void sort(List<T> list, SortRule sr, int sortRuleType){
        Comparable sortItem = sr.getSortItem(list.get(1));
    }
    @Override
    public <T> void sort(List<T> list, Comparator comparator){
        throw new RuntimeException("未实现该方法");
    }
    @Override
    public <T> void sort(List<T> list, SortCompareLambda lambda) {
        throw new RuntimeException("未实现该方法");
    }
    public <T> int hash(T t){
        int hashCode = t.hashCode() / bucketNum;
        return hashCode;
    }
}
