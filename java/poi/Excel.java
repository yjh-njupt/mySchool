package poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;

public class Excel {

    @Test
    public void demo()  {

        try {

            Workbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet();
            Cell cell = sheet.createRow(0).createCell(0);
            cell.setCellValue("10000");
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyle.setBorderBottom(BorderStyle.THIN);
            cellStyle.setBorderLeft(BorderStyle.THIN);
            cellStyle.setBorderRight(BorderStyle.THIN);
            cellStyle.setBorderTop(BorderStyle.THIN);
            Font font = workbook.createFont();
            font.setFontName("宋体");
            font.setFontHeightInPoints((short) 12);
            font.setBold(false);
            cellStyle.setFont(font);
            cell.setCellStyle(cellStyle);

            workbook.write(new FileOutputStream("D:\\cache\\idea\\mySchool\\src\\main\\java\\file\\工作簿2.3.xlsx"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void demo1(){
        Workbook workbook = null;
        try {
            FileInputStream fio2 = new FileInputStream("D:\\cache\\idea\\mySchool\\src\\main\\java\\file\\工作簿2.2.xlsx");
            workbook = new HSSFWorkbook(fio2);
            Sheet sheet = workbook.getSheetAt(0);
            int numMergedRegions = sheet.getNumMergedRegions();
            for (int i = 0; i < numMergedRegions; i++) {
                CellRangeAddress mergedRegion = sheet.getMergedRegion(i);
                int firstColumn = mergedRegion.getFirstColumn();
                int lastColumn = mergedRegion.getLastColumn();
                int firstRow = mergedRegion.getFirstRow();
                int lastRow = mergedRegion.getLastRow();
                System.out.println("firstColumn="+firstColumn+",lastColumn="+lastColumn+",firstRow="+firstRow+",lastRow="+lastRow);
                /*
                * firstColumn=10,lastColumn=10,firstRow=4,lastRow=5
firstColumn=0,lastColumn=9,firstRow=0,lastRow=9
firstColumn=11,lastColumn=12,firstRow=11,lastRow=12
firstColumn=10,lastColumn=11,firstRow=2,lastRow=3*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void demo2(){
        Workbook workbook = null;
        try {
            workbook = new HSSFWorkbook(new FileInputStream("D:\\cache\\idea\\mySchool\\src\\main\\java\\file\\工作簿2.3.xlsx"));
            Sheet sheet = workbook.getSheetAt(0);
            CellRangeAddress region = new CellRangeAddress(0, 9, 0, 9);
            //CellRangeAddress region = CellRangeAddress.valueOf("A1:E10");
            sheet.addMergedRegion(region);

            workbook.write(new FileOutputStream("D:\\cache\\idea\\mySchool\\src\\main\\java\\file\\工作簿2.2.xlsx"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (workbook == null) {
            throw new RuntimeException("error");
        }
    }
}
