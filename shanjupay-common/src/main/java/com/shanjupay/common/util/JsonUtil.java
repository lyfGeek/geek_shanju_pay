package com.shanjupay.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUtil {

    public static String objectTojson(Object object) {
        return JSON.toJSONString(object, SerializerFeature.WriteDateUseDateFormat);
    }


    public static String listTojson(List list) {
        return JSON.toJSONString(list, SerializerFeature.WriteDateUseDateFormat);
    }

    /**
     * 字符串 Json 格式转换为对象 Map。
     *
     * @param strJson {"username": "lyf"}
     * @return 根据 json 转换为 Map 对象。
     */
    public static Map<String, Object> jsonToMap(String strJson) {
        Map<String, Object> jsoMap = new HashMap<String, Object>();
        try {
            jsoMap = JSONObject.parseObject(strJson, Map.class);
        } catch (JSONException e) {
            System.out.println("json 转换 Map 出错 ~ " + e.getMessage());
        }
        return jsoMap;
    }

    /**
     * 字符串 Json 转换为对象 List。
     *
     * @param strJson [{"username": "lyf"}]
     * @return 根据 json 转换 List。
     */
    public static List<Map<String, Object>> jsonToList(String strJson) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            list = JSONObject.parseObject(strJson, List.class);
        } catch (JSONException e) {
            System.out.println("json 转换 List 出错 ~ " + e.getMessage());
        }
        return list;
    }

}
