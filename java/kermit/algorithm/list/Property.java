package kermit.algorithm.list;

/**
 * @Date: 2019/5/7 14:13
 * @Author: Kermit
 * @Description:
 */
public interface Property<Obj, Pro> {
    Pro getProperty(Obj obj);
}
