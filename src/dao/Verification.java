package dao;

import net.sf.json.JSONObject;
import util.ReadJson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Verification {
    public int verificationAll(List<String> checkResult,List<String> check) {
        int type = 0;
        String checkResult_code = checkResult.get(0);
        String check_code = check.get(0);
        if (checkResult_code.equals(check_code)) {
            String checkResult_result = checkResult.get(1);
            String check_result = check.get(1);
            JSONObject checkResult_object = JSONObject.fromObject(checkResult_result);
            JSONObject check_object = JSONObject.fromObject(check_result);
            if (jsonCompare(checkResult_object,check_object)) {
                type = 1;
            }else {
                type = 2;
            }
        }
        else {
            type = 3;
        }
        return type;
    }
    public boolean jsonCompare(JSONObject checkResult_object,JSONObject check_object) {
        ReadJson readJson = new ReadJson();
        Map<String,String> map = new HashMap<String,String>();
        map = readJson.getAllObgectKey(check_object);
        for (String key :
                map.keySet()) {
            List<String> list = null;

        }
        return true;
    }
}
