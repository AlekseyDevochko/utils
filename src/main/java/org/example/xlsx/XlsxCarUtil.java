package org.example.xlsx;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class XlsxCarUtil {

    public static List<Car> loadCars(String filePath){
        List<Car> cars = new ArrayList<>();

        try (InputStream in = new FileInputStream("D:\\st-gr-J2022\\cars_table.xlsx");) {
            Workbook wb;
            if (filePath.endsWith(".xlsx")) {
                wb = new XSSFWorkbook(in);
            } else if (filePath.endsWith(".xls")) {
                wb = new HSSFWorkbook(in);
            } else {
                throw new IllegalArgumentException("Incorrect format!" + filePath + ". Expected MS Excel format");
            }

            int number = wb.getNumberOfSheets();
            for (int sheetNum = 0; sheetNum < number; sheetNum++) {
                Sheet sheet = wb.getSheetAt(sheetNum);
                System.out.println("Processing: ");
                Iterator<Row> rowIter = sheet.rowIterator();
                while(rowIter.hasNext()){
                    Row row = rowIter.next();
                    int rowNum = row.getRowNum();
                    System.out.println("Row #" + rowNum);
                    if (rowNum == 0) {
                        continue;
                    }
                    int id = (int) row.getCell(0).getNumericCellValue();
                    String model = (String) row.getCell(1).getStringCellValue();
                    double price = (double) row.getCell(2).getNumericCellValue();
                    Date date = row.getCell(3).getDateCellValue();

                    Car car = new Car(id, model, price, date);
                    System.out.println(car);
                    cars.add(car);

                }
            }


            //System.out.println("Processing: " + sheet.getSheetName());




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        return cars;
    }

    public static void writeCars(String filePath, List<Car> cars){
        Workbook wb;
        if (filePath.endsWith(".xlsx")) {
            wb = new XSSFWorkbook();
        } else if (filePath.endsWith(".xls")) {
            wb = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("Incorrect format!" + filePath + ". Expected MS Excel format");
        }


        Sheet sheet = wb.createSheet("Cars");
        int rownum = 0;
        Row header = sheet.createRow(rownum);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("MODEL");
        header.createCell(2).setCellValue("PRICE");
        header.createCell(3).setCellValue("DATE");

        for (Car car :
                cars) {
            rownum++;
            Row row = sheet.createRow(rownum);
            row.createCell(0).setCellValue(car.getId());
            row.createCell(1).setCellValue(car.getModel());
            row.createCell(2).setCellValue(car.getPrice());
            row.createCell(3).setCellValue(car.getDate());

        }

        try (OutputStream out = new FileOutputStream(filePath)) {
            wb.write(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
