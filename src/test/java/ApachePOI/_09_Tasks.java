package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 kullanicidan istedigi kolon sayisini aldiktan sonra asagidaki excelin 2. sheet inden istedigi kadar
 kolon miktarini alarak bir fonksiyonda ArrayListe cevirerek mainden yazdiriniz.
 src/test/java/ApachePOI/resources/ApacheExcel2.xlsx
 */
public class _09_Tasks {
    public static void main(String[] args) {
        String path = "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
        String sheetName = "testCitizen";

        System.out.print("Column number -> ");
        Scanner scStr = new Scanner(System.in);
        int columnCnt = scStr.nextInt();

        ArrayList<ArrayList<String>> infos = getInfoUntilColumn(path , sheetName , columnCnt);
        System.out.println(infos);

    }

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
}
