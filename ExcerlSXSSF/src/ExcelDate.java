


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Mr.zhoukx
 * @Date: 2018/11/27 17:39
 * @Description: 描述
 */
@WebServlet("/Excerl")
public class ExcelDate extends HttpServlet {


    /**
     *
     * 功能描述:  大批量数据导出
     *          运行在内存当中 会占用内存  造成内存溢出
     *          此方法不会再浏览器上抛出流
     *
     * @param: [req, response]
     * @return: void
     * @auther: Mr.zhoukx
     * @date: 2018/11/28 17:42
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        // 第一步：创建一个工作簿 -1：关闭自动刷新
        // SXSSFWorkbook wb = new SXSSFWorkbook(XXXX);（自动刷新） 保持内存中有XXXX条记录，超过部分写入磁盘
        SXSSFWorkbook wb = new SXSSFWorkbook(-1); // turn off auto-flushing and accumulate all rows
        // in memory
        // 第二步：创建一个工作表 创建一个sheet
        Sheet sh = wb.createSheet();

        //模板数据
        Object[] datas = {"餐企名称", "经营许可号", "餐饮地址", "负责人", "巡查员", "监管所", "巡查时间","无法检查原因","其他原因"};
       //创建表头数据
        Row row = sh.createRow(0);
        for(int i = 0 ;i<datas.length; i++){
            Cell cell = row.createCell(i);
            cell.setCellValue((String) datas[i]);
        }

        // 这个是数据的
        List<Map<String,String>> list = new ArrayList<Map<String, String>>();
        //做数据
        Map<String,String> maps  = new HashMap<String, String>();
        for(int  j = 0 ;j < 1000 ; j++){
            maps.put("ENTNAME","ENTNAME"+j);
            maps.put("LICENSE_NO","ENTNAME"+j);
            maps.put("DOM","ENTNAME"+j);
            maps.put("LEREPNAME","ENTNAME"+j);
            maps.put("PERNAME","ENTNAME"+j);
            maps.put("JGS_NAME","ENTNAME"+j);
            maps.put("FINISHDATE","ENTNAME"+j);
            maps.put("UNEXECUTEREASON","ENTNAME"+j);
            list.add(maps);

        }
        long startTime = System.currentTimeMillis(); //获取开始时间

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


            cell = rows.createCell(1);
            cell.setCellValue(map.get("LICENSE_NO"));


            cell = rows.createCell(2);
            cell.setCellValue(map.get("DOM"));

            cell = rows.createCell(3);
            cell.setCellValue(map.get("LEREPNAME"));


            cell = rows.createCell(4);
            cell.setCellValue(map.get("PERNAME"));


            cell = rows.createCell(5);
            cell.setCellValue(map.get("JGS_NAME"));

            cell = rows.createCell(6);
            cell.setCellValue(map.get("FINISHDATE"));


            cell = rows.createCell(7);
            cell.setCellValue(map.get("UNEXECUTEREASON"));


            cell = rows.createCell(8);
            cell.setCellValue(map.get("UNEXECUTEOTHERREASON"));


            number ++ ;
            // manually control how rows are flushed to disk
           if (number % 500 == 0) {// 500行写一次

                //第六步：将内容写入磁盘  由于-1设置关闭自动刷新 需要人工主动刷新  调用：
                ((SXSSFSheet) sh).flushRows(500); // retain 100 last rows and flush all others
                // Thread.sleep(1000);
                System.out.println("执行次数");
                // ((SXSSFSheet)sh).flushRows() is a shortcut for ((SXSSFSheet)sh).flushRows(0),
                // this method flushes all rows
            }
        }

        FileOutputStream out  = null;


        try {
            out = new FileOutputStream("d:/周凯旋.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

             //第七步：输出文件
             wb.write(out);// 将临时文件合并，写入最终文件
             // g关闭资源
             out.close();
             // 关闭窗体会释放该窗体的占用的部分资源
             wb.dispose();
             System.out.print("执行王弼");
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间

    }


    }



