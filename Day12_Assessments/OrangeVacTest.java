package selenium.PomImpl;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import selenium.advance.BaseClassUtility.OrangeBase1;
import selenium.PomUtilities.OrangeLogin;
import selenium.PomUtilities.OrangeRect;
import selenium.PomUtilities.OrangeVac;

public class OrangeVacTest extends OrangeBase1 {

    @DataProvider
    public Object[][] excel() throws EncryptedDocumentException, IOException {

        FileInputStream ex = new FileInputStream("src/main/resources/DDT/OrangeExcel.xlsx");

        Workbook wb = WorkbookFactory.create(ex);
        Sheet sh = wb.getSheet("Sheet1");

        int rc = sh.getLastRowNum();
        int cc = sh.getRow(0).getLastCellNum();

        Object[][] obj = new Object[rc][cc];

        DataFormatter df = new DataFormatter();

        for (int r = 1; r <= rc; r++) {
            for (int c = 0; c < cc; c++) {

                obj[r - 1][c] =
                    df.formatCellValue(sh.getRow(r).getCell(c));
            }
        }

        wb.close();
        ex.close();

        return obj;
    }
    @Test(dataProvider = "excel")
    public void createVacancy(String vacancyName, String jobTitle, String description, String hiringManager, String numberOfPositions) throws Exception 
    {
        // Step 1: Login
        OrangeLogin login = new OrangeLogin(d);

        login.getun("Admin");
        login.getPass("admin123");
        login.getLgbt();

        Assert.assertTrue(
            login.verify(),
            "Login failed: Dashboard not displayed"
        );

        // Step 2: Navigate to Recruitment - Vacancies
        OrangeRect rect = new OrangeRect(d);

        rect.clickRecruitment();
        rect.clickvac();
        rect.clickadd();

        // Step 3: Fill vacancy form using Excel data
        OrangeVac vac = new OrangeVac(d);

        vac.enterVacancy(vacancyName);
        vac.selectJob(jobTitle);
        vac.enterDesc(description);
        vac.selectHM(hiringManager);
        vac.enterNumPos(numberOfPositions);

        // Step 4: Save vacancy
        vac.clickSave();
    }
}