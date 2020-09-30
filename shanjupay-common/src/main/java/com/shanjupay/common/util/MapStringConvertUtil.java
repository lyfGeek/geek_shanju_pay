package com.shanjupay.common.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapStringConvertUtil {

    // 参数类型是 Map<String,String> 支付需要用 string 的参数。

    /**
     * map 转 str。
     *
     * @param map
     * @return
     */
    public static String getMapToString(Map<String, String> map) {
        Set<String> keySet = map.keySet();
        // 将 set 集合转换为数组
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        // 给数组排序（升序）。
        Arrays.sort(keyArray);
        // 因为 String 拼接效率会很低的，所以转用 StringBuilder。
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keyArray.length; i++) {
            // 参数值为空，则不参与签名 方法 trim();是去空格。
            if (map.get(keyArray[i]).trim().length() > 0) {
                sb.append(keyArray[i]).append(":").append(map.get(keyArray[i]).trim());
            }
            if (i != keyArray.length - 1) {
                sb.append(",");
            }
        }
        String s = sb.toString();
        return s;
    }

    /**
     * String 转 Map。
     *
     * @param str
     * @return
     */
    public static Map<String, String> getStringToMap(String str) {
        // 判断 str 是否有值。
        if (null == str || "".equals(str)) {
            return null;
        }
        // 根据 & 截取。
        String[] strings = str.split(",");
        // 设置 HashMap 长度。
        int mapLength = strings.length;
        // 判断 hashMap 的长度是否是 2 的幂。
        if ((strings.length % 2) != 0) {
            mapLength = mapLength + 1;
        }

        Map<String, String> map = new HashMap<>(mapLength);
        // 循环加入 map 集合。
        for (int i = 0; i < strings.length; i++) {
            // 截取一组字符串。
            String[] strArray = strings[i].split(":");
            // strArray[0] 为 KEY，strArray[1] 为值。
            map.put(strArray[0], strArray[1]);
        }
        return map;
    }

}
