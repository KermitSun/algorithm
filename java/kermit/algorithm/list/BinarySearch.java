package kermit.algorithm.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Date: 2019/5/7 14:10
 * @Author: Kermit
 * @Description: 二分查找
 * 针对有序集合
 * 单值查找，单值范围查找
 *
 */
public class BinarySearch {
    /*public static <Obj, Pro> Obj searchOne(List<Obj> list, Pro target, Property<Obj, Pro> property){
        int idx = searchIdx(list, target, property);
        return list.get(idx);
    }
    public static <Obj, Pro> List<Obj> searchRange(List<Obj> list, Pro target, Property<Obj, Pro> property){
        int idx = searchIdx(list, target, property);
        int leftIdx = rangeLeft(list, target, property, idx);
        int rightIdx = rangeRight(list, target, property, idx);
        return list.subList(leftIdx, rightIdx);
    }

    public static <Obj, Pro> int searchIdx(List<Obj> list, Pro target, Property<Obj, Pro> property){

    }
    private static <Obj, Pro> int rangeLeft(List<Obj> list, Pro target, Property<Obj, Pro> property, int idx){
        Pro val = property.getProperty(list.get(idx));
        if(val.equals(target)){
            boolean loop = true;
            do{
                idx--;
                val = property.getProperty(list.get(idx));
                loop = target == val;
            }while(loop);
            return idx;
        }
    }
    private static <Obj, Pro> int rangeRight(List<Obj> list, Pro target, Property<Obj, Pro> property, int idx){
        
    }

    private static <Obj, Pro> int rangeLeftRight(List<Obj> list, Pro target, Property<Obj, Pro> property, int idx, int direction){
        Pro val = property.getProperty(list.get(idx));
        if(val.equals(target)){
            boolean loop = true;
            do{
                idx += direction;
                val = property.getProperty(list.get(idx));
                loop = target == val;
            }while(loop);
            return idx;
        }else{
            List newList;
            if(direction>0){
                newList = new ArrayList();
                Collections.copy(newList, list);
                rangeLeftRight(newList, target, property,idx, direction);
                list = list.subList(0, idx);
            }else{
                list = list.subList(idx, list.size()-1);
            }
            idx = searchIdx(list, target, property);
            int i = rangeLeftRight(list, target, property, idx, direction);
            return ;
        }

    }

    public static*/
}
