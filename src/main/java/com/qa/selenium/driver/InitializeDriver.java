package com.qa.selenium.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class InitializeDriver {

    private WebDriver driver;
    private String browserName;

    InitializeDriver(String browserName) {

        this.browserName = browserName;
    }


    /***
     *
     */
    public WebDriver initDriver(String url) {


        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("acceptInsecureCerts", true);


        if (browserName.equalsIgnoreCase("chrome")) {


            chromeOptions.addArguments("--start-maximized");

            driver = new ChromeDriver(chromeOptions);
        } else if (browserName.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();
        } else {

            System.out.println("please provide either Firefox or Chrome browser");
        }

        driver.manage().deleteAllCookies();
        //  driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().logs().toString();
        String className = driver.manage().getClass().getName();
        System.out.println("Class Name ==== " + className);

        //Load the URL for the webpage

        driver.get(url);

        return driver;


    }

    /***
     * initialize the property
     * @param properties
     * @param key
     * @throws FileNotFoundException
     * @throws IOException
     */
    public Properties initProperty(Properties properties, String key) throws FileNotFoundException, IOException {

        FileInputStream fip = new FileInputStream(new File("/Users/swati/Documents/HimashuRestAssured/JavaSeleniumAutomationFramework/src/Config.properties"));
        properties.load(fip);

        return properties;
    }


    /***
     * Terminate all the browser session
     */
    public void quitBrowser() {
        //Closes all the browser sessions
        driver.quit();
    }

    public static void main(String[] args) {

        By searchEntry = By.xpath("//div[@role='presentation']/ul/li");
        By perfromSearch = By.xpath("//textarea[@type='search']");
        //   WebDriver chromeDriver  = new ChromeDriver();
        InitializeDriver id = new InitializeDriver("chrome");

     WebDriver driver =    id.initDriver("https://www.google.com");
     driver.findElement(perfromSearch).click();
     driver.findElement(perfromSearch).sendKeys("selenium");

     List<WebElement> elem  = driver.findElements(searchEntry);
        System.out.println(elem);
        for(int i=0;i<elem.size();i++){

            System.out.println(elem.get(i).getText());
        }
        //  id.quitBrowser();

        Wait wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        wait.until(new Function<WebDriver,WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(""));
            }
        });
    }
}
