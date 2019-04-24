package kermit.algorithm.sort;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import kermit.algorithm.sort.monitor.SortMonitorLog;
import kermit.algorithm.sort.monitor.SortMonitor;
import kermit.algorithm.sort.monitor.SortMonitorResult;
import kermit.algorithm.sort.realized.SortRule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
    List<Integer> list = Arrays.asList(1,2,6,3,10,3,5,4,6,8,4,3,5,23,4,5);
    static{
        SortMonitor.init(new SortMonitorIO());
    }
    @Test
    public void bubble(){
        System.out.println("===============冒泡排序===============");
        SortUtil.getBubbleSort().sort(list, sortRule, SortRule.DESC);
        System.out.println(list);
        System.out.println("===============冒泡排序===============");
    }

    @Test
    public void selection(){
        System.out.println("===============选择排序===============");
        SortUtil.getSelectionSort().sort(list, sortRule, SortRule.ASC);
        System.out.println(list);
        System.out.println("===============选择排序===============");
    }

    @Test
    public void monitorSort(){
        System.out.println("===============统计排序===============");
        System.out.println(list);
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
