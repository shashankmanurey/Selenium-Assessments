package selenium.advance;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.PomUtilities.Day7Pom;

public class Day7_TC1 {

    public static void main(String[] args) throws IOException {

        FileInputStream f = new FileInputStream(
                "src/main/resources/DDT/data1.properties");

        Properties p = new Properties();
        p.load(f);

        String brow = p.getProperty("browser");
        String url = p.getProperty("url");
        String un = p.getProperty("username");
        String pw = p.getProperty("password");


        FileInputStream excel = new FileInputStream(
                "src/main/resources/DDT/TestData11.xlsx");

        Workbook wb = WorkbookFactory.create(excel);

        Sheet sh = wb.getSheet("Recruitment");

        Row row = sh.getRow(1);

        String firstName = row.getCell(0).getStringCellValue();
        String middleName = row.getCell(1).getStringCellValue();
        String lastName = row.getCell(2).getStringCellValue();
        String vacancyData = row.getCell(3).getStringCellValue();
        String email = row.getCell(4).getStringCellValue();

        String mobile = String.valueOf(
                (long) row.getCell(5).getNumericCellValue());

        String resumePath = row.getCell(6).getStringCellValue();

        String applicationDate = row.getCell(7).getStringCellValue();

        String jobTitleData = row.getCell(8).getStringCellValue();
        String hiringManagerData = row.getCell(9).getStringCellValue();
        String statusData = row.getCell(10).getStringCellValue();


        WebDriver driver = null;

        if (brow.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(15));

        driver.get(url);


        Day7Pom r = new Day7Pom(driver);


        r.getUsername(un);
        r.getPassword(pw);
        r.getLogin();


        r.getRecruitment();

        r.getAddCandidate();


        r.getFirstName(firstName);
        r.getMiddleName(middleName);
        r.getLastName(lastName);

        r.getVacancy(vacancyData);

        r.getEmail(email);

        r.getMobileNumber(mobile);

        r.getResume(resumePath);

        r.getApplicationDate(applicationDate);

        r.getSave();


        r.getCandidates();


        r.getJobTitle(jobTitleData);

        r.getJobVacancy(vacancyData);

        r.getHiringManager(hiringManagerData);

        r.getStatus(statusData);

        r.getCandidateName(firstName);

        r.getDateFrom(applicationDate);

        r.getDateTo(applicationDate);

        r.getSearch();


        int count = driver.findElements(
                By.xpath("//div[contains(@class,'oxd-table-body')]//div[contains(@class,'oxd-table-row')]")
        ).size();

        if (count > 0) {
            System.out.println("Candidate is added successfully");
        } else {
            System.out.println("Candidate is NOT added");
        }


        r.getUserDropdown();

        r.getLogout();


        driver.quit();

        wb.close();

        excel.close();

        f.close();
    }
}