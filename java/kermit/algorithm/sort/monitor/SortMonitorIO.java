package kermit.algorithm.sort.monitor;

import java.util.List;

/**
 * @Author: Kermit
 * Description: 排序监控-io操作接口
 * Create by: 22:08 2019/4/23
 */
public interface SortMonitorIO {
    /**
     * @Author: Kermit
     * @Description: 记录日志,每次排序后记录日志
     * @Create by: 21:18 2019/4/23
     */
    void log(CurrentSortMonitor result);

    /**
     * @Author: Kermit
     * @Description: 写下统计结果，每次排序后重新统计该排序对象的统计结果，要求覆盖以前的统计结果
     * @Create by: 22:10 2019/4/23
     */
    void writeMonitorOperationResult(SortMonitorResult result);

    /**
     * @Author: Kermit
     * @Description: 启动时候读取历史统计结果
     * @Create by: 22:29 2019/4/23
     */
    List<SortMonitorResult> readResult();
}
