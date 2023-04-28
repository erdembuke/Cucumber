package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _03_ApachePOI_Start {
    public static void main(String[] args) throws IOException {
        // dosyanin yolunu degiskene atalim

        String path = "src/test/java/ApachePOI/resource/test.xlsx";

        // JavaDosya okuma islemcisine dosyanin yolunu veriyoruz
        // boylece program ile dosya arasinda baglanti olustu
        FileInputStream fileReading = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileReading);

        // istedigim isimdeki calisma sayfasini aliyorum
        Sheet sheet = workbook.getSheet("Sayfa1");

        Row row = sheet.getRow(0);

        Cell cell = row.getCell(0);

        System.out.println(cell);



    }
}
