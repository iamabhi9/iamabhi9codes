package com.flipkart.scrap;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class flipkart {

    public static void main(String[] args) throws InterruptedException {

        FirefoxDriver driver = new FirefoxDriver();
        WebElement element;
        WebDriverWait wait = new WebDriverWait(driver, 5);

        String searchBox = ".//*[@id='container']/div/div/header/div[2]/div/div[2]/div/form/div/input";
        String brandSearch = ".//*[@id='facetList']/div[2]/div[2]/div/div[2]/input";
        String appleCheckBox = ".//*[@id='brand']/li[3]/a/input";
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("http://www.flipkart.com");  //Opening the url
        element = driver.findElement(By.xpath(searchBox));
        element.sendKeys("iPhone 6");  //Search criteria 
        element.sendKeys(Keys.ENTER);

        element = driver.findElement(By.xpath(brandSearch));
        element.sendKeys("Apple");   // Input Apple in brand
        element = driver.findElement(By.xpath(appleCheckBox));  //Selecting Apple
        element.click();
        Thread.sleep(5000);   
        String range = ".//*[@id='price_range']/li[";
        int priceCounter = 1;
// Selecting 35000+ range. Keeping in mind that code doesnt breaks if number of selecter changed 
        while (true) {
            List < WebElement > check = driver.findElements(By.xpath(range + priceCounter + "]"));
            if (check.size() > 0) {
                element = driver.findElement(By.xpath(range + priceCounter + "]"));
 element=getStaleElemById(range + priceCounter + "]", driver);
                
                if (element.getText().contains("35001")) {
                    range = range.concat(priceCounter + "]/a/input");
                    break;
                }
            } else {
                break;
            }

            priceCounter++;


        }

        element = driver.findElement(By.xpath(range));
        element.click();

        String iPhone1 = ".//*[@id='products']/div[1]/div[";
        String iPhone2 = "]/div[";
        String iPhone3 = "]/div/div[2]/div[1]/a";


        String rate1 = ".//*[@id='products']/div[1]/div[";
        String rate2 = "]/div[";
        String rate3 = "]/div/div[2]/div[4]/div/div[1]/span";

        ArrayList < String > a1 = new ArrayList();
        ArrayList < String > a2 = new ArrayList();
        ArrayList < Integer > a3 = new ArrayList < Integer > ();

        int Vcounter = 1;
//Scrapping started 

        System.out.print("Please wait while flipkart is being scraped for you. Loading..");
        Thread.sleep(10000);
        while (true) {
            System.out.print(".");

            for (int Hcounter = 1; Hcounter <= 4; Hcounter++) {
                System.out.print(".");


                List < WebElement > check = driver.findElements(By.xpath(iPhone1 + Vcounter + iPhone2 + Hcounter + iPhone3));

                if (check.size() > 0) {
                     element = driver.findElement(By.xpath(iPhone1 + Vcounter + iPhone2 + Hcounter + iPhone3));
                    
                     element=getStaleElemById(iPhone1 + Vcounter + iPhone2 + Hcounter + iPhone3, driver);

                    if (element.getText().contains("Apple iPhone 6 (")) {   //Taking only iPhone6, not 6s or 6 plus
                         element=getStaleElemById(iPhone1 + Vcounter + iPhone2 + Hcounter + iPhone3, driver);

                        a1.add(element.getText());
                        String url[] = element.getAttribute("href").split("&");   //Removing the GA code from URL 
                        a2.add(url[0]);

                        element=getStaleElemById(rate1 + Vcounter + rate2 + Hcounter + rate3,driver);

                        element = driver.findElement(By.xpath(rate1 + Vcounter + rate2 + Hcounter + rate3));
                        element=getStaleElemById(rate1 + Vcounter + rate2 + Hcounter + rate3,driver);

                        a3.add(convertPrice(element.getText()));    //Converting the format of price from String to Int

                    }


                } else {
                    Vcounter = -1;
                    break;
                }
            }
            if (Vcounter > 0)
                Vcounter = Vcounter + 2;
            else
                break;


        }

        print(a1, a2, a3);
        driver.close();
        driver.quit();
    }



//Function to convert Price from Rs XX,XXX format to Int format
    public static int convertPrice(String price) {

        String a[] = price.split(" ");
        String a2[] = a[1].split(",");
        return Integer.parseInt(a2[0] + a2[1]);
    }

//Function to print the scrapped data     
    public static void print(ArrayList < String > a1, ArrayList < String > a2, ArrayList < Integer > a3) {
        
        System.out.println();
        System.out.println("Scraped Data");
        System.out.println();
        sortGivenArray(a3, a1, a2);

        for (int i = 0; i < a3.size(); i++) {

            System.out.println(a3.get(i) + " | " + a1.get(i) + " | " + a2.get(i));

        }


    }

//Function to sort the data in assending order of price
    public static void sortGivenArray(ArrayList < Integer > inputArray, ArrayList < String > a1, ArrayList < String > a2) {
        for (int i = 1; i < inputArray.size(); i++) {

            int key = inputArray.get(i);
            String key2 = a1.get(i);
            String key3 = a2.get(i);

            for (int j = i - 1; j >= 0; j--) {
                if (key < inputArray.get(j)) {
                    inputArray.set(j + 1, inputArray.get(j));
                    a1.set(j + 1, a1.get(j));
                    a2.set(j + 1, a2.get(j));
                    if (j == 0) {
                        inputArray.set(0, key);
                        a1.set(0, key2);
                        a2.set(0, key3);

                    }
                } else {
                    inputArray.set(j + 1, key);
                    a1.set(j + 1, key2);
                    a2.set(j + 1, key3);

                    break;
                }
            }
        }
    }
    
    
    // Code for wait till element gets loads. 
    //This is used for coping up with problem which was happening on my system due to slow network
  public   static WebElement getStaleElemById(String xpath1, FirefoxDriver driver) {
        try {  
            return driver.findElement(By.xpath(xpath1));
        } catch (StaleElementReferenceException e) {
             return getStaleElemById(xpath1,driver);
        }
    }

}