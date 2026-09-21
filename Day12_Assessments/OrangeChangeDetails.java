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
import selenium.PomUtilities.OrangeMyInfo;
import selenium.PomUtilities.OrangeLogin;

public class OrangeChangeDetails extends OrangeBase1 {

    @DataProvider
    public Object[][] excel() throws EncryptedDocumentException, IOException {

        FileInputStream f = new FileInputStream("src/main/resources/DDT/OrangeExcel.xlsx");

        Workbook w = WorkbookFactory.create(f);
        Sheet sh = w.getSheet("Sheet2");

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

        w.close();
        f.close();

        return obj;
    }

    @Test(dataProvider = "excel")
    public void changedetails(String firstname,String lastname,String empid) throws Exception {

        // Step 1: Login
        OrangeLogin login = new OrangeLogin(d);

        login.getun("Admin");
        login.getPass("admin123");
        login.getLgbt();

        Assert.assertTrue(
            login.verify(),
            "Login failed"
        );

        // Step 2: Update My Info
        OrangeMyInfo o = new OrangeMyInfo(d);

        System.out.println("First name: " + firstname);
        System.out.println("Last name: " + lastname);
        System.out.println("Employee ID: " + empid);

        o.myinfo(); 
        o.fname(firstname);
        o.lname(lastname);
        o.emp(empid);
        System.out.println("First name in field: " + o.getFirstName());
        System.out.println("Last name in field: " + o.getLastName());
        System.out.println("Employee ID in field: " + o.getEmployeeId());
        o.s();

        // Step 3: Logout
        o.getProfile();
        o.getLout();

        // Login again
        login.getun("Admin");
        login.getPass("admin123");
        login.getLgbt();

        Assert.assertTrue(login.verify(), "Second login failed");

        // Verify updated details
        OrangeMyInfo o2 = new OrangeMyInfo(d);
        o2.myinfo();

        String actualFirstName = o2.getFirstName();
        String actualLastName = o2.getLastName();
        String actualEmployeeId = o2.getEmployeeId();

        Assert.assertEquals(actualFirstName,firstname,"First name not updated");

        Assert.assertEquals(actualLastName,lastname,"Last name not updated");

        Assert.assertEquals(actualEmployeeId,empid,"Employee ID not updated");

        // Step 6: Final logout
        o2.getProfile();
        o2.getLout();
    }
}