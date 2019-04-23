package kermit.algorithm.sort.monitor;

import java.util.List;

/**
 * @Author: Kermit
 * Description: 统计操作类
 * Create by: 22:08 2019/4/23
 */
public abstract class SortMonitorOperation {
    /**
     * @Author: Kermit
     * @Description: 记录日志
     * @Create by: 21:18 2019/4/23
     */
    abstract void log(CurrentSortMonitor result);

    /**
     * @Author: Kermit
     * @Description: 写下统计结果
     * @Create by: 22:10 2019/4/23
     */
    abstract void writeMonitorOperationResult(SortMonitorResult result);

    /**
     * @Author: Kermit
     * @Description: 启动时候读取历史统计结果
     * @Create by: 22:29 2019/4/23
     */
    abstract List<SortMonitorResult> readResult();
}
