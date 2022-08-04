package project;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvalidOrder {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String EXE_PATH = "C:\\Users\\Lenovo\\Desktop\\chromedriver.exe";
    private final String WEBSITE = "https://www.yemeksepeti.com/izmir";

    private final By email=By.id("UserName");
    private final By password=By.id("password");
    private final By login =By.id("ys-fastlogin-button");

    private final By selectBanabi = By.partialLinkText("Online Market Siparişi");
    private final By loading = By.className("full-loading");
    private final By popUpClose = By.className("return-ys-popup-close");

    private final By confirmOrder=By.className("basket-confirm-button");

    public InvalidOrder() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--whitelisted-ips=''");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,50);
    }

    public void login(){
        WebElement element1=driver.findElement(email);
        element1.click();
        element1.sendKeys("cemrebitgen6@gmail.com");
        WebElement element2= driver.findElement(password);
        element2.click();
        element2.sendKeys("Cemre123.");
        WebElement element3=driver.findElement(login);
        element3.click();
    }

    public void loadProcess(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loading));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loading));

        WebElement _popUpClose=driver.findElement(popUpClose);
        _popUpClose.click();
    }

    public void confirmOrder(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrder));
        WebElement element2 =driver.findElement(confirmOrder);
        element2.click();
    }

    public void selectPayment() throws InterruptedException {

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(4000);


        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(500);

        WebElement element1= driver.findElement(By.cssSelector(".payment-method:nth-child(2) input:nth-child(4)"));
        element1.click();
    }

    public void ConfirmBasket(){
        WebElement element2 =driver.findElement(By.cssSelector(".basket-confirm-button"));
        element2.click();
    }

    public void orderProcess() throws InterruptedException {
        login();
        wait = new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectBanabi));
        WebElement element1=driver.findElement(selectBanabi);
        element1.click();
        loadProcess();
        confirmOrder();
        selectPayment();
        Thread.sleep(500);
        ConfirmBasket();

    }

    public void connect(){
        driver.get(WEBSITE);
    }

   public void quit(){
        driver.quit();
    }

}
