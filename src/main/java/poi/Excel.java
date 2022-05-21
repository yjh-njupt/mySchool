package poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Excel {

    @Test
    public void demo()  {

        try {
            FileInputStream fio1 = new FileInputStream("D:\\cache\\idea\\mySchool\\src\\main\\java\\file\\SDFsdf.xls");
            FileInputStream fio2 = new FileInputStream("D:\\cache\\idea\\mySchool\\src\\main\\java\\file\\新建 XLSX 工作表.xlsx");
            HSSFWorkbook hssf1 = new HSSFWorkbook(fio1);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
            fio1.close();
            fio2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
