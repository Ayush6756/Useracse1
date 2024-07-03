package com.Erail.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static final String EXCEL_PATH = System.getProperty("user.dir") + "/src/test/resources/Data.xlsx";

 //   public ArrayList<String> getData(String stationName) throws IOException {
 //      FileInputStream file = new FileInputStream(EXCEL_PATH);
//        XSSFWorkbook workbook = new XSSFWorkbook(file);
//        ArrayList<String> data = new ArrayList<>();
//        int sheets = workbook.getNumberOfSheets();
//
//        for (int i = 0; i < sheets; i++) {
//            if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
//                XSSFSheet sheet = workbook.getSheetAt(i);
//                Iterator<Row> rows = sheet.iterator();
//                Row firstRow = rows.next();
//                Iterator<Cell> cells = firstRow.cellIterator();
//                int k = 0;
//                int column = 0;
//                while (cells.hasNext()) {
//                    Cell cell = cells.next();
//                    if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
//                        column = k;
//                    }
//                    k++;
//                }
//                while (rows.hasNext()) {
//                    Row row = rows.next();
//                    data.add(row.getCell(column).getStringCellValue());
//                }
//            }
//        }
//        workbook.close();
//        return data;
    public ArrayList<String> getData(String stationName) throws IOException {
		// Step 1> Create object of XSSFWorkbook class----> This will keep hold on the
		// excel sheet
		FileInputStream fil = new FileInputStream(EXCEL_PATH);
		XSSFWorkbook workbook = new XSSFWorkbook(fil);

		ArrayList<String> a = new ArrayList<String>();

		// Step 2> Get access to sheet
		int sheets = workbook.getNumberOfSheets(); // count no. of sheets in the excel, it will help in traversing
													// across the sheet
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("ExpectedData")) { // this will help in comparing with the
																				// exact name of sheet you wanted to
																				// hold
				XSSFSheet sheet = workbook.getSheetAt(i); // this will make entry into the desired sheet

				// Step 3> Get Access to all Row of Sheet
				Iterator<Row> Rows = sheet.rowIterator(); // this will help in iterating against the Rows
				Row firstRow = Rows.next();

				Iterator<Cell> ce = firstRow.cellIterator(); // Now this cell iterates across all the cells of the row
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("Expected")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);

				// Once column is identified now scan the entire STtaion name

				while (Rows.hasNext()) {
					Row r = Rows.next();

					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(stationName)) {
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							// System.out.println(cv.next().getStringCellValue());
							a.add(cv.next().getStringCellValue());
						}
					}
				}
			}
		}
		return a;

	}
}

    	

