package kermit.algorithm.sort;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import kermit.algorithm.sort.monitor.SortMonitorLog;
import kermit.algorithm.sort.monitor.SortMonitor;
import kermit.algorithm.sort.monitor.SortMonitorResult;
import kermit.algorithm.sort.realized.SortCompareLambda;
import kermit.algorithm.sort.realized.SortRule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Date: 2019/4/2211:06
 * @Author: BoyuSun
 * @Description: 测试函数
 */
public class Main {
    SortRule<Integer> sortRule = new SortRule<Integer>() {
        public Integer getSortItem(Integer integer) {
            return integer;
        }
    };
    Comparator ascComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    };
    List<Integer> list = Arrays.asList(1,2,6,3,10,3,5,4,6,8,4,3,5,23,4,5);
    static{
        SortMonitor.init(new SortMonitorIO());
    }
    @Test
    public void bubble(){
        System.out.println("===============冒泡排序===============");
        //SortUtil.getBubbleSort().sort(list, sortRule, SortRule.ASC);
        SortUtil.getBubbleSort().sort(list, ascComparator);
        System.out.println(list);
        System.out.println("===============冒泡排序===============");
    }

    @Test
    public void selection(){
        System.out.println("===============选择排序===============");
        //SortUtil.getSelectionSort().sort(list, sortRule, SortRule.DESC);
        SortUtil.getSelectionSort().sort(list, ascComparator);
        System.out.println(list);
        System.out.println("===============选择排序===============");
    }

    @Test
    public void insertionSort(){
        System.out.println("===============插入排序===============");
        //SortUtil.getInsertionSort().sort(list, sortRule, SortRule.ASC);
        SortUtil.getInsertionSort().sort(list, ascComparator);
        System.out.println(list);
        System.out.println("===============插入排序===============");
    }

    @Test
    public void mergeSort(){
        System.out.println("===============归并排序===============");
        //SortUtil.getMergeSort().sort(list, sortRule, SortRule.ASC);
        SortUtil.getMergeSort().sort(list, ascComparator);
        System.out.println(list);
        System.out.println("===============归并排序===============");
    }

    @Test
    public void quickSort(){
        System.out.println("===============归并排序===============");
        SortUtil.getQuickSort().sort(list, sortRule, SortRule.DESC);
        //System.out.println(list);
        //SortUtil.getQuickSort().sort(list, ascComparator);
        System.out.println(list);
        System.out.println("===============归并排序===============");
    }

    @Test
    public void monitorSort(){
        System.out.println("===============统计排序===============");
        SortUtil.monitorSort(list, sortRule, SortRule.ASC, Integer.class);
        System.out.println(list);
        System.out.println("===============统计排序===============");
    }
}

class SortMonitorIO implements kermit.algorithm.sort.monitor.SortMonitorIO{
    Gson gson = new Gson();
    @Override
    public void log(SortMonitorLog result) {
        System.out.println("log:"+JSON.toJSONString(result));
    }

    @Override
    public void writeMonitorOperationResult(SortMonitorResult result) {
        System.out.println("result:"+gson.toJson(result));
    }

    @Override
    public List<SortMonitorResult> readResult() {
        return null;
    }
}
