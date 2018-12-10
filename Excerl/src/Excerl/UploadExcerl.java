package Excerl;







import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: kaixuan   Excerl  导入   简单解析
 * @Date: 2018/11/12 15:04
 * @Description:
 */
@WebServlet("/upload")
public class UploadExcerl extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取上传文件的保存路径
        String  excerlFile ="D:\\table.xls";

        //判断   是不是按要求上传
        if(excerlFile.endsWith(".xls")){
            List temp = new ArrayList();
            FileInputStream fileIn = new FileInputStream(excerlFile);
            //根据指定的文件输入流导入Excel从而产生Workbook对象
            Workbook wb0 = new HSSFWorkbook(fileIn);
            //获取Excel文档中的第一个表单
            Sheet sht0 = wb0.getSheetAt(0);
            //对Sheet中的每一行进行迭代
            for (Row r : sht0) {
                //如果当前行的行号（从0开始）未达到2（第三行）则从新循环
                //不解析第一行
               if(r.getRowNum()<1){
                    continue;
                }

               //取出当前行第1个单元格数据，并且打印输出
                System.out.print(r.getCell(0).getStringCellValue());
                System.out.print(r.getCell(1).getStringCellValue());
                System.out.print(r.getCell(2).getStringCellValue());


            }
            fileIn.close();

        }

    }


}
