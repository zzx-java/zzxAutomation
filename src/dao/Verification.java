package dao;

import net.sf.json.JSONObject;
import util.ReadJson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Verification {
    //返回校验类型
    public int verificationAll(List<String> checkResult,List<String> check) {
        int type = 0;
        String checkResult_code = checkResult.get(0);
        String check_code = check.get(0);
        if (checkResult_code.equals(check_code)) {
            String checkResult_result = checkResult.get(1);
            String check_result = check.get(1);
            if (check_result == null) {
                type = 1;
            }else {
                JSONObject checkResult_object = JSONObject.fromObject(checkResult_result);
                JSONObject check_object = JSONObject.fromObject(check_result);
                if (jsonCompare(checkResult_object,check_object)) {
                    type = 1;
                }else {
                    type = 2;
                }
            }
        }
        else {
            type = 3;
        }
        return type;
    }
    //校验json判断条件是否一致
    public boolean jsonCompare(JSONObject checkResult_object,JSONObject check_object) {
        ReadJson readJson = new ReadJson();
        List<String> list = new ArrayList<>();
        JSONObject a = new JSONObject();
        JSONObject b = new JSONObject();
        String c = "";
        String d = "";
        Map<String,String> map = new HashMap<String,String>();
        map = readJson.getAllObgectKey(check_object);
        for (String key :
                map.keySet()) {
            list.add(key);
        }
        for (int i = 0; i < list.size(); i++) {
            String key = list.get(i);
            String[] keyList = key.split(".");
            for (int z = 0; z < keyList.length; z++) {
                if (z != (keyList.length - 1)) {
                    a = checkResult_object.getJSONObject(keyList[z]);
                    b = check_object.getJSONObject(keyList[z]);
                }
                else {
                    c = a.getString(keyList[z]);
                    d = b.getString(keyList[z]);
                }
            }
            if (c.equals(d)) {
                return true;
            }
        }
        return false;
    }
}
