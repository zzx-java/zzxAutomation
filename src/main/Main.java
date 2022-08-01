package main;

import connection.GetHttp;
import net.sf.json.JSONObject;
import util.GetFileName;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //获取文件路径下所有文件目录
        GetFileName getFileName = new GetFileName();
        //文件路径
        String route = "D:\\IdeaProjects\\untest01\\src\\test";
        List<String> txtList= getFileName.getFileName(route);
        if (txtList.size()!=0) {
            //请求文件目录下所有接口
            GetHttp getHttp = new GetHttp();
            for (int i = 0; i < txtList.size(); i++) {
                JSONObject jsonObject = getHttp.getTxt(route+"\\"+txtList.get(i));
                String result = getHttp.getHttp(jsonObject);
                System.out.println(txtList.get(i)+"请求结果：" +result);
            }
        }
        else {
            System.out.println("文件路径不存在！");
        }
        //result1 = HttpURLConnectionUtil.httpGet(url);
        //System.out.println("请求结果" + result1);

        /*
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

         */


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
