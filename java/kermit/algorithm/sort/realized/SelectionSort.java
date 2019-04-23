package kermit.algorithm.sort.realized;

import java.util.List;

/**
 * @Date: 2019/4/2213:47
 * @Author: BoyuSun
 * @Description: 选择排序
 * 将数组分为两部分，一部分有序，一部分无序，从无序的集合中逐一拿出放在有序集合里，实现排序
 * 最好时间复杂度：
 * 最坏时间复杂度：
 * 平均时间复杂度：O(n^2)
 * 空间复杂度：O(1) 原地
 * 稳定性：稳定
 */
public class SelectionSort implements Sort{
    @Override
    public <T> void sort(List<T> list, SortRule sr, int sortRuleType) {

    }
}
