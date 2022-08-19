package connection;

import dao.Verification;
import dao.GetJson;
import dao.HttpURLConnectionUtil;
import net.sf.json.JSONObject;
import util.ReadJson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetHttp {
    //获取json文件内容
    public JSONObject getTxt(String txtname) {
        String result = null;
        ReadJson readJson = new ReadJson();
        result= readJson.readJsonFile(txtname);
        JSONObject jsonObject = JSONObject.fromObject(result);
        return  jsonObject;
    }
    //获取接口参数发起请求
    public Map<String,String> getHttp(JSONObject jsonObject) {
        //获取jsonkey值
        GetJson getJson = new GetJson();
        //获取json文件中请求方法
        String method = null;
        method = getJson.getMethod(jsonObject);
        //获取json文件中请求类型
        String protocol = null;
        protocol = getJson.getProtocol(jsonObject);
        //获取json文件中请求ip
        String ip = null;
        ip = getJson.getIp(jsonObject);
        //获取json文件中请求端口
        String port = null;
        port = getJson.getPort(jsonObject);
        //获取json文件中请求路径
        String path = null;
        path = getJson.getPath(jsonObject);
        //获取json文件中请求头
        Map<String,String> header = null;
        header = getJson.getHeader(jsonObject);
        //获取json文件中请求参数
        String parameter = null;
        parameter = getJson.getParameter(jsonObject);
        //获取json文件中响应校验
        List<String> check = null;
        check = getJson.getCheck(jsonObject);
        //发起请求
        String url = null;
        //区分ip与url请求：端口为空
        if (port == "") {
            url = protocol + "://" + ip + "/" + path;
        }else {
            url = protocol + "://" + ip  + ":" + port + "/" + path;
        }
        Map<String,String> result = new HashMap<String,String>();
        HttpURLConnectionUtil httpURLConnectionUtil = new HttpURLConnectionUtil();
        List<String> checkResult =null;
        checkResult = HttpURLConnectionUtil.http(url,method,header,parameter);
        Verification verification = new Verification();
        int type = 0;
        type =verification.verificationAll(checkResult,check);
        result.put("type",String.valueOf(type));
        result.put("result",checkResult.get(1));
        return result;
    }
}
