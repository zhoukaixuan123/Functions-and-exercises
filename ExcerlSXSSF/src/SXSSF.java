import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Mr.zhoukx
 * @Date: 2018/11/29 12:01
 * @Description: 描述
 *   大批量导出实例教程   poi 3.9 版本
 *    自动调整空值报异常
 *    所需包：
 *    poi-3.9.jar
 *    poi-ooxml-3.9.jar
 *    poi-ooxml-schemas-3.9.jar
 *    poi-scratchpad-3.9.jar
 *    dom4j-1.6.1.jar
 *
 */
public class SXSSF {

    /**
     * Excerl 导出 封装
     */
    public String getExcerl(HttpServletResponse response)  {

        //jar包判断用来调试
       /* ClassLoader classloader = org.apache.poi.poifs.filesystem.POIFSFileSystem.class.getClassLoader();
        java.net.URL res = classloader.getResource("org/apache/poi/poifs/filesystem/POIFSFileSystem.class");
        String path = res.getPath();
        System.out.println("poi来自哪个包 "+path);*/



        //Excerl内容  sql 查询
        List<Map<String, String>> list =  null ;
                 //list =dao.queryObjectList("commontask.Excerl_list");
        long startTime = System.currentTimeMillis(); //获取开始时间
        try {
            // 第一步：创建一个工作簿 -1：关闭自动刷新
            // SXSSFWorkbook wb = new SXSSFWorkbook(XXXX);（自动刷新） 保持内存中有XXXX条记录，超过部分写入磁盘
            SXSSFWorkbook wb = new SXSSFWorkbook(-1); // turn off auto-flushing and accumulate all rows
            // in memory
            // 第二步：创建一个工作表 创建一个sheet
            Sheet sh = wb.createSheet();

            // 标题样式
            CellStyle style = wb.createCellStyle();
            style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平

            //正文样式
            CellStyle body = wb.createCellStyle();
            body.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
            body.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平

            //**字体begin*//*
            style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
            //*设置字体*//*
            Font font = wb.createFont();
            font.setColor(HSSFColor.RED.index);//HSSFColor.VIOLET.index?//字体颜色
            font.setFontHeightInPoints((short) 12);
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//字体增粗
            style.setFont(font);

            //模板数据
            Object[] datas = {"餐企名称", "经营许可号", "餐饮地址", "负责人", "巡查员", "监管所", "巡查时间","无法检查原因","其他原因"};
            //创建表头数据
            Row row = sh.createRow(0);
            for(int i = 0 ;i<datas.length; i++){
                Cell cell = row.createCell(i);
                cell.setCellValue((String) datas[i]);
                cell.setCellStyle(style);

            }

            //以下是设置内容
            //初始化列对象
            Cell cell = null;
            //记录数据行书
            int  number = 0 ;
            //主体数据
            for(int i = 0 ;i <list.size() ;i++ ) {
                //创建行
                Row rows = sh.createRow(i+1);
                Map<String,String> map = list.get(i);

                cell = rows.createCell(0);
                cell.setCellValue(map.get("ENTNAME"));
                cell.setCellStyle(body);



                cell = rows.createCell(1);
                cell.setCellValue(map.get("LICENSE_NO"));
                cell.setCellStyle(body);




                cell = rows.createCell(2);
                cell.setCellValue(map.get("DOM"));
                cell.setCellStyle(body);


                cell = rows.createCell(3);
                cell.setCellValue(map.get("LEREPNAME"));
                cell.setCellStyle(body);



                cell = rows.createCell(4);
                cell.setCellValue(map.get("PERNAME"));
                cell.setCellStyle(body);



                cell = rows.createCell(5);
                cell.setCellValue(map.get("JGS_NAME"));
                cell.setCellStyle(body);


                cell = rows.createCell(6);
                cell.setCellValue(map.get("FINISHDATE"));
                cell.setCellStyle(body);



                cell = rows.createCell(7);
                cell.setCellValue(map.get("UNEXECUTEREASON"));
                cell.setCellStyle(body);



                cell = rows.createCell(8);
                cell.setCellValue(map.get("UNEXECUTEOTHERREASON"));
                cell.setCellStyle(body);


                number ++ ;
                // manually control how rows are flushed to disk
                if (number % 1000 == 0) {// 500行写一次

                    //第六步：将内容写入磁盘  由于-1设置关闭自动刷新 需要人工主动刷新  调用：
                    ((SXSSFSheet) sh).flushRows(500); // retain 100 last rows and flush all others
                    // Thread.sleep(1000);
                    System.out.println("执行次数");
                    // ((SXSSFSheet)sh).flushRows() is a shortcut for ((SXSSFSheet)sh).flushRows(0),
                    // this method flushes all rows
                }
            }
            try {

                //autoSizeColumn  当导入的数据为空时  会发生空指针异常
                //调整列宽 因为  这个方法 便利所有列  所以拿出来最后执行
                sh.autoSizeColumn(0,true);  //自动调整单元格大小
                sh.autoSizeColumn(1,true);  //自动调整单元格大小
                sh.autoSizeColumn(2,true);  //自动调整单元格大小
                sh.autoSizeColumn(3,true);  //自动调整单元格大小
                sh.setColumnWidth(4,3000);  //自动调整单元格大小
                sh.setColumnWidth(6,5000);  //自动调整单元格大小
                sh.setColumnWidth(7,5000);  //自动调整单元格大小
                sh.setColumnWidth(8,5000);  //自动调整单元格大小
            }catch (Exception e){
                e.printStackTrace();
            }

            //输出  建立 byte缓冲数组
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            wb.write(os);

            //转换成数组
            byte[] content = os.toByteArray();
            //输入流
            InputStream is = new ByteArrayInputStream(content);

            //设response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=table.xls");

            ServletOutputStream out = response.getOutputStream();
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null; //置响应数据

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
            }finally {
                if (bis != null)
                    bis.close();
                if (bos != null)
                    bos.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间
        return  null;
    }


}
