package connection;

import dao.GenerateReport;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class GetReport {
    public void outReport(int s,int f,int w) {
        GenerateReport generateReport = new GenerateReport();
        String route = Thread.currentThread().getContextClassLoader().getResource("report").getPath();
        //创建测试报告
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(route+"//test.html"),false);
            printStream.println(generateReport.enerate(s,f,w).toString());
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
