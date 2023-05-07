import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class testClass {


    @Test
    public void runner() throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver","C://TechStats//Richa_Assignment//chromedriver//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://thg-greenair.dev.wgv.onpier.de/landing");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //Landing Page element
        WebElement eCar = driver.findElement(By.xpath("//label[1]/mat-card"));
        WebElement applyFlexiPremium = driver.findElement(By.xpath("//mat-card[1]/mat-card-content/div[2]/div/button"));

        eCar.click();
        applyFlexiPremium.click();

        Thread.sleep(10000);

        //OnBoarding Page
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,350)");

        WebElement file_upload = driver.findElement(By.xpath("//form/div[1]/app-file-upload/label[2]/div/div/div"));
        driver.findElement(By.xpath("//input[@id='Fahrzeugschein Vorderseite']")).sendKeys("C:\\Users\\dell\\OneDrive\\Desktop\\image.png");
        js.executeScript("window.scrollBy(0,100)");
        driver.findElement(By.xpath("//input[@id='Fahrzeugschein Rückseite']")).sendKeys("C:\\Users\\dell\\OneDrive\\Desktop\\image.png");
        WebElement Further2 = driver.findElement(By.xpath("//app-step1/app-stepper-buttons/div/div[2]/button[2]"));
        Further2.click();

        //Verify that Weiter button is disabled when mandatory fields are not filled
        String buttonStatus=driver.findElement(By.xpath("//app-step2/app-stepper-buttons/div/div[2]/button[2]")).getAttribute("disabled");
        boolean flag = buttonStatus.equalsIgnoreCase("true");
        Assert.assertTrue(flag);

        //Verify Privatperson form is successfully filled
        driver.findElement(By.xpath("//div[@id='mat-select-value-1']")).click();
        driver.findElement(By.xpath("//span[text()='Herr']")).click();
        driver.findElement(By.xpath("//label[text()='Vorname']/parent::div/div/input")).sendKeys("Richa");
        driver.findElement(By.xpath("//label[text()='Nachname']/parent::div/div/input")).sendKeys("Sinha");
        driver.findElement(By.xpath("//label[text()='E-Mail-Adresse']/parent::div/div/input")).sendKeys("Richa.Sinha@gmail.com");
        driver.findElement(By.xpath("//label[text()='Kontoinhaber']/parent::div/div/input")).sendKeys("Richa Sinha");
        driver.findElement(By.xpath("//label[text()='IBAN']/parent::div/div/input")).sendKeys("GB94 BARC 1020 1530 0934 59");
        driver.findElement(By.xpath("//app-step2/app-stepper-buttons/div/div[2]/button[2]")).click();
        String PageHeader = driver.findElement(By.xpath("//app-step3/div/h2")).getAttribute("text");
        boolean pageStatus = PageHeader.equalsIgnoreCase("Angaben überprüfen & THG-Prämie beantragen");
        Assert.assertTrue("The personal form is filled successfully",pageStatus);

        //Verify Unternehmen form is successfully filled
        driver.findElement(By.xpath("//input[@id='mat-radio-3-input']")).click();
        driver.findElement(By.xpath("//label[text()='Unternehmensname inkl. Unternehmensrechtsform']/parent::div/div/input")).sendKeys("Steel company");
        driver.findElement(By.xpath("//label[text()='Umsatzsteuer-ID (oder Steuernummer)']/parent::div/div/input")).sendKeys("DE123456789");
        driver.findElement(By.xpath("//div[@id='mat-select-value-1']")).click();
        driver.findElement(By.xpath("//span[text()='Herr']")).click();
        driver.findElement(By.xpath("//label[text()='Vorname']/parent::div/div/input")).sendKeys("Richa");
        driver.findElement(By.xpath("//label[text()='Nachname']/parent::div/div/input")).sendKeys("Sinha");
        driver.findElement(By.xpath("//label[text()='E-Mail-Adresse']/parent::div/div/input")).sendKeys("Richa.Sinha@gmail.com");
        driver.findElement(By.xpath("//label[text()='Kontoinhaber']/parent::div/div/input")).sendKeys("Richa Sinha");
        driver.findElement(By.xpath("//label[text()='IBAN']/parent::div/div/input")).sendKeys("GB94 BARC 1020 1530 0934 59");
        driver.findElement(By.xpath("//app-step2/app-stepper-buttons/div/div[2]/button[2]")).click();
        String PageHeader2 = driver.findElement(By.xpath("//app-step3/div/h2")).getAttribute("text");
        boolean pageStatus2 = PageHeader.equalsIgnoreCase("Angaben überprüfen & THG-Prämie beantragen");
        Assert.assertTrue("The personal form is filled successfully",pageStatus2);



    }
}
