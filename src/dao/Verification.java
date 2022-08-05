package dao;

import net.sf.json.JSONObject;

import java.util.List;

public class Verification {
    public void verificationAll(List<String> checkResult,List<String> check) {
        int type = 0;
        String checkResult_code = checkResult.get(0);
        String check_code = check.get(0);
        if (checkResult_code.equals(check_code)) {
            String checkResult_result = checkResult.get(1);
            String check_result = check.get(1);
            JSONObject checkResult_object = JSONObject.fromObject(checkResult_result);
            JSONObject check_object = JSONObject.fromObject(check_result);
        }
        else {
            type = 3;
        }
    }
}
