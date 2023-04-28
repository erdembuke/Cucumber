package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _06_WriteInTheExcel {
    public static void main(String[] args) throws IOException {
        // once excel i acarim , sheete ulasirim
        // yazma islemlerimi eklerim (hafizada)
        // hafizadaki islemleri kaydederim

        String path = "src/test/java/ApachePOI/resource/WriteInExcel.xlsx";

        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        // hafizada islemlere devam ediyorum
        Row row = sheet.createRow(sheet.getPhysicalNumberOfRows()); // her calistiginda yeni satir acicak
        Cell cell = row.createCell(0);
        cell.setCellValue("hello erd");

        // kaydetme islemi yapacagim , ama once okuma modundan cikip yazma moduna gececegim
        inputStream.close(); // okuma modu kapatildi
        FileOutputStream outputStream = new FileOutputStream(path); // yazma modu acildi
        workbook.write(outputStream); // save islemi yapildi
        workbook.close(); // hafizayi bosalt
        outputStream.close(); // hafizayi bosalt.

        System.out.println("yazma islemi tamamlandi");
    }
}
