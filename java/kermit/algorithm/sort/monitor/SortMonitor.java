package kermit.algorithm.sort.monitor;

import kermit.algorithm.sort.realized.Sort;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Date: 2019/4/2211:38
 * @Author: BoyuSun
 * @Description: 监控排序方法的执行时间
 */
public abstract class SortMonitor {
    //是否计算有序性
    static boolean sequential = false;
    //保证线程安全
    private static ThreadLocal<CurrentSortMonitor> tl = new ThreadLocal<>();
    private static SortMonitorOperation operation = null;
    private static ConcurrentHashMap<String, SortMonitorResult> resultMap = new ConcurrentHashMap();

    private SortMonitor(){}
    /**
     * @Author: Kermit
     * @Description: 开始统计
     * @Create by: 21:24 2019/4/23
     */
    public static <T> void startMonitoring(List<T> list, Class<T> sortObj, SortMonitorOperation operation){
        CurrentSortMonitor sm = getCurrentSortMonitor();
        sm.sortObjPath = sortObj.getName();
        sm.startTime = System.currentTimeMillis();
        sm.size = list.size();
        sm.list = list;
    }

    /**
     * @Author: Kermit
     * @Description: 结束统计
     * @Create by: 21:34 2019/4/23
     */
    public static <T> void endMonitoring(){
        CurrentSortMonitor currentSortMonitor = getCurrentSortMonitor();
        currentSortMonitor.endTime = System.currentTimeMillis();
        if(sequential){
            currentSortMonitor.sequentialNum = sequential(currentSortMonitor.list);
        }
        SortMonitorResult result = calculate();
        operation.writeMonitorOperationResult(result);
        operation.log(currentSortMonitor);
    }

    /**
     * @Author: Kermit
     * @Description: 统计耗时
     * @Create by: 21:41 2019/4/23
     */
    private static SortMonitorResult calculate(){
        CurrentSortMonitor currentSortMonitor = getCurrentSortMonitor();
        int range = SortMonitorRange.getRange(currentSortMonitor.getSize());
        SortMonitorResult result = resultMap.get(currentSortMonitor.getSortObjPath()+range);
        if(result == null){
            result = new SortMonitorResult();
            result.range = range;
            result.sortObjPath = currentSortMonitor.sortObjPath;
            result.averageTime = getAverageTime(currentSortMonitor);
            result.count = 1;
        }else{
            result.averageTime = getAverageTime(currentSortMonitor, result);
            result.count += result.count;
        }
        resultMap.put(currentSortMonitor.getSortObjPath()+range, result);
        return result;
    }

    private static BigDecimal getAverageTime(CurrentSortMonitor currentSortMonitor, SortMonitorResult result){
        BigDecimal current = getAverageTime(currentSortMonitor);
        return result.averageTime.multiply(new BigDecimal(result.count)).add(current)
                .divide(new BigDecimal(result.count+1), 10, RoundingMode.HALF_DOWN);
    }
    private static BigDecimal getAverageTime(CurrentSortMonitor currentSortMonitor, ){
        return new BigDecimal(currentSortMonitor.endTime - currentSortMonitor.startTime)
                .divide(new BigDecimal(currentSortMonitor.size), 10, RoundingMode.HALF_DOWN);
    }
    /**
     * @Author: Kermit
     * @Description: todo 通过之前统计，计算用时最少的排序算法
     * @Create by: 22:25 2019/4/23
     */
    public static Sort recommendSort(Class sortObj, Integer size){
        int range = SortMonitorRange.getRange(size);
        SortMonitorResult result = resultMap.get(sortObj.getName()+range);
        return null;
    }

    /**
     * @Author: Kermit
     * @Description: todo 初始化,读取
     * @Create by: 22:26 2019/4/23
     */
    public static void init(SortMonitorOperation operation){
        SortMonitor.operation = operation;
        List<SortMonitorResult> results = operation.readResult();
    }

    /**
     * @Author: Kermit
     * @Description: todo 计算有序性,需要传入比较规则，或者监控swap方法执行次数方法；
     * @Create by: 21:21 2019/4/23
     */
    private static Integer sequential(List list){
        return null;
    }

    /**
     * @Author: Kermit
     * @Description: 获取结果对象
     * @Create by: 21:43 2019/4/23
     */
    private static CurrentSortMonitor getCurrentSortMonitor(){
        CurrentSortMonitor result = tl.get();
        if(result == null){
            synchronized (SortMonitor.class.getName()+Thread.currentThread().getName()){
                if(result == null){
                    result = new CurrentSortMonitor();
                    tl.set(result);
                }
            }
        }
        return result;
    }
}

