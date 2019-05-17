package kermit.algorithm.sort.monitor;

import kermit.algorithm.sort.realized.Sort;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Date: 2019/4/22 11:38
 * @Author: Kermit
 * @Description: 监控排序方法的执行时间
 */
public abstract class SortMonitor {
    //保证线程安全
    private static ThreadLocal<SortMonitorLog> tl = new ThreadLocal<>();
    private static SortMonitorIO operation = null;
    private static ConcurrentHashMap<String, SortMonitorResult> resultMap = new ConcurrentHashMap();

    private SortMonitor(){}
    /**
     * @Author: Kermit
     * @Description: 开始统计
     * @Create by: 21:24 2019/4/23
     */
    public static <T,S extends Sort> void startMonitoring(List<T> list, Class<T> sortObj, S sortMethod){
        SortMonitorLog sm = getCurrentSortMonitor();
        sm.sortObjPath = sortObj.getName();
        sm.size = list.size();
        sm.list = list;
        sm.sortMethod = sortMethod;
        sortMethod.clearSequentialNum();
        sm.startTime = System.currentTimeMillis();
    }

    /**
     * @Author: Kermit
     * @Description: 结束统计
     * @Create by: 21:34 2019/4/23
     */
    public static <T> void endMonitoring(){
        SortMonitorLog sortMonitorLog = getCurrentSortMonitor();
        sortMonitorLog.endTime = System.currentTimeMillis();
        sortMonitorLog.sequentialNum = sortMonitorLog.sortMethod.getSequentialNum();
        SortMonitorResult result = calculate();
        if(operation != null){
            operation.writeMonitorOperationResult(result);
            operation.log(sortMonitorLog);
        }
    }

    /**
     * @Author: Kermit
     * @Description: 统计耗时
     * @Create by: 21:41 2019/4/23
     */
    private static SortMonitorResult calculate(){
        SortMonitorLog sortMonitorLog = getCurrentSortMonitor();
        int range = SortMonitorRange.getRange(sortMonitorLog.getSize());
        SortMonitorResult result = resultMap.get(sortMonitorLog.getSortObjPath()+range);
        String sortMethodName = sortMonitorLog.sortMethod.getClass().getName();
        if(result == null){
            result = new SortMonitorResult();
            result.range = range;
            result.sortObjPath = sortMonitorLog.sortObjPath;
            SortMonitorResult.SortMonitorResultMethod smrm = result.new SortMonitorResultMethod();
            smrm.averageTime = getAverageTime(sortMonitorLog);
            smrm.count = 1;
            smrm.sortMethodName = sortMethodName;
            result.map.put(sortMethodName, smrm);
        }else{
            SortMonitorResult.SortMonitorResultMethod smrm = result.map.get(sortMethodName);
            if(smrm == null){
                smrm = result.new SortMonitorResultMethod();
                smrm.averageTime = getAverageTime(sortMonitorLog);
                smrm.count = 1;
                smrm.sortMethodName = sortMethodName;
                result.map.put(sortMethodName, smrm);
            }else{
                smrm.averageTime = getAverageTime(sortMonitorLog, smrm);
                smrm.count += smrm.count;
            }
        }
        resultMap.put(sortMonitorLog.getSortObjPath()+range, result);
        return result;
    }

    private static BigDecimal getAverageTime(SortMonitorLog sortMonitorLog, SortMonitorResult.SortMonitorResultMethod smrm){
        BigDecimal current = getAverageTime(sortMonitorLog);
        return smrm.averageTime.multiply(new BigDecimal(smrm.count)).add(current)
                .divide(new BigDecimal(smrm.count+1), 10, RoundingMode.HALF_DOWN);
    }
    private static BigDecimal getAverageTime(SortMonitorLog sortMonitorLog){
        return new BigDecimal(sortMonitorLog.endTime - sortMonitorLog.startTime)
                .divide(new BigDecimal(sortMonitorLog.size), 10, RoundingMode.HALF_DOWN);
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
    public static void init(SortMonitorIO operation){
        SortMonitor.operation = operation;
        List<SortMonitorResult> results = operation.readResult();
    }

    /**
     * @Author: Kermit
     * @Description: 获取结果对象
     * @Create by: 21:43 2019/4/23
     */
    private static SortMonitorLog getCurrentSortMonitor(){
        SortMonitorLog result = tl.get();
        if(result == null){
            synchronized (SortMonitor.class.getName()+Thread.currentThread().getName()){
                if(result == null){
                    result = new SortMonitorLog();
                    tl.set(result);
                }
            }
        }
        return result;
    }
}

