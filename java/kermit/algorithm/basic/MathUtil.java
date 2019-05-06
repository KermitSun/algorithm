package kermit.algorithm.basic;

import kermit.algorithm.sort.realized.SortRule;

import java.util.List;

/**
 * @Date: 2019/5/619:06
 * @Author: BoyuSun
 * @Description: 数学计算工具类
 */
public class MathUtil {
    //获取由SortRule规则规定的最小值
    public static <T> T min(List<T> list, SortRule<T> sortRule){
        return min(list, sortRule, 1);
    }
    public static <T> T min(List<T> list, SortRule<T> sortRule, int num){
        return sortNum(list, sortRule, SortRule.ASC, num);
    }
    public static <T> T max(List<T> list, SortRule<T> sortRule){
        return max(list, sortRule, 1);
    }
    public static <T> T max(List<T> list, SortRule<T> sortRule, int num){
        return sortNum(list, sortRule, SortRule.DESC, num);
    }
    public static <T> T sortNum(List<T> list, SortRule<T> sortRule, int sortRuleType, int num){
        //todo O(n)通过QuickSort分区思路，获取第num大/小的值 懒得写
        return null;
    }
}
