package kermit.algorithm.list;

/**
 * @Date: 2019/5/714:13
 * @Author: BoyuSun
 * @Description:
 */
public interface Property<Obj, Pro> {
    Pro getProperty(Obj obj);
}
