package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {

    private static final String FILE_PATH = "src/test/resources/TestData.xlsx";

    /**
     * Reads login data from an Excel sheet and returns it as a list of key-value pairs.
     * Each row in the sheet (excluding the header row) is converted to a map where:
     * - Keys are the column headers (first row)
     * - Values are the corresponding cell values from that row
     *
     * @param sheetName the name of the Excel sheet to read from
     * @return a list of maps, each representing one row of login data (column header as key, cell value as value)
     */
    public static List<Map<String, String>> readLoginData(String sheetName) {
        List<Map<String, String>> dataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Map<String, String> rowData = new HashMap<>();

                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                    String key = headerRow.getCell(j).toString();
                    String value = row.getCell(j).toString();
                    rowData.put(key, value);
                }

                dataList.add(rowData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }
}