package kermit.algorithm.sort.realized;

import java.util.Comparator;
import java.util.List;

/**
 * @Author: Kermit
 * @Description: 冒泡排序
 * @Create by: 10:32 2019/4/6
 *  最好时间复杂度：
 *  最坏时间复杂度：
 *  平均时间复杂度：
 *  空间复杂度：
 *  稳定性：稳定
 */
public class BubbleSort<T> implements Sort {

    @Override
    public void sort(List list, SortRule sr, int sortRuleType) {
        checkEmpty(list);
        int len = list.size();
        for(int i=0;i<len;i++){
            boolean flag = true;
            for(int j=0;j<len-i-1;j++){
                //原地
                if(sr.getSortItem(list.get(j + 1)).compareTo(sr.getSortItem(list.get(j))) == sortRuleType){
                    swap(list, j, j+1);
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }
}
