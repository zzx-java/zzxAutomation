package connection;

import dao.GenerateReport;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class GetReport {
    public void outReport() {
        GenerateReport generateReport = new GenerateReport();
        String route = "";
        System.out.println(route);
        //创建测试报告
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(route+"//test.html"),false);
            printStream.println(generateReport.enerate().toString());
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
