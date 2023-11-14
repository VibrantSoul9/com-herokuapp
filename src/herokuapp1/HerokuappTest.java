package herokuapp1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HerokuappTest {
    static String baseUrl = "http://the-internet.herokuapp.com/login";

    public static void main(String[] args) throws InterruptedException {
       //Launch the chrome browser and open the URL
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);

        // Maximize the Browser
        driver.manage().window().maximize();
        Thread.sleep(3000);

        // Give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(3000);

        // Get the title of the page
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(3000);
        String loginUrl = "http://id.heroku.com/login";

        // navigate to login
        driver.navigate().to(loginUrl);
        System.out.println("Get Current URl " + driver.getCurrentUrl());

        WebElement cookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        cookies.click();

        // Get page source
        System.out.println(driver.getPageSource());

        // find email field element and enter the email
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("abc123@gmail.com");
        Thread.sleep(3000);

        // Enter the password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("abc123");

        WebElement login = driver.findElement(By.xpath("//*[@id=\"login\"]/form/button"));
        login.click();
        // refresh
        Thread.sleep(3000);
        driver.navigate().refresh();
        // close
        driver.quit();
    }
}
