package project;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class InvalidRegistration {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String EXE_PATH = "C:\\Users\\Lenovo\\Desktop\\chromedriver.exe";
    private final String WEBSITE = "https://www.yemeksepeti.com/izmir-uye-ol";

    private final By email =By.id("inputEmail");
    private final By name =By.id("inputFirstName");
    private final By lastname =By.id("inputLastName");
    private final By password =By.id("inputPassword");
    private final By repeatPassword =By.id("inputRepeatPassword");
    private final By neighborhood =By.name("AreaId");
    private final By userAgreement=By.id("inputAcceptEula");
    private final By signUp=By.cssSelector(".ys-btn-primary");


    public InvalidRegistration() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--whitelisted-ips=''");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,30);

    }

    public void setEmail(){
        WebElement webElement=driver.findElement(email);
        webElement.click();
        webElement.sendKeys("cemre092000@hotmail.com");
    }
    public void setPassword(){
        WebElement webElement=driver.findElement(password);
        webElement.click();
        webElement.sendKeys("Cemre123.");
    }
    public void setRepeatPassword(){
        WebElement webElement=driver.findElement(repeatPassword);
        webElement.click();
        webElement.sendKeys("Cemre123.");
    }
    public void setFirstName(){
        WebElement webElement=driver.findElement(name);
        webElement.click();
        webElement.sendKeys("Cemre");
    }

    public void setLastName(){
        WebElement webElement=driver.findElement(lastname);
        webElement.click();
        webElement.sendKeys("Bitgen");
    }

    public void setNeighborhood(){
        Select selectNeighborhood=selectNeighborhood=new Select(driver.findElement(neighborhood));
        selectNeighborhood.selectByValue("f3d040f7-7449-4d78-8208-c1b0022238b6");
    }

    public void checkUserAgreement(){
        WebElement webElement=driver.findElement(userAgreement);
        webElement.click();
    }
    public void setSignUp(){
        WebElement webElement=driver.findElement(signUp);
        webElement.submit();
    }

    public void enterValues() throws InterruptedException {
        setEmail();
        setPassword();
        setRepeatPassword();
        setFirstName();
        setLastName();
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,400);");
        Thread.sleep(1000);
        setNeighborhood();
        checkUserAgreement();
        setSignUp();
    }

    public void connect(){
        driver.get(WEBSITE);
    }

    public void quit(){
        driver.quit();
    }

}
