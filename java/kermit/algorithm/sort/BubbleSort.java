package kermit.algorithm.sort;

import java.util.Comparator;
import java.util.List;

/**
 * @Author: Kermit
 * @Description: 冒泡排序
 * @Create by: 10:32 2019/4/6
 */
public class BubbleSort implements Sort {
    BubbleSort(){}

    @Override
    public <T> void sort(List<T> list, Comparator<T> comparator) {
        checkEmpty(list);
        System.out.println("========== 冒泡排序 ==========");
        int len = list.size();
        System.out.println(list);
        for(int i=0;i<len;i++){
            boolean flag = true;
            for(int j=0;j<len-i-1;j++){
                if(comparator.compare(list.get(j+1), list.get(j)) < 0){
                    swap(list, j, j+1);
                    flag = false;
                }
            }
            System.out.println(list);
            if(flag){
                break;
            }
        }
        System.out.println("========== 冒泡排序 ==========");
    }
}
