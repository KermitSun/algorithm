package kermit.algorithm.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2019/5/1717:31
 * @Author: BoyuSun
 * @Description: 计算阶乘
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(9999));
    }
    private static List<BigDecimal> list = new ArrayList(20);
    private static BigDecimal factorial(int top){
        long product = 1L;
        for(int i=1;i<=top;i++){
            if(Long.MAX_VALUE / product < i){
                list.add(new BigDecimal(product));
                product = 1L;
            }
            product = i*product;
        }
        list.add(new BigDecimal(product));
        BigDecimal productBigDecimal = BigDecimal.ONE;
        for(BigDecimal l:list){
            productBigDecimal = productBigDecimal.multiply(l);
        }
        return productBigDecimal;
    }
}
