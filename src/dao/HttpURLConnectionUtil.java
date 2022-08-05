package dao;

import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpURLConnectionUtil {
    //http请求
    public static List<String> http(String httpUrl, String method, Map<String,String> header, String parameter) {
        StringBuffer stringBuffer = new StringBuffer();
        HttpURLConnection httpURLConnection = null;
        OutputStream output = null;
        InputStream input = null;
        BufferedReader bufferedReader = null;
        String code = null;
        try {
            URL url = new URL(httpUrl);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            //设置请求方式
            httpURLConnection.setRequestMethod(method);
            //设置允许写出
            httpURLConnection.setDoOutput(true);
            //设置允许读出
            httpURLConnection.setDoInput(true);
            //设置连接超时时间
            httpURLConnection.setConnectTimeout(15000);
            //设置读取超时时间
            httpURLConnection.setReadTimeout(15000);
            //不使用缓存
            httpURLConnection.setUseCaches(false);
            //设置通用请求属性
            Iterator<String> keys = header.keySet().iterator();
            while (keys.hasNext()) {
                String key = keys.next();
                httpURLConnection.setRequestProperty(key,header.get(key));
            }
            //设置请求参数
            if (parameter != null && !parameter.equals("")) {
                output = httpURLConnection.getOutputStream();
                output.write(parameter.getBytes("UTF-8"));
            }
            //建立连接
            httpURLConnection.connect();
            //获取接口响应code
            code = new Integer(httpURLConnection.getResponseCode()).toString();
            //读取响应
            if (httpURLConnection.getResponseCode() == 200) {
                input = httpURLConnection.getInputStream();
                if (null != input) {
                    bufferedReader = new BufferedReader(new InputStreamReader(input,"UTF-8"));
                    String temp = null;
                    while (null != (temp = bufferedReader.readLine())) {
                        stringBuffer.append(temp);
                        stringBuffer.append("\r\n");
                    }
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭连接
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (output != null) {
                try {
                    output.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭连接
            httpURLConnection.disconnect();
        }
        List<String> checkResult = new ArrayList<String>();
        checkResult.add(code);
        String result = stringBuffer.toString();
        checkResult.add(result);
        return checkResult;
    }
}
