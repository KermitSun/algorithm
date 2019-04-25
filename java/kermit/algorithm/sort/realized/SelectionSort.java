package kermit.algorithm.sort.realized;

import java.util.Comparator;
import java.util.List;

/**
 * @Date: 2019/4/2213:47
 * @Author: BoyuSun
 * @Description: 选择排序
 * 将数组分为两部分，一部分有序，一部分无序，从无序的集合中选出最小/最大的放在有序集合的最后
 * 最好时间复杂度：
 * 最坏时间复杂度：
 * 平均时间复杂度：O(n^2)
 * 空间复杂度：
 * 稳定性：稳定
 */
public class SelectionSort implements Sort{

    @Override
    public <T> void sort(List<T> list, SortRule sr, int sortRuleType) {
        checkEmpty(list);
        int len = list.size();
        for(int i=0;i<len;i++){
            T limit = list.get(i);
            int idx = i;
            for(int j=i;j<len;j++){
                if(sr.getSortItem(list.get(j)).compareTo(sr.getSortItem(limit)) == sortRuleType){
                    idx = j;
                    limit = list.get(j);
                }
            }
            if(idx != i){
                swap(list, i, idx);
            }
        }
    }

    @Override
    public <T> void sort(List<T> list, Comparator comparator) {

    }
}
