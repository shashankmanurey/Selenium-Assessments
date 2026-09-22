package selenium.advance.FinalAssessment.Assessment1;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.PomUtilities.OrangeBuzz;
import selenium.PomUtilities.OrangeLogin;
import selenium.advance.BaseClassUtility.OrangeBase1;

public class OrangeMain extends OrangeBase1{
    @Test 
    public void perform() throws Exception 
    {
        FileInputStream f = new FileInputStream("src/main/resources/DDT/OrangeExcel.xlsx");
        Workbook w = WorkbookFactory.create(f);
        Sheet sh = w.getSheet("Sheet3");
        Row row = sh.getRow(1);

        String post = row.getCell(0).getStringCellValue();

        OrangeLogin login = new OrangeLogin(d);
        login.getun("Admin");
        login.getPass("admin123");
        login.getLgbt();

        OrangeBuzz ob = new OrangeBuzz(d);
        Thread.sleep(3000);
        ob.getBuzz();
        ob.gettx(post);
        Thread.sleep(2000);
        ob.getPost();

        Assert.assertTrue(ob.verifyPost(post),"Post is not displayed in Recent Posts");
    }
}
