package kermit.algorithm.demo;

import kermit.algorithm.sort.SortUtil;
import kermit.algorithm.sort.realized.SortRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Date: 2019/4/2510:25
 * @Author: BoyuSun
 * @Description: 在int[m]的数组里，找n个值，这n个值相加=100，有多少种相加方式
 * int[m]里每个值都在[1,100]范围内
 */
public class AddEq100 {
    private static int m = 7; //数组的长度
    private static int n = 2;  //加法因子数量
    private static List<Integer> arr = gene(m);//随机生成的集合
    private static int topIdx = m-1;//加法因子index上限
    private static int counter = 0;//计数器
    private static int loopNum = 0;//记录循环次数

    public static void main(String[] args) {
        System.out.println(arr);
        //排序
        SortUtil.getSelectionSort().sort(arr, new SortRule<Integer>(){
            public Comparable getSortItem(Integer integer){
                return integer;
            }
        }, SortRule.ASC);
        System.out.println(arr);

        recursion(1, 0, 0);
        System.out.println(counter);
    }

    //curLocal 当前值是第几个,curLocal范围[1,n]
    //curIdx 当前值得下标
    //sum 前几个值得和
    private static void recursion(int curLocal,int curIdx, int sum){
        //shot down
        if(curIdx >= (m-n+curLocal) || curIdx > (topIdx-n+curLocal))
            return;
        if(curLocal > n)
            return;
        if(arr.get(curIdx)*(n-curLocal)+sum>100)
            return;
        //当前值往后循环
        while(curIdx < (m-n+curLocal)){
            System.out.println("curLocal:"+curLocal+",curIdx:"+curIdx+",sum:"+sum+",loopNum:"+(++loopNum));
            int sumBack = sum + arr.get(curIdx);
            if(curLocal == n){
                if(sumBack == 100){
                    counter++;
                    topIdx = curIdx;
                }else if(sumBack > 100){
                    topIdx = curIdx;
                    return;
                }
            }
            curIdx++;
            recursion(curLocal + 1, curIdx, sum + arr.get(curIdx-1));
        }
    }

    private static List<Integer> gene(int m){
        Random rd = new Random();
        List<Integer> arr = new ArrayList<>(m);
        for(int i = 0;i<m;i++){
            arr.add(rd.nextInt(100)+1);
        }
        return arr;
    }
}
