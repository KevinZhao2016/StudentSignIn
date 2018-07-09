package com.util;

import com.baidu.aip.face.AipFace;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class AipFaceUtil {
    private static final String APP_ID = "11505765";
    private static final String API_KEY = "wypfpS5MPbqljAbntrcPc8no";
    private static final String SECRET_KEY = "2dzsONOTfl90LiEHzZmdPhULmeS16Qsb";

    private static AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

    public static void main(String[] args) {
        // 初始化一个AipFace
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
    }

    public String FaceSearch(String image) {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        options.put("max_user_num", "1");
        String imageType = "BASE64";
        String groupIdList = "student";
        // 人脸搜索
        JSONObject res = client.search(image, imageType, groupIdList, options);
        System.out.println(res.toString(2));
        try {
            if (res.get("error_code").equals(0)) {
                JSONObject result = (JSONObject) res.get("result");
                JSONArray userlist =  (JSONArray)result.get("user_list");
                JSONObject userinfo = (JSONObject)userlist.get(0);
                if ((double)userinfo.get("score") > 75) {
                    return (String) userinfo.get("user_id");
                }
                else {
                    return null;
                }
            }else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String FaceAdd(String face,String id) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("user_info", "");
        options.put("quality_control", "LOW");
        options.put("liveness_control", "LOW");

        String image = face;
        String imageType = "BASE64";
        String groupId = "student";
        String userId = id;

        // 人脸注册
        JSONObject res = client.addUser(image, imageType, groupId, userId, options);
        System.out.println(res.toString(2));
        try {
            if (res.get("error_code").equals(0)) {
                return (String)res.get("face_token");
            }else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String FaceUpdate(String face,String id) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("user_info", "");
        options.put("quality_control", "LOW");
        options.put("liveness_control", "LOW");

        String image = face;
        String imageType = "BASE64";
        String groupId = "student";
        String userId = id;

        // 人脸更新
        JSONObject res = client.updateUser(image, imageType, groupId, userId, options);
        System.out.println(res.toString(2));
        try {
            if (res.get("error_code").equals(0)) {
                return (String)res.get("face_token");
            }else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String FaceDelete(String id,String token) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();

        String userId = id;
        String groupId = "student";
        String faceToken = token;

        // 人脸删除
        JSONObject res = client.faceDelete(userId, groupId, faceToken, options);
        System.out.println(res.toString(2));
        try {
            if (res.get("error_code").equals(0)) {
                return "success";
            }else{
                return (String)res.get("error_msg");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "exception";
        }
    }
}
