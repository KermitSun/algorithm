package kermit.algorithm.sort.realized;

import java.util.List;

/**
 * @Date: 2019/4/22 13:47
 * @Author: Kermit
 * @Description: 选择排序
 * 将数组分为两部分，一部分有序，一部分无序，从无序的集合中选出最小/最大的放在有序集合的最后
 * 最好时间复杂度：O(n^2)
 * 最坏时间复杂度：O(n^2)
 * 平均时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 */
public class SelectionSort implements Sort{
    @Override
    public <T> void sort(List<T> list, SortCompareLambda lambda) {
        checkEmpty(list);
        int len = list.size();
        for(int i=0;i<len;i++){
            T limit = list.get(i);
            int idx = i;
            for(int j=i;j<len;j++){
                if(!lambda.operation(idx,j)){
                    idx = j;
                    limit = list.get(j);
                }
            }
            if(idx != i){
                swap(list, i, idx);
            }
        }
    }
}
