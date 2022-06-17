package main;

import connection.GetJson;
import connection.HttpURLConnectionUtil;
import net.sf.json.JSONObject;
import util.ReadJson;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //进行httpget请求
        /*
        String url = "https://api.kezhitech.com/homework-correct-admin-test/api/analysis/review/queryErrorReason?platform=1";
        String result = "";
        HttpURLConnectionUtil httpURLConnectionUtil = new HttpURLConnectionUtil();
        result = HttpURLConnectionUtil.httpGet(url);
        System.out.println("返回结果" + result);
         */
        //进行httppost请求
        /*
        String url = "http://47.94.133.234:10015/latexToSvg";
        String param= "{\"content\":\"4.\\\\(*\\\\)若收入5元记作+5元,则支出5元记作\",\"width\":612.587}";
        String result = "";
        HttpURLConnectionUtil httpURLConnectionUtil = new HttpURLConnectionUtil();
        result = HttpURLConnectionUtil.httpPost(url,param);
        System.out.println("请求结果" + result);
        */
        //读取txt文件
        String txtname = "D:\\\\IdeaProjects\\\\untest01\\\\src\\\\test\\\\testget.json";
        String result = null;
        ReadJson readJson = new ReadJson();
        result= readJson.readJsonFile(txtname);
        System.out.println(result);
        JSONObject jsonObject = JSONObject.fromObject(result);
        //获取jsonkey值
        GetJson getJson = new GetJson();
        //获取json文件中请求方法
        String method = null;
        method = getJson.getMethod(jsonObject);
        System.out.println(method);
        //获取json文件中请求类型
        String protocol = null;
        protocol = getJson.getProtocol(jsonObject);
        System.out.println(protocol);
        //获取json文件中请求ip
        String ip = null;
        ip = getJson.getIp(jsonObject);
        System.out.println(ip);
        //获取json文件中请求端口
        String port = null;
        port = getJson.getPort(jsonObject);
        System.out.println(port);
        //获取json文件中请求路径
        String path = null;
        path = getJson.getPath(jsonObject);
        System.out.println(path);
        //获取json文件中请求头
        Map<String,String> header = null;
        header = getJson.getHeader(jsonObject);
        //获取json文件中请求参数
        String parameter = null;
        parameter = getJson.getParameter(jsonObject);
        //发起请求
        String url = null;
        //区分ip与url请求：端口为空
        if (port == "") {
            url = protocol + "://" + ip + "/" + path;
        }else {
            url = protocol + "://" + ip  + ":" + port + "/" + path;
        }
        System.out.println("url:" + url);
        String result1 = "";
        HttpURLConnectionUtil httpURLConnectionUtil = new HttpURLConnectionUtil();
        result1 = HttpURLConnectionUtil.httpPost(url,method,header,parameter);
        System.out.println("请求结果" + result1);
        //断言
        JSONObject result2 = JSONObject.fromObject(result1);
        JSONObject result3 = result2.getJSONObject("data");
        System.out.println(result3.toString());
        JSONObject result4 = result3.getJSONObject("rightMid");
        System.out.println(result4.toString());
        String result5 = result4.getString("image");
        if (result5.equals("https://fanyiapp.cdn.bcebos.com/cms/image/1908390fe73dfb5890d98e3ec75f21f5.png")) {
            System.out.println("断言成功");
        }


        /*
        //进行httppost请求
        String url = null;
        url = protocol + "://" + ip + ":" + port + "/" + path;
        System.out.println("url:" + url);
        String param= "{\"content\":\"4.\\\\(*\\\\)若收入5元记作+5元,则支出5元记作\",\"width\":612.587}";
        String result1 = "";
        HttpURLConnectionUtil httpURLConnectionUtil = new HttpURLConnectionUtil();
        result1 = HttpURLConnectionUtil.httpPost(url,method,header,parameter);
        System.out.println("请求结果" + result1);
         */
    }
}
