package util;

import net.sf.json.JSONObject;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReadJson {
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
            map.put(key,jsonObject.getString(key));
        }
        return map;
    }
}
