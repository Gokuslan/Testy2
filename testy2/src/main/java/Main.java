import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {


    private final static String TITLE ="Forex Affiliate Program | Forex Affiliates | XM Partners";

    private void assrtTitleVisible(WebDriver driver){
        Assert.assertEquals(getTitle(driver), TITLE);
    }
    private String getTitle(WebDriver driver){
        return driver.findElement(By.xpath("//title")).getAttribute("innerHTML");}
    private void sleep(int milisec){
        try {
            Thread.sleep(milisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void startWebdriver ()
    {

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.navigate().to("https://partners.xm.com");
        sleep(3000);
        driver.findElement(By.xpath("(//button[@aria-label='Close'])[1]")).click();
        sleep(1000);
        assrtTitleVisible(driver);
        sleep(1000);
        driver.findElement(By.xpath("//a[@class='btn btn-solid btn-red']")).click();
        driver.findElement(By.id("first_name")).sendKeys("Test1");
        driver.findElement(By.id("last_name")).sendKeys("Test1");
        Select dropdown = new Select(driver.findElement(By.id("dob_day")));
        dropdown.selectByVisibleText("18");
        sleep(2000);
        Select dropdown2 = new Select(driver.findElement(By.id("dob_month")));
        dropdown2.selectByVisibleText("3");
        Select dropdown3 = new Select(driver.findElement(By.id("dob_year")));
        dropdown3.selectByVisibleText("1987");
        Select dropdown4 = new Select(driver.findElement(By.id("country")));
        dropdown4.selectByVisibleText("Poland");
        js.executeScript("window.scrollBy(0,800)");
        driver.findElement(By.id("city")).sendKeys("Krakow");
        driver.findElement(By.id("state_region")).sendKeys("Malopolska");
        driver.findElement(By.id("street_name")).sendKeys("Dabkowskiego");

         //driver.close();
    }

}
