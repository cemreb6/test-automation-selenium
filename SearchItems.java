package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchItems {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String EXE_PATH = "C:\\Users\\Lenovo\\Desktop\\chromedriver.exe";
    private final String WEBSITE = "https://www.yemeksepeti.com/izmir";

    private final By email=By.id("UserName");
    private final By password=By.id("password");
    private final By login =By.id("ys-fastlogin-button");

    private final By selectBanabi = By.partialLinkText("Online Market Siparişi");
    private final By searchBar=By.className("search-bar-input");
    private final By loading = By.className("full-loading");
    private final By popUpClose = By.className("return-ys-popup-close");
    private final By showAll = By.className("search-bar-results-show-all");

    String item=".product-list-item:nth-child(13) > .product-list-item-add-product-button";
    By itemAdd = By.cssSelector(item);

    public SearchItems() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--whitelisted-ips=''");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,50);
    }

    public void search(String searchedItem){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loading));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loading));

        WebElement _popUpClose=driver.findElement(popUpClose);
        _popUpClose.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        WebElement search=driver.findElement(searchBar);
        search.click();
        search.sendKeys(searchedItem);

    }

    public void showAll()
    {
        wait.until(ExpectedConditions.elementToBeClickable(showAll));
        WebElement webElement= driver.findElement(showAll);
        webElement.click();
    }

    public void selectItem()
    {
        wait = new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemAdd));
        WebElement webElement= driver.findElement(itemAdd);
        webElement.click();
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

    public void searchProcess() throws InterruptedException {
        login();
        wait = new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectBanabi));
        WebElement element1=driver.findElement(selectBanabi);
        element1.click();
        search("atıştırmalık");
        showAll();
        selectItem();
    }

    public void connect(){
        driver.get(WEBSITE);
    }

    public void quit(){
        driver.quit();
    }

}