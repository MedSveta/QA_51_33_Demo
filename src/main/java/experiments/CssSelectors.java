package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsHomePage() {
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        pause(5000);
        WebElement footer = driver
                .findElement(By.tagName("footer"));
        System.out.println(footer.getTagName());
        hideFooter();
        WebElement element = driver
                .findElement(By.cssSelector(".card-body"));
        element.click();
        pause(5000);
        driver.navigate().back();
        //div[class='card-body']
        //*[class='card-body']
        WebElement element1 = driver
                .findElement(By.cssSelector
                        ("div[class='card-body']"));
        element1.click();
        pause(5000);
        driver.navigate().back();
        WebElement element2 = driver.findElement
                (By.className("card-body"));
        element2.click();
        WebElement textBox = driver.findElement
                (By.cssSelector("#item-0"));
        textBox.click();
        pause(5000);
        driver.navigate().back();
        WebElement textBox1 = driver.findElement(By.id("item-0"));
        textBox1.click();
        // li[id='item-0']
        // *[id='item-0']
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }
}
