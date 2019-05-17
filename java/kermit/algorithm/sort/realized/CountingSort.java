package kermit.algorithm.sort.realized;

/**
 * @Date: 2019/4/22 13:56
 * @Author: Kermit
 * @Description: 计数排序
 * 该方法并不适用与基本类型之外的类型，所以其要求只有Numver子类或者String才能实现
 * 具体实现是使用一个map，key保存需要比较的基本类型或者是String，value是记录出现了几次，
 * 这个map的key可以在另一个有序集合中保存，这样loop一遍之后，
 * 会统计出一共出现了几种不同的值，并在集合中有序，
 * 之后loop这个集合，每个值当做map的key获取其出现次数，还原数组
 *
 * -------------------------
 * 计数排序的变种
 * map的value保存成List<T>,这样可以保存其他类型
 */
public class CountingSort  {
   
}
