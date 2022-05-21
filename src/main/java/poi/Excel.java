package poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;

public class Excel {

    @Test
    public void demo()  {

        try {
            FileInputStream fio1 = new FileInputStream("D:\\cache\\idea\\mySchool\\src\\main\\java\\file\\SDFsdf.xls");
            FileInputStream fio2 = new FileInputStream("D:\\cache\\idea\\mySchool\\src\\main\\java\\file\\工作簿1.xlsx");
            HSSFWorkbook hssf1 = new HSSFWorkbook(fio1);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
            fio1.close();
            fio2.close();
            System.out.println("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void demo1(){
        Workbook workbook = null;
        try {
            FileInputStream fio2 = new FileInputStream("D:\\cache\\idea\\mySchool\\src\\main\\java\\file\\工作簿1.xlsx");
            workbook = WorkbookFactory.create(fio2);
            fio2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (workbook == null) {
            throw new RuntimeException("error");
        }

    }

    @Test
    public void demo2(){
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(new File("D:\\cache\\idea\\mySchool\\src\\main\\java\\file\\工作簿1.xlsx"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (workbook == null) {
            throw new RuntimeException("error");
        }
    }
}
