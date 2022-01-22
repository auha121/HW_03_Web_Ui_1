package ru.gb.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class CaseLogin {
    public static void main( String[] args ) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get("https://fix-price.ru/");
        //webDriver.manage().window().setSize(new Dimension(1280,800));
        webDriver.manage().window().maximize();

        webDriver.findElement(By.xpath("//a[@title='Личный кабинет']")).click();


        //Разные варианты поиска элемента, который не получается найти
        //webDriver.findElement(By.xpath("//label[text()='Email']")).click();
        //webDriver.findElement(By.xpath("//input[@value='email']")).click();
        //webDriver.findElement(By.xpath("//div[@class='switcher-auth__row']/label[@for='switcher-auth__email']")).click();
        //webDriver.findElement(By.xpath("//input[@id='switcher-auth__email']")).click();
        //webDriver.findElement(By.cssSelector("label.switcher-auth__label:after")).click();
        //webDriver.findElement(By.cssSelector("label.switcher-auth__label:nth-child(2) path:nth-child(2)")).click();
        //webDriver.findElement(By.cssSelector("label.switcher-auth__email")).click();
        //webDriver.findElement(By.cssSelector(".header-controls__item:nth-child(2) path:nth-child(2)")).click();


        webDriver.findElement(By.xpath("//input[@name='login']")).sendKeys("auha1@rambler.ru");
        webDriver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ss12345678");
        webDriver.findElement(By.xpath("//button[@name='Login']")).click();
        webDriver.findElement(By.xpath("//div[@id='poolLink']/child::button")).click();

        Thread.sleep(10000);
        webDriver.quit();
    }

}
