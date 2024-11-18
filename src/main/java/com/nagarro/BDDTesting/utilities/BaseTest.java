package com.nagarro.BDDTesting.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.nagarro.BDDTesting.config.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private static WebDriver driver;
    private ConfigReader configReader;
    private static final String path="src/test/resources/application.properties";
    
    
    public void setUp() {
        // Setup WebDriverManager and initialize WebDriver
    	configReader = new ConfigReader(path);
    	String browser = configReader.getProperty("browser");
        switch (browser.toLowerCase()) {
            case "chrome":
            	WebDriverManager.chromedriver().setup();
            	ChromeOptions c_options = new ChromeOptions();
            	c_options.addArguments("--headless");
                driver = new ChromeDriver(c_options);   // we can pass 'options here in the ChromeDriver constructor'
                break;
            case "firefox":
            	WebDriverManager.firefoxdriver().setup();
            	FirefoxOptions f_options = new FirefoxOptions();
            	f_options.addArguments("--headless");
                driver = new FirefoxDriver();
                break;
            case "edge":
            	WebDriverManager.edgedriver().setup();
            	EdgeOptions e_options = new EdgeOptions();
            	e_options.addArguments("--headless");
                driver = new EdgeDriver(e_options);
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" not supported.");
        }
        driver.manage().window().maximize();
        String url = configReader.getProperty("application.url");
        driver.get(url);
        long waitTime = Long.parseLong(configReader.getProperty("global.wait.time"));
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }
    
    
    public void tearDown() {
    	
    	if (driver != null) {
            driver.quit();
        }
    }
    
    public WebDriver getDriver() {
    	return driver;
    }
    
}