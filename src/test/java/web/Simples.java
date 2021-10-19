package web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Simples {
    String url = "https://www.mercadolivre.com.br/";
    WebDriver driver;
    String produto = "Notebook";

   @Before
   public void StartTest(){
    System.setProperty("webdriver.chrome.driver" , "driver/94/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
    driver.manage().window().maximize();

   }
    @After
    public void finishTest(){

       driver.quit();

    }
    @Test
    public void testMercadoLivre(){
       driver.get(url);
       driver.findElement(By.name("as_word")).sendKeys(produto, Keys.ENTER);
       assertEquals( produto,driver.findElement(By.className("ui-search-breadcrumb__title")).getText());


    }








}
