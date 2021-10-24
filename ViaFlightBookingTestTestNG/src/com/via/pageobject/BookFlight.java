package com.via.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookFlight {

	WebDriver driver;
	WebDriverWait wait;
	Actions oactions;
	By slider = By.xpath("//div[@class='progressBarContainer']");
	By Alert = By.xpath("//div[@class='viaAlertClose']");
	By Resultfilter = By.xpath("//div[@id ='resultFilter']//span/parent::p//span[contains(text(),'Stops')]");
	By Stops = By.xpath("//span[contains(text(),'Stops')]/parent::p");
	By Stop3 = By.xpath("//label[@for = '3_stops']");
	By Stop2 = By.xpath("//label[@for = '2_stops']");
	By Stop1 = By.xpath("//label[@for = '1_stops']");
	By Stop0 = By.xpath("//label[@for = '0_stops']");
	By Book = By.xpath("((//button[contains(text(),'Book')])[2]/ancestor::div)[5]");
	By BookBtn = By.xpath("(//button[contains(text(),'Book')])[3]");

	public BookFlight(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 80);
		this.oactions = new Actions(driver);
	}

	public void sliderWait() throws Exception {
		try {
			driver.findElement(Alert).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(slider)).isDisplayed();
			//oactions.dragAndDropBy(driver.findElement(slider), 100, 0).build().perform();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(slider));
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void stopFilter() {
		try {
			driver.findElement(By.xpath("//div[text()='100%']")).isDisplayed();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Resultfilter)).isDisplayed();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Stops)).click();
			Thread.sleep(3000);
			
			//oactions.moveToElement(driver.findElement(Stop3)).build().perform();
			oactions.moveToElement(driver.findElement(Stop1)).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='onlyBtn'])[2]"))).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Stops)).click();
			oactions.clickAndHold(driver.findElement(Stop0)).build().perform();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//div[@class='onlyBtn'])[1]")).click();
			driver.findElement(Stops).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void bookFlight() throws Exception {
		try {
			Thread.sleep(3000);
			oactions.sendKeys(Keys.PAGE_DOWN).build().perform();
			oactions.moveToElement(driver.findElement(Book)).perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(BookBtn)).click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
