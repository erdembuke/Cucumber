package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ExcelUtility {
    public static ArrayList<ArrayList<String>> getInfoUntilColumn(String path , String sheetName , int columnNo) {
        ArrayList<ArrayList<String>> info = new ArrayList<>();

        Sheet sheet = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(sheetName);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < columnNo; j++) {
                list.add(sheet.getRow(i).getCell(j).toString());
            }
            info.add(list);
        }

        return info;
    }

    public static void writeExcel(String path , Scenario scenario , String browserName) {
        // burada her bir senaryonun sonucu excel yazilacak
        File file = new File(path);
        // eger dosya yoksa asagidaki bölüm calissin

        if(!file.exists()) { // dosya yok ise
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
            XSSFSheet sheet = xssfWorkbook.createSheet("campusTest");
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue(scenario.getName());

            cell = row.createCell(1);
            cell.setCellValue(scenario.getStatus().toString()); // fail veya pass

            cell = row.createCell(2);
            cell.setCellValue(browserName);

            // file save
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                xssfWorkbook.write(fileOutputStream);
                xssfWorkbook.close();
                fileOutputStream.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }else {
            Sheet sheet = null;
            Workbook workbook = null;
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheet("campusTest");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Row row = sheet.createRow(sheet.getPhysicalNumberOfRows()); // en alt bos satiri ac

            Cell cell = row.createCell(0);
            cell.setCellValue(scenario.getName());

            cell = row.createCell(1);
            cell.setCellValue(scenario.getStatus().toString());

            cell = row.createCell(2);
            cell.setCellValue(browserName);

            // file save
            try {
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception e){
                System.out.println(e.getMessage());
                }
            }

        // eger dosya var ise asagidaki bölüm calissin

    }


}
