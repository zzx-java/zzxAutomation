package dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class GenerateReport {
    //填充测试报告
    public StringBuilder enerate() {
        //存储html字符串
        StringBuilder stringHtml = new StringBuilder();

        //填充测试报告内容
        stringHtml.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n");
        stringHtml.append("    <meta charset=\"utf-8\">\n");
        //报告标题
        stringHtml.append("    <title>测试报告</title>\n");
        stringHtml.append("</head>\n" +
                "<script>\n");
        //按钮跳转界面逻辑
        stringHtml.append("    function btn_success() {\n" +
                "        var show_case = document.getElementById(\"show_case\");\n" +
                "        show_case.innerHTML=\"<span>成功</span>\"\n" +
                "    }\n" +
                "    function btn_fail() {\n" +
                "        var show_case = document.getElementById(\"show_case\");\n" +
                "        show_case.innerHTML=\"<span>失败</span>\"\n" +
                "    }\n" +
                "    function btn_wrong() {\n" +
                "        var show_case = document.getElementById(\"show_case\");\n" +
                "        show_case.innerHTML=\"<span>错误</span>\"\n" +
                "    }\n");

        stringHtml.append("</script>\n");
        stringHtml.append("<body>\n");
        //标题目录
        stringHtml.append("<div style=\"background: darkgray;height: 50px\">\n" +
                "    <p style=\"text-align: center\">自动化测试报告</p>\n" +
                "</div>\n");
        //统计信息
        stringHtml.append("<div style=\"text-align: center\">\n" +
                "    <div style=\"display: inline-block\">\n" +
                "        <div>\n" +
                "            <p>测试信息统计</p>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <table>\n" +
                "                <tr>\n" +
                "                    <td>测试用例数</td>\n" +
                "                    <td>50</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>通过</td>\n" +
                "                    <td>50</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>失败</td>\n" +
                "                    <td>50</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>错误</td>\n" +
                "                    <td>50</td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n");
        //测试用例
        stringHtml.append("<div>\n" +
                "    <!-- 用例tab栏 -->\n" +
                "    <div>\n" +
                "        <button onclick=\"btn_success()\">成功</button>\n" +
                "        <button onclick=\"btn_fail()\">失败</button>\n" +
                "        <button onclick=\"btn_wrong()\">错误</button>\n" +
                "    </div>\n" +
                "    <!-- 用例列表 -->\n" +
                "    <div id =\"show_case\">\n" +
                "        <span>成功</span>\n" +
                "    </div>\n" +
                "</div>\n");
        stringHtml.append("</body>\n" +
                "</html>");

        return stringHtml;
    }

}
