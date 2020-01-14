package com.github.mytestuser;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {
    ChromeDriver driver;
    String valueNameCoupone;
    String messageCreateCoupon;
    String headingLogout;
    int countRowCoupon;

    By loginEmailField = By.cssSelector("div#main input[name=email]");
    By loginPasswordField = By.cssSelector("div#main input[name=password]");
    By loginButton = By.cssSelector("div#main .col-sm-offset-2 button");
    By newCouponButton = By.cssSelector("a.btn[href $=create]");
    By nameCouponField = By.cssSelector("input#name");
    By dateCouponField = By.cssSelector("input[name=valid_date]");
    By numberCouponField = By.cssSelector("input#number_coupons");
    By createCouponBtn = By.cssSelector("button[name=submit]");
    By searchField = By.cssSelector("input[name=name]");
    By searchBtn = By.cssSelector("form.pull-right button");
    By deleteBtn = By.cssSelector("a.btn.index-delete");
    By deleteBtnConfirm = By.cssSelector("button.confirm");
    By leftPaneleShop = By.xpath("//span[contains(.,'eShop')]");
    By leftPanelCoupon = By.xpath("//span[contains(.,'Coupons')]");
    By getCouponTable = By.xpath(".//*[@class='table-responsive']//tbody/tr/td[1]");
    By countCoupon = By.cssSelector(".table-striped tbody tr");

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\projects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://open-eshop.stqa.ru/oc-panel/auth/login");
        login("demo@open-eshop.com", "demo");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void login(String username, String password) {
        driver.findElement(loginEmailField).sendKeys(username);
        driver.findElement(loginPasswordField).sendKeys(password);
        driver.findElement(loginButton).submit();
    }

    protected void logout() {
        driver.findElementByCssSelector("span.caret").click();
        driver.findElementByCssSelector("a[href='http://open-eshop.stqa.ru/oc-panel/auth/logout']").click();
        headingLogout = driver.getTitle();
    }

    protected void gotoPanelCoupons() {
        driver.findElement(leftPaneleShop).click();
        driver.findElement(leftPanelCoupon).click();
    }

    protected void createCoupon(CouponeData couponeData) {
        driver.findElement(newCouponButton).click();

        driver.findElement(nameCouponField).sendKeys(couponeData.getCouponeName());
        driver.findElement(dateCouponField).sendKeys(couponeData.getValidDate());
        driver.findElement(numberCouponField).clear();
        driver.findElement(numberCouponField).sendKeys(couponeData.getNumberCoupons());

        driver.findElement(createCouponBtn).submit();
        messageCreateCoupon = driver.findElementByCssSelector("div.alert-success h4").getText();
    }

    protected void searchCoupon(String nameCoupone) {
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(nameCoupone);
        driver.findElement(searchBtn).click();

        List<WebElement> col = driver.findElements(countCoupon);
        countRowCoupon = col.size();
    }

    protected void getCoupon(String nameCoupone) {
        List<WebElement> tableTd = driver.findElements(getCouponTable);

        for (WebElement element : tableTd)
            if (element.getText().contains(nameCoupone)) {
                valueNameCoupone = element.getText();
                //System.out.println(element.getText());
            }
    }

    protected void deleteCoupon() {
        driver.findElement(deleteBtn).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(deleteBtnConfirm).click();

        List<WebElement> col = driver.findElements(countCoupon);
        countRowCoupon = col.size();
    }
}