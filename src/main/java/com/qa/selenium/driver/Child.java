package com.qa.selenium.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Child extends  Test1{


  public static void   test(){
      System.out.println("child");
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.test();
        System.out.println(0.1+0.4);
        System.out.println(0.1+0.2);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js =new ChromeDriver();
        js.executeScript("");
        driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        options.setCapability("","");
        Select select = new Select(driver.findElement(By.xpath("")));
        select.deselectByIndex(0);
        select.selectByVisibleText("himanshu");
        select.selectByValue("Himanshu");

        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Himanshu");

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("")))
                .build()
                .perform();
         action.clickAndHold(driver.findElement(By.xpath("")))
                .moveToElement(driver.findElement(By.xpath("")))
                .release()
                .build()
                .perform();

        action.moveToElement(driver.findElement(By.xpath("")))
                .contextClick();


        //


    }
}
