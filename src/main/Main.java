package main;

import connection.GetHttp;
import connection.GetReport;
import net.sf.json.JSONObject;
import util.GetFileName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int success = 0;
        int fail = 0;
        int wrong = 0;
        //获取文件路径下所有文件目录
        GetFileName getFileName = new GetFileName();
        //文件路径
        String route = Thread.currentThread().getContextClassLoader().getResource("test").getPath();
        List<String> txtList= getFileName.getFileName(route);
        if (txtList.size()!=0) {
            //请求文件目录下所有接口
            GetHttp getHttp = new GetHttp();
            for (int i = 0; i < txtList.size(); i++) {
                JSONObject jsonObject = getHttp.getTxt(route+"\\"+txtList.get(i));
                Map<String,String> result = new HashMap<String,String>();
                result = getHttp.getHttp(jsonObject);
                switch (Integer.parseInt(result.get("type"))) {
                    case 1:
                        success = success+1;
                        break;
                    case 2:
                        fail = fail+1;
                        break;
                    case 3:
                        wrong = wrong+1;
                }
                System.out.println(txtList.get(i)+"请求响应类型：" +result.get("type"));
                System.out.println(txtList.get(i)+"请求响应结果：" +result.get("result"));
            }
        }
        else {
            System.out.println("文件路径不存在！");
        }
        GetReport getReport = new GetReport();
        getReport.outReport(success,fail,wrong);
    }
}
