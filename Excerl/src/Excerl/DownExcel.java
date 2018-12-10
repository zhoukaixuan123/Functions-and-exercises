package Excerl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


/**
 * @Auther: kaixuan   Excerl  导出功能能    模板
 * @Date: 2018/11/12 14:28
 * @Description:
 */

@WebServlet("/DownExcel")
public class DownExcel extends HttpServlet {
    private static final long serialVersionUID = 1L;



    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        @SuppressWarnings("resource")
        HSSFWorkbook wb = new HSSFWorkbook();  //创建Excerl对象

        HSSFSheet sheet = wb.createSheet("table");  //创建table工作薄

        //模板数据
        Object[][] datas = {{"区域", "总销售额(万元)", "总利润(万元)简单的表格"}, {"江苏省" , 9045,  2256}, {"广东省", 3000, 690}};
        //创建行
        HSSFRow row;
        //创建单元格
        HSSFCell cell;
        for(int i = 0; i < datas.length; i++) {
            row = sheet.createRow(i);//创建表格行
            for(int j = 0; j < datas[i].length; j++) {
                cell = row.createCell(j);//根据表格行创建单元格
                cell.setCellValue(String.valueOf(datas[i][j]));
            }
        }
        //输出  建立 byte缓冲数组
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        wb.write(os);

        //转换成数组
        byte[] content = os.toByteArray();
        //输入流
        InputStream is = new ByteArrayInputStream(content);

        //设置响应数据
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=table.xls");

        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        //保存在固定的路径下
         wb.write(new FileOutputStream("D:/table.xls"));
    }

}
