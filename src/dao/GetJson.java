package dao;

import com.google.gson.Gson;
import net.sf.json.JSONObject;
import util.ReadJson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetJson {

    //获取请求方法
    public String getMethod(JSONObject jsonObject) {
        String method = null;
        method = jsonObject.getString("method");
        return method;
    }
    //获取请求类型
    public String getProtocol(JSONObject jsonObject) {
        String protocol = null;
        protocol = jsonObject.getString("protocol");
        return protocol;
    }
    //获取域名或ip
    public String getIp(JSONObject jsonObject) {
        String ip = null;
        ip = jsonObject.getString("ip");
        return ip;
    }
    //获取端口号
    public String getPort(JSONObject jsonObject) {
        String port = null;
        port = jsonObject.getString("port");
        return port;
    }
    //获取路径
    public String getPath(JSONObject jsonObject) {
        String path = null;
        path = jsonObject.getString("path");
        return path;
    }
    //获取header信息
    public Map<String,String> getHeader(JSONObject jsonObject) {
        JSONObject headerJSONObject = jsonObject.getJSONObject("headers");
        ReadJson readJson = new ReadJson();
        return readJson.getAllObgectKey(headerJSONObject);
    }
    //获取parameter信息
    public String getParameter(JSONObject jsonObject) {
        JSONObject parameterJSONObject = jsonObject.getJSONObject("parameters");
        Gson gson = new Gson();
        String parameterString = gson.toJson(parameterJSONObject);
        if (parameterString.equals("{}")) {
            parameterString = null;
        }
        return parameterString;
    }
    //获取校验信息
    public List<String> getCheck(JSONObject jsonObject) {
        JSONObject checkJSONObject = jsonObject.getJSONObject("check");
        String code = checkJSONObject.getString("code");
        JSONObject result = checkJSONObject.getJSONObject("result");
        Gson gson = new Gson();
        String resultString = gson.toJson(result);
        if (resultString.equals("{}")) {
            resultString = null;
        }
        List<String>  check= new ArrayList<String>();
        check.add(code);
        check.add(resultString);
        return check;
    }
}
