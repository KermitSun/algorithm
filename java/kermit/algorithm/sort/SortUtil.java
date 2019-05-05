package kermit.algorithm.sort;

import kermit.algorithm.sort.monitor.SortMonitor;
import kermit.algorithm.sort.realized.*;

import java.util.List;

public class SortUtil {
    private final static ThreadLocal<BubbleSort> bsTL = new ThreadLocal<>();
    private final static ThreadLocal<SelectionSort> ssTL = new ThreadLocal<>();
    private final static ThreadLocal<InsertionSort> isTL = new ThreadLocal<>();
    private final static ThreadLocal<QuickSort> qsTL = new ThreadLocal<>();
    public static BubbleSort getBubbleSort(){
        return getSort(bsTL, BubbleSort.class);
    }
    public static SelectionSort getSelectionSort(){
        return getSort(ssTL, SelectionSort.class);
    }
    public static InsertionSort getInsertionSort(){
        return getSort(isTL, InsertionSort.class);
    }
    public static QuickSort getQuickSort(){
        return getSort(qsTL, QuickSort.class);
    }

    private SortUtil(){}

    /**
     * @Author: Kermit
     * @Description: 自动选择排序算法，并排序，需要使用过监控排序训练过的数据
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
     *@Date: 10:04 2019/4/24
     *@Description: 监控排序
     */
    public static <T> void monitorSort(List<T> list, SortRule sr, int sortRuleType, Class<T> sortObj){
        Sort sortBean = autoGetSortBean(list.size());
        SortMonitor.startMonitoring(list, sortObj, sortBean);
        sortBean.sort(list, sr, sortRuleType);
        SortMonitor.endMonitoring();
    }

    /**
     *@Date: 13:40 2019/4/22
     *@Description: 选择排序对象
     * todo 自动选择排序方法，调用SortMonitor.recommendSort()
     */
    private static Sort autoGetSortBean(int size){
        Sort sortBean = null;
        if(size < 10){
            sortBean = getBubbleSort();
        }else{
            sortBean = getInsertionSort();
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
