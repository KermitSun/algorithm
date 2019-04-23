package kermit.algorithm.sort.monitor;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Kermit
 * Description: TODO
 * Create by: 22:30 2019/4/23
 */
public class SortMonitorResult {
    protected String sortObjPath;
    protected Integer range;
    Map<String, SortMonitorResultInner> map = new ConcurrentHashMap();

    public String getSortObjPath() {
        return sortObjPath;
    }

    public Integer getRange() {
        return range;
    }

    public SortMonitorResultInner getByMethodName(String methodName){
        return map.get(methodName);
    }

    class SortMonitorResultInner{
        protected BigDecimal averageTime;
        protected Integer count;
        public BigDecimal getAverageTime() {
            return averageTime;
        }

        public Integer getCount() {
            return count;
        }
    }
}
