package com.jalasoft.automation.core.excel;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Created by Mauricio Cadima on 7/27/2015.
 */
public class ExcelFileReader {
    private String filePath;
    private FileInputStream file;
    private HSSFWorkbook workbook;

    public ExcelFileReader() {
    }

    public void connect(String filePath) throws FileNotFoundException, IOException {
        this.filePath = filePath;
        this.file = new FileInputStream(new File(this.filePath));
        this.workbook = new HSSFWorkbook(file);
    }

    private List<String> getRowStringValues(Row row) {
        List<String> result = new ArrayList<>();
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            result.add(cell.getStringCellValue());
        }
        return result;
    }

    public List<Map<String, String>> getSheetStringValues(String sheetName) {
        List<Map<String, String>> result = new ArrayList<>();
        //Get first sheet from the workbook
        HSSFSheet activeSheet = workbook.getSheet(sheetName);
        //Iterate through each rows from first sheet
        Iterator<Row> rowIterator = activeSheet.iterator();
        List<String> columnNames = null;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (row.getRowNum() == 0) {
                columnNames = this.getRowStringValues(row);
                continue;
            }
            Map<String, String> rowValues = new HashMap<>();
            for (int columnIndex = 0; columnIndex < columnNames.size(); columnIndex++) {
                rowValues.put(columnNames.get(columnIndex), row.getCell(columnIndex).getStringCellValue());
            }
            result.add(rowValues);
        }
        return result;
    }
}
