package login.mapper;

import login.model.Login;
import org.apache.poi.ss.usermodel.*;
import utility.ExcelUtility;

import java.io.*;

public class LoginMapper {
    public Login getInvalidData() {
        //Sheet sheet;
        ExcelUtility excelUtility = new ExcelUtility();
        Sheet sheet = excelUtility.read("Login");
        //wrong username and password
        Row row = sheet.getRow(1);

        Cell wrongUsername = row.getCell(2);
        Cell wrongPassword = row.getCell(3);

        String wrongUser = wrongUsername.getStringCellValue();
        String wrongPass = wrongPassword.getStringCellValue();

        return new Login(wrongUser, wrongPass);

    }

    public Login getValidData() {

        ExcelUtility excelUtility = new ExcelUtility();
        Sheet sheet = excelUtility.read("Login");
        //right username and password
        Row row3 = sheet.getRow(3);
        Cell rightUser = row3.getCell(2);
        Cell rightPass = row3.getCell(3);

        String rightUsername = rightUser.getStringCellValue();
        String rightPassword = rightPass.getStringCellValue();

        return new Login(rightUsername, rightPassword);

    }

    public void setStatus(int rowNum,int cellNum,String status) throws FileNotFoundException {

        try {
            File file = new File("src/test/resources/excelFiles/report.xlsx");
            FileInputStream fis = new FileInputStream(file);
            Workbook workbook= WorkbookFactory.create(fis);
            Sheet sheet=workbook.getSheet("Login");
            Row row=sheet.getRow(rowNum);
            Cell cell=row.getCell(cellNum);
            cell.setCellValue(status);
            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
