package cn.freemarker.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zezhong.shang on 17-6-2.
 */
public class TypeConstant {
    /***
     * Map
     */
    private static Map<String, String> typeMap = new HashMap<String, String>();

    static {
        typeMap.put("BIGINT", "Long");
        typeMap.put("INT", "Integer");
        typeMap.put("VARCHAR", "String");
        typeMap.put("TEXT", "String");
        typeMap.put("DATETIME", "Date");
        typeMap.put("DECIMAL", "Double");
        typeMap.put("BIT", "Integer");
    }

    public static void addType(String columnType, String javaType) {
        typeMap.put(columnType, javaType);
    }

    public static String getJavaType(String columnType) {
        return typeMap.get(columnType);
    }
}
