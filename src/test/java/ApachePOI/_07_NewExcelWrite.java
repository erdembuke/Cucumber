package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class _07_NewExcelWrite {
    public static void main(String[] args) throws IOException {
        // hafizada workbook ve sheet ini olusturacagim
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("Sheet1");

        // hafizada islemlere devam ediyorum
        Row row = xssfSheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("hello excel");

        // path verip save islemlerine basliyorum

        String path = "src/test/java/ApachePOI/resource/createdExcel07.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        xssfWorkbook.write(outputStream);
        xssfWorkbook.close();
        outputStream.close();

        System.out.println("Dosya olusturuldu");
    }
}
