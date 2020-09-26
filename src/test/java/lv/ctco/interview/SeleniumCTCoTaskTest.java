package lv.ctco.interview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SeleniumCTCoTaskTest {

    @Test
    public void testProfessionalSkillsAndQualificationContainFiveSkills() {

        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\driver\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait explicitWait = new WebDriverWait(driver, 3);

        driver.get("https://ctco.lv/en");

        Actions action = new Actions(driver);

        action.moveToElement(driver.findElement(By.cssSelector("a[href='https://ctco.lv/careers/']")))
                .moveToElement(driver.findElement(By.xpath("//a[@href='https://ctco.lv/careers/vacancies/']"))).click().build().perform();

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='menu-main-container']//ul//li[9]//a"))).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[15]/div/div/p[3]")));

        WebElement complexOfSkills = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[15]/div/div/p[3]"));

        String allParagraphs = complexOfSkills.getAttribute("innerHTML");
        String[] separateLinesOfText = allParagraphs.split("<br>");
        Assert.assertEquals(separateLinesOfText.length, 5);
    }
}