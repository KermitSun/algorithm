package kermit.algorithm.sort.realized;

import java.util.Comparator;
import java.util.List;

/**
 * @Date: 2019/4/2213:56
 * @Author: BoyuSun
 * @Description: 桶排序
 * 需要根据list的条件把size个数据放到m个桶里，每个桶里有个范围，这个m需要动态扩展，保证每个桶里的数据量不至于太多
 * 桶排序只有使用SortRule才能获取具体要排序的元素，所以只实现SortRule方式的排序
 */
public class BucketSort implements Sort{
    private int bucketNum;
    private static int bucketSize = 16;

    @Override
    public <T> void sort(List<T> list, SortRule sr, int sortRuleType){
        Comparable sortItem = sr.getProperty(list.get(1));
    }
    @Override
    public <T> void sort(List<T> list, Comparator comparator){
        throw new RuntimeException("未实现该方法");
    }
    @Override
    public <T> void sort(List<T> list, SortCompareLambda lambda) {
        throw new RuntimeException("未实现该方法");
    }
   /* public <T> int hash(T t){
        int hashCode = t.hashCode() / bucketNum;
        return hashCode;
    }*/
}
