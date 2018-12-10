/*
package Excerl;

import jxl.Workbook;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.apache.poi.hssf.usermodel.*;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

*/
/**
 * @Auther: kaixuan
 * @Date: 2018/11/12 11:57
 * @Description:
 *//*

@WebServlet(description = "a enter for wechat", urlPatterns = { "/aaa"},loadOnStartup=1)
public class Excerl  extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        try {
            downloadExcel(req,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/view/Excerl.jsp");
    }


   */
/**
    *
    * 功能描述: 
    *
    * @param: excel  导出  模板下载
    * @return: 
    * @auther: kaixuan
    * @date: 2018/11/12 13:05
    *//*

    public  void  downloadExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {
        //创建excerl对象
        HSSFWorkbook excerl = new HSSFWorkbook();

        //创建具体的excerl工作表  名为工作文档1
        HSSFSheet  workExcerl = excerl.createSheet("工作文档1");

        //添加excerl 表头
        HSSFRow  header = workExcerl.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = excerl.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        //声明列对象
        HSSFCell cell = null;

        //创建
        String [] title ={"姓名","年龄","性别"};

        //创建标题
        for(int i=0;i<title.length;i++){
            cell = header.createCell(i);
            cell.setCellValue(title[i]);  // 设置值
            cell.setCellStyle(style);  //设置居中
        }

        String [][] values ={{"冯建超","25","男"},{"冯建","23","女"}};
        //创建内容
        for(int i=0;i<values.length;i++){
            header = workExcerl.createRow(i + 1);
            for(int j=0;j<values[i].length;j++){
                //将内容按顺序赋给对应的列对象
                header.createCell(j).setCellValue(values[i][j]);
            }
        }

        //输出  建立 byte缓冲数组
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        excerl.write(os);

        //在流转换成数租
        byte[] content = os.toByteArray();
        //输入流
        InputStream is = new ByteArrayInputStream(content);

        //设置响应数据
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=A.xls");

        //响应数据
        ServletOutputStream out = response.getOutputStream();

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        bis = new BufferedInputStream(is);
        bos = new BufferedOutputStream(out);
        byte[] buff = new byte[2048];
        int bytesRead;
        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
            bos.write(buff, 0, bytesRead);
        }


        bos.close();

        //保存在固定的路径下
        excerl.write(new FileOutputStream("D:/A.xls"));


    }

}
*/
