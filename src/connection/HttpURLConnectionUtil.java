package connection;

import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;

public class HttpURLConnectionUtil {

    //httpget请求
    public static String httpGet(String httpUrl) {
        //输出传递参数
        System.out.println("传递参数url:" + httpUrl);
        //创建结果对象
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        StringBuffer result = new StringBuffer();
        try {
            //创建连接
            URL url = new URL(httpUrl);
            connection = (HttpURLConnection) url.openConnection();
            //设置请求方式
            connection.setRequestMethod("GET");
            //设置连接超时时间
            connection.setReadTimeout(15000);
            //添加header信息
            connection.setRequestProperty("accessToken","eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ6aGFuZ3ppeGluIiwiYXVkIjoiMTc0MDAzMTU5NTY0Mjg5IiwiZXhwIjoxNjQ0OTI5NzExfQ.PCAdyJJPwBdpYuXoTaKq9luYkvPJ1LS-9aXARqLOoYI");
            //开始连接
            connection.connect();
            //获取响应数据
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                if (null != is) {
                    br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
                    String temp =null;
                    while (null != (temp = br.readLine())) {
                        result.append(temp);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭远程连接
            connection.disconnect();
        }
        return result.toString();
    }

    //httppost请求
    public static String httpPost(String httpUrl, String method, Map<String,String> header, String parameter) {
        StringBuffer stringBuffer = new StringBuffer();
        HttpURLConnection httpURLConnection = null;
        OutputStream output = null;
        InputStream input = null;
        BufferedReader bufferedReader = null;
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
            if (parameter != null && parameter.equals("")) {
                output = httpURLConnection.getOutputStream();
                output.write(parameter.getBytes("UTF-8"));
            }
            //建立连接
            httpURLConnection.connect();
            //读取响应
            if (httpURLConnection.getResponseCode() == 200) {
                input = httpURLConnection.getInputStream();
                if (null != input) {
                    bufferedReader = new BufferedReader(new InputStreamReader(input,"GBK"));
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
        return stringBuffer.toString();
    }
}
