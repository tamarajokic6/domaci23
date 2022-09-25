package zadatak1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        //Napraviti aplikaciju pomocu Selenium-a koji ce otvoriti sajt kupujemprodajem.com,
        // izlistati sve kategorije (Stvari) sa leve strane i njihove linkove (kao spoken tekst “kategorija: link”),

        // kliknuti iz te liste na Bicikli (bez hardkodovanja, posto imate listu, iskoristiti element iz nje
        // da se klikne), kliknuti na Električni (mozete hardcodovati).
        // Ostati na toj strani kao kraj zadatka. Uspavati program na 5 sekundi kako bi se video rezultat
//Za 5+ nakon klika na kategoriju bicikli, treba izlistati sve kategorije koje pisu (Mountainbike, Gradski itd).

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        webDriver.get("https://www.kupujemprodajem.com/");

        WebElement closeButton = webDriver.findElement(By.className("kpBoxCloseButton"));
        closeButton.click();

        List<WebElement> linkovi = webDriver.findElements(By.xpath("//*[@id='category-tree-content-goods']/a"));

        for (int i = 0; i < linkovi.size(); i++) {
            System.out.println(linkovi.get(i).getText() + ": " + linkovi.get(i).getAttribute("href"));

        }

        for (int j = 0; j < linkovi.size(); j++) {

            if (linkovi.get(j).getText().equals("Bicikli")) {
                webDriver.navigate().to(linkovi.get(j).getAttribute("href"));
                break;

            }
        }

        WebElement elektricni = webDriver.findElement(By.xpath("//*[@id=\"groupBox1360\"]/div[1]/h2/a/span"));

        elektricni.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        webDriver.quit();


    }

}


