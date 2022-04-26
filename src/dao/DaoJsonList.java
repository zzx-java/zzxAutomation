package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoJsonList {
    //解析json文件
    public List<String> jsonList = new ArrayList<>();

    public void AddJsonList(String keys) {
        this.jsonList.add(keys);
    }
}
