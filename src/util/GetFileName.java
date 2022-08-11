package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetFileName {
    public List<String> getFileName(String route) {
        File f = new File(route);
        //文件路径不存在打印错误日志
        if (!f.exists()) {
            return null;
        }
        File file[] = f.listFiles();
        List<String> txtList = new ArrayList<String>();
        for (int i = 0; i < file.length; i++) {
            File fs = file[i];
            if (!fs.isDirectory()) {
                txtList.add(fs.getName());
            }
        };
        return txtList;
    }
}
