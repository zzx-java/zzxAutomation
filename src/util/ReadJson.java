package util;

import dao.DaoJsonList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReadJson {
    public DaoJsonList daoJsonList;
    //构造方法
    public ReadJson() {
        daoJsonList = new DaoJsonList();
    }
    //读取json文件
    public static String readJsonFile(String filePath) {
        String jsonStr = null;
        try {
            File jsonFile = new File(filePath);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "UTF-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    //递归读取所有key(JSONObject)
    public Map<String,String> getAllObgectKey(JSONObject jsonObject) {
        Map<String,String> map = new HashMap<String,String>();
        //迭代器获取json的keys
        Iterator<String> keys = jsonObject.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            System.out.println(key);
            map.put(key,jsonObject.getString(key));
        }
        return map;
    }
}
