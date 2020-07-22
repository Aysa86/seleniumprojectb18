package test.office_hours;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;

public class ExcellIO {

    @Test
    public void readExcelFile(){

        try(FileInputStream fileInputStream = new FileInputStream("VytrackTestUsers.xlsx")){
          // XSSFWorkbook - to create an object of .xlsx file
          // HSSFWorkbook - to create an object of .xls file
          // Workbook - is an interface, that is implemented by XSSSFWorkbook and HSSFWorkbook
            Workbook workbook = WorkbookFactory.create(fileInputStream);

            // Object of sheet used to represent excel file page
            // because 1 excel document can have many spreadsheet
            Sheet sheet = workbook.getSheet("QA1-short");

            // read first row
            Row row = sheet.getRow(0);

            // read first cell
            Cell cell = row.getCell(0);

            // read value from 1st row 1st column

            System.out.println(cell);

            int columnNumber = row.getPhysicalNumberOfCells();

            //print every cell in the first row
            for (int i = 0; i < columnNumber; i++){
                System.out.print(row.getCell(i) + " ");
            }

            System.out.println();

            // to get number of rows
            int rowNumber = sheet.getPhysicalNumberOfRows();

            for (int i = 0; i < rowNumber; i++){
                System.out.print(sheet.getRow(i).getCell(0) + " ");
                System.out.print(sheet.getRow(i).getCell(1));
                System.out.print(sheet.getRow(i).getCell(2));
                System.out.print(sheet.getRow(i).getCell(3));
                System.out.println();
            }


            System.out.println("====================================================");


            // to print entire table

            for (int rowIndex = 0; rowIndex < rowNumber; rowIndex++  ){
                for (int columnIndex = 0; columnIndex < columnNumber; columnIndex++){
                    System.out.print(sheet.getRow(rowIndex).getCell(columnIndex) + " ");
                }
                System.out.println();
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
