package org.cyl.translatejavafx.service;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.cyl.translatejavafx.utils.*;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * 网易有道智云翻译服务api调用demo
 * api接口: https://openapi.youdao.com/api
 */
public class TranslateDemo {

    private static  String APP_KEY = "";     // 您的应用ID
    private static  String APP_SECRET = "";  // 您的应用密钥
    private static String from="";
    private static String to="";

    public static void setAppKey(String appKey) {
        APP_KEY = appKey;
    }

    public static void setAppSecret(String appSecret) {
        APP_SECRET = appSecret;
    }

    public static void setFrom(String from) {
        TranslateDemo.from = from;
    }

    public static void setTo(String to) {
        TranslateDemo.to = to;
    }

    public static String doTranslate(String text) throws NoSuchAlgorithmException {
        // 添加请求参数
        Map<String, String[]> params = createRequestParams(text);
        // 添加鉴权相关参数
        AuthV3Util.addAuthParams(APP_KEY, APP_SECRET, params);
        // 请求api服务
        byte[] result = HttpUtil.doPost("https://openapi.youdao.com/api", null, params, "application/json");
        // 创建 Gson 实例
        Gson gson = new Gson();
        String jsonString= new String(result, StandardCharsets.UTF_8);
        // 将 JSON 字符串解析为 JsonObject
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
        // 获取 "basic" 对象
        JsonObject basicObject = jsonObject.getAsJsonObject("basic");
        // 获取 "explains" 数组
        JsonArray explainsArray = basicObject.getAsJsonArray("explains");
        String aws="";
        for (JsonElement element : explainsArray) {
           aws+= element.getAsString()+"、";
        }
        // 打印返回结果
        if (aws != null) {

            return aws;
        }
        return null;
    }

    private static Map<String, String[]> createRequestParams(String text) {
        /*
         * note: 将下列变量替换为需要请求的参数
         * 取值参考文档: https://ai.youdao.com/DOCSIRMA/html/%E8%87%AA%E7%84%B6%E8%AF%AD%E8%A8%80%E7%BF%BB%E8%AF%91/API%E6%96%87%E6%A1%A3/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1-API%E6%96%87%E6%A1%A3.html
         */
        String q = text;
        String f = from;
        String t = to;
        String vocabId = "您的用户词表ID";

        return new HashMap<String, String[]>() {{
            put("q", new String[]{q});
            put("from", new String[]{f});
            put("to", new String[]{t});
            put("vocabId", new String[]{vocabId});
        }};
    }
}
