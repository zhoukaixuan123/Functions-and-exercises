package Excerl;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

public class DtExcerl {


    /**
     * 动态导出  Excerl
     *
     * @param response
     * @return
     * @throws IOException
     */
 /*   public String    getExcerl(HttpServletResponse response)throws IOException {
        try {


            HSSFWorkbook wb = new HSSFWorkbook();  //创建Excerl对象

            HSSFSheet sheet = wb.createSheet("餐企巡查");  //创建table工作薄
            sheet.setDefaultColumnWidth(15);
            sheet.setDefaultRowHeight((short)10);

            // 生成一个样式
            HSSFCellStyle style = wb.createCellStyle();


            style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平



            *//**字体begin*//*
            style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
            *//*设置字体*//*
            HSSFFont font=wb.createFont();
            font.setColor(HSSFColor.RED.index);//HSSFColor.VIOLET.index?//字体颜色
            font.setFontHeightInPoints((short)12);
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//字体增粗
            style.setFont(font);

            //模板数据
            Object [] datas = {"餐企名称", "经营许可号", "餐饮地址","负责人","巡查员","监管所","巡查时间"};



            //创建行
            HSSFRow row = sheet.createRow(0);
            row.setRowStyle(style);
            //创建单元格
            HSSFCell cell = null;
            for (int i = 0; i < datas.length; i++) {
                cell = row.createCell(i);
                cell.setCellStyle(style);
                cell.setCellValue((String)datas[i]);//设置值
            }
            //消息主题
       *//* Pager pager = dao.getPager("commontask.cqxc_list", "commontask.cqxc_list_count", null);
        List<Map<String,String>> list = pager.getResultList();*//*
            List<Map<String,String>> list  = dao.queryObjectList("commontask.Excerl_list");


            //将主体数据填入Excel中
            for (int i = 0; i<list.size();i++) {
                row = sheet.createRow(i + 1);
                Map<String,String> map = list.get(i);

                cell = row.createCell(0);
                cell.setCellValue( map.get("ENTNAME"));
                cell = row.createCell(1);
                cell.setCellValue( map.get("LICENSE_NO"));
                cell = row.createCell(2);
                cell.setCellValue( map.get("DOM"));
                cell = row.createCell(3);
                cell.setCellValue( map.get("LEREPNAME"));
                cell = row.createCell(4);
                cell.setCellValue( map.get("PERNAME"));
                cell = row.createCell(5);
                cell.setCellValue( map.get("JGS_NAME"));
                cell = row.createCell(6);
                cell.setCellValue( map.get("FINISHDATE"));




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
            wb.write(new FileOutputStream("D:/餐企巡查.xls"));


        }catch (Exception e ){
            e.printStackTrace();
            return "message";
        }
        return  null;
    }*/
}
