package kermit.algorithm.sort;

import kermit.algorithm.sort.realized.BubbleSort;
import kermit.algorithm.sort.realized.Sort;

import java.util.Comparator;
import java.util.List;

public class SortUtil {
    private final static ThreadLocal<BubbleSort> bsTL = new ThreadLocal<>();

    private SortUtil(){}

    /**
     * @Author: Kermit
     * @Description: 自动选择排序算法，并排序
     * @Create by: 10:41 2019/4/6
     */
    public static <T> void sort(List<T> list, Comparator comparator){
        Sort sortBean = autoGetSortBean(list.size());
        sortBean.sort(list, comparator);
    }

    /**
     *@Date: 11:48 2019/4/22
     *@Description: 冒泡排序
     */
    public static <T> void bubble(List<T> list, Comparator comparator){
        getBubbleBean().sort(list, comparator);
    }



    /**
     *@Date: 13:40 2019/4/22
     *@Description: 获取排序对象
     * todo
     * 添加了SortStatistics.properties，用于记录调用情况，
     * 应根据实际情况动态计算排序的参数。。。
     * 但是这个应该很麻烦
     */
    private static Sort autoGetSortBean(int size){
        Sort sortBean = null;
        if(size < 1000){
            sortBean = getBubbleBean();
        }else{

        }
        return sortBean;
    }

    /**
     *@Date: 13:43 2019/4/22
     *@Description:
     */
    private static BubbleSort getBubbleBean(){
        BubbleSort sortBean = getBean(bsTL);
        return sortBean;
    }

    public static <T extends Sort> T getBean(ThreadLocal<T> tl){
        T sortBean = tl.get();
        if(sortBean == null){
            Class<? extends Sort> clazz = sortBean.getClass();
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
