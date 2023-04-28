package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *  kullanici asagidaki excelde , 1. sutundaki bilgilerden istedigini girecek
 *  karsiliginda bu bilginin satirindaki karsilik gelen bilgilerin tamami yazdirilacak
 *  yani metoda password kelimesi gonderilecek , donen deger password un degeri olacak
 *  bulup ve sonucun dondurulmesi icin metod kullaniniz
 *  src/test/java/ApachePOI/resources/LoginData.xlsx
 */
public class _05_GetASpecificData {

    public static void main(String[] args) {
        System.out.print("Aranacak kelimeyi girin -> ");
        Scanner scStr = new Scanner(System.in);
        String word = scStr.nextLine();

        String infos = getInformation(word);

        System.out.println(infos);
    }


    public static String getInformation(String data) {
        String result="";
        // excelden okuma islemi

        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";

        Sheet sheet = null;

        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheetAt(0);

        }catch (Exception e){
            System.out.println("could not found !");
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

            if (sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(data)){
                for (int j = 1; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                    result += sheet.getRow(i).getCell(j) + " / ";
                }
            }else result = "could not found";

        }


        return result;


    }
}
