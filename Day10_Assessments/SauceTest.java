package selenium.advance.UsingTestNg;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
import selenium.PomUtilities.Login;
import selenium.PomUtilities.checkout;
import selenium.PomUtilities.overview;
import selenium.PomUtilities.product;
import selenium.advance.BaseClassUtility.BaseClass1;


public class SauceTest extends BaseClass1 {

    @Test
    public void loginTest() throws Exception {

        FileInputStream fis = new FileInputStream(
                "src/main/resources/DDT/test.xlsx");

        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet("Sheet1");
        Row row = sh.getRow(1);

        DataFormatter df = new DataFormatter();

        String username = df.formatCellValue(row.getCell(0));
        String password = df.formatCellValue(row.getCell(1));

        wb.close();
        fis.close();

        Login l = new Login(driver);

        l.getus(username);
        l.getpd(password);
        l.getlogin();

        if (l.verifyProductsPage()) {
            System.out.println("Products page is displayed");
        } else {
            System.out.println("Products page is not displayed");
        }

        System.out.println("Login test passed");
        driver.quit();
    }
    @Test(dependsOnMethods = "loginTest" )
    public void oderPalcementTest() throws Exception {

        FileInputStream fis = new FileInputStream(
                "src/main/resources/DDT/test.xlsx");

        Workbook wb = WorkbookFactory.create(fis);

        Sheet sh = wb.getSheet("Sheet1");

        Row row = sh.getRow(1);

        DataFormatter df = new DataFormatter();

        String username = df.formatCellValue(row.getCell(0));
        String password = df.formatCellValue(row.getCell(1));
        String firstName = df.formatCellValue(row.getCell(2));
        String lastName = df.formatCellValue(row.getCell(3));
        String postalCode = df.formatCellValue(row.getCell(4));

        wb.close();
        fis.close();

        Login l = new Login(driver);

        l.getus(username);
        l.getpd(password);
        l.getlogin();

        if (l.verifyProductsPage()) {
            System.out.println("Products page is displayed");
        } else {
            System.out.println("Products page is not displayed");
        }

        product p = new product(driver);

        p.getad();

        System.out.println("Sauce Labs Backpack added to cart");

        if (p.getsb().equals("1")) {
            System.out.println("Cart contains 1 item");
        } else {
            System.out.println("Cart does not contain 1 item");
        }

        p.getsc();

        if (p.verifyCartPage()) {
            System.out.println("Sauce Labs Backpack is displayed in cart");
        } else {
            System.out.println("Sauce Labs Backpack is not displayed in cart");
        }

        checkout c = new checkout(driver);

        c.getcheckout();
        c.getfn(firstName);
        c.getln(lastName);
        c.getpc(postalCode);

        overview o = new overview(driver);

        o.getcont();

        o = new overview(driver);

        if (o.verifyOverview()) {
            System.out.println("Checkout: Overview page is displayed");
        } else {
            System.out.println("Checkout: Overview page is not displayed");
        }

        o.getfinish();

        o = new overview(driver);

        if (o.verifyMessage()) {
            System.out.println("Thank you for your order!");
        } else {
            System.out.println("Thank you message is not displayed");
        }

        System.out.println("Order placement test passed");
    }
}