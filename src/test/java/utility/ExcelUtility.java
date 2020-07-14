package utility;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

public class ExcelUtility {
    public Sheet read(String sheetName) {
        Sheet sheet = null;
        try {
            File file = new File("src/test/resources/excelFiles/report.xlsx");
            Workbook workbook= WorkbookFactory.create(file);
            sheet = workbook.getSheet(sheetName);

            System.out.println("Reading Excel sheet");
            return sheet;
        } catch (IOException e) {
            e.printStackTrace();

        }


        return sheet;
    }
}
