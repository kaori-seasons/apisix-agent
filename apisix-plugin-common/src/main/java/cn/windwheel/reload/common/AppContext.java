package cn.windwheel.reload.common;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author windwheel
 */
public class AppContext {

    private static final Map<String, Object> ATTR = new ConcurrentHashMap<>();

    public static void put(String key, Object value) {
        ATTR.put(key, value);
    }




}
