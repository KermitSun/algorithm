package kermit.algorithm.sort;

import kermit.algorithm.sort.realized.*;

import java.util.List;

public class SortUtil {
    private final static ThreadLocal<BubbleSort> bsTL = new ThreadLocal<>();
    private final static ThreadLocal<SelectionSort> ssTL = new ThreadLocal<>();
    private final static ThreadLocal<QuickSort> qsTL = new ThreadLocal<>();
    public static BubbleSort getBubbleSort(){
        return getSort(bsTL, BubbleSort.class);
    }
    public static SelectionSort getSelectionSort(){
        return getSort(ssTL, SelectionSort.class);
    }
    public static QuickSort getQuickSort(){
        return getSort(qsTL, QuickSort.class);
    }

    private SortUtil(){}

    /**
     * @Author: Kermit
     * @Description: 自动选择排序算法，并排序
     * @Create by: 10:41 2019/4/6
     */
    public static <T> void sort(List<T> list, SortRule sr, int sortRuleType){
        Sort sortBean = autoGetSortBean(list.size());
        sortBean.sort(list, sr, sortRuleType);
    }
    public static <T> void sort(List<T> list, SortRule sr){
        sort(list, sr, SortRule.ASC);
    }

    /**
     *@Date: 13:40 2019/4/22
     *@Description: 选择排序对象
     * todo
     * 添加了SortStatistics.properties，用于记录调用情况，
     * 应根据实际情况动态计算排序的参数。。。
     * 但是这个应该很麻烦
     */
    private static Sort autoGetSortBean(int size){
        Sort sortBean = null;
        if(size < 10){
            sortBean = getSelectionSort();
        }else{
            sortBean = getQuickSort();
        }
        return sortBean;
    }

    private static <T extends Sort> T getSort(ThreadLocal<T> tl, Class<T> clazz){
        T sortBean = tl.get();
        if(sortBean == null){
            synchronized (clazz.getName()+Thread.class){
                if(sortBean == null){
                    try {
                        sortBean = (T)clazz.newInstance();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    tl.set(sortBean);
                }
            }
        }
        return sortBean;
    }
}
