package com.github.vikkingg13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumTest {

    private static final String url = "https://github.com/Vikkingg13";

    @Test
    public void whenGetTitleThenReturnString() {
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        var title = driver.getTitle();

        Assert.assertEquals("Vikkingg13 (Viktor Grigoriev) · GitHub", title);

        driver.quit();
    }

    @Test
    public void whenFindElementByNameThenReturnElement() {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        var element = driver.findElement(By.name("button"));
        var text = element.getText();

        Assert.assertNotNull(element);
        Assert.assertEquals("Show more activity", text);

        driver.quit();
    }

    @Test
    public void whenFindElementsByClassThenReturnElement() {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        var element = driver.findElement(By.className("btn-block"));
        var text = element.getText();

        Assert.assertNotNull(element);
        Assert.assertEquals("Follow", text);

        driver.quit();
    }

    @Test
    public void whenFindElementBySelectorAndClickThenNewElementShows() {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        var link = driver.findElement(
                By.cssSelector("body > div.position-relative.js-header-wrapper > header > div > div.HeaderMenu--logged-out.p-responsive.height-fit.position-lg-relative.d-lg-flex.flex-column.flex-auto.pt-7.pb-4.top-0 > div > div > div.position-relative.mr-lg-3.d-lg-inline-block > a"));
        link.click();
        var element = driver.findElement(By.className("auth-form-header"));
        var text = element.getText();

        Assert.assertNotNull(element);
        Assert.assertEquals("Sign in to GitHub", text);

        driver.quit();
    }

    @Test
    public void whenFindElementsByClassNameThenReturnList() {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        var elements = driver.findElements(By.className("repo"));

        Assert.assertNotNull(elements);
        Assert.assertEquals(6, elements.size());

        driver.quit();
    }
}
