package cn.sicau.count.utils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yelei
 * @date 18-3-31
 */
public class ReturnMap {
    public static Map<String,Object> resultMap(int status, String message){
        Map<String,Object> result=new LinkedHashMap<>();
        result.put("status",status);
        result.put("message",message);
        return result;
    }
}
