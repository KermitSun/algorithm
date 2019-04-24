package kermit.algorithm.sort.monitor;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Kermit
 * Description: 排序监控-统计结果
 * Create by: 22:30 2019/4/23
 */
public class SortMonitorResult {
    protected String sortObjPath;
    protected Integer range;
    protected Map<String, SortMonitorResultMethod> map = new ConcurrentHashMap();

    public String getSortObjPath() {
        return sortObjPath;
    }

    public Integer getRange() {
        return range;
    }

    public SortMonitorResultMethod getByMethodName(String methodName){
        return map.get(methodName);
    }

    /**
     *@Date: 9:26 2019/4/24
     *@Description: 针对单个方法
     */
    class SortMonitorResultMethod{
        protected String sortMethodName;
        protected BigDecimal averageTime;
        protected Integer count;
        public BigDecimal getAverageTime() {
            return averageTime;
        }
        public Integer getCount() {
            return count;
        }
        public String getSortMethodName(){
            return sortMethodName;
        }

        @Override
        public String toString() {
            return "SortMonitorResultMethod{" +
                    "sortMethodName='" + sortMethodName + '\'' +
                    ", averageTime=" + averageTime +
                    ", count=" + count +
                    '}';
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("SortMonitorResult{sortObjPath='" + sortObjPath + "\', range=" + range +", map=");
        map.forEach((k,v)-> sb.append(v));
        sb.append("}");
        return sb.toString();
    }
}
