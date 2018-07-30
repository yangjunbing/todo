package projects.bing.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yang on 2017/2/23.
 */
public class MapUtils {

    public static Map<String, String> getRoleMap() {
        Map<String, String> roleMap = new HashMap<String, String>();
        roleMap.put("0","超级管理员");
        roleMap.put("1","前台");
        roleMap.put("2","服务员");
        roleMap.put("3","厨师");
        return roleMap;
    }
}
