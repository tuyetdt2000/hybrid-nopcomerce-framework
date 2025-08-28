package javaoop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Polymorphism {

    // Construct (Hàm khởi tạo)
    public Polymorphism() {}
    public Polymorphism(WebDriver driver){
        System.out.println("Demo");

    }

    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        Actions action= new Actions(driver);
        // The same method but input value is different
        action.clickAndHold();
        action.clickAndHold(driver.findElement(By.cssSelector("")));

    }
}
