package kermit.algorithm.sort.monitor;

import java.util.List;

/**
 * @Author: Kermit
 * Description: TODO
 * Create by: 22:00 2019/4/23
 */
public class CurrentSortMonitor {
    protected Integer sequentialNum = -1;
    protected List list = null;
    protected String sortObjPath = null;
    protected Integer size = null;
    protected Long startTime = null;
    protected Long endTime = null;

    public Integer getSequentialNum() {
        return sequentialNum;
    }

    public List getList() {
        return list;
    }

    public String getSortObjPath() {
        return sortObjPath;
    }

    public Integer getSize() {
        return size;
    }

    public Long getStartTime() {
        return startTime;
    }

    public Long getEndTime() {
        return endTime;
    }
}
