package com.via.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utils.ViaExcelUtils;

public class SearchFlight {
	WebDriver driver;
	WebDriverWait wait;
	Actions oactions;
	ViaExcelUtils oexcelutils;
	
	By PopUp = By.id("wzrk-cancel");
	By Origin = By.name("source");
	By Location = By.xpath("//span[contains(text(),'Cochin,Cochin - India')]");
	By Destination = By.name("destination");
	By DLocation = By.xpath("//span[contains(text(),'Dubai Intl Arpt,Dubai - United Arab Emirates')]");
	By DDate = By.xpath("//input[@id='departure']/parent::div");   //By.xpath("//div[contains(text(),'24')]");
	By ReturnDate = By.xpath("//div[@class='element return-element']");
	By Adult = By.xpath("//label[contains(text(),'Adults')]/following-sibling::div//div[@class='plus']");
	By Children = By.xpath("//label[contains(text(),'Children ')]/following-sibling::div//div[@class='plus']");
	By Infant = By.xpath("//label[contains(text(),'Infants ')]/following-sibling::div//div[@class='plus']");
	By SearchBtn = By.id("search-flight-btn");
	
	public SearchFlight(WebDriver driver) throws Exception {
		this.driver= driver;
		this.wait = new WebDriverWait(driver,50);
		this.oactions = new Actions(driver);
		this.oexcelutils = new ViaExcelUtils("D:\\Selenium\\Sheet1.xlsx", "Via Flight Booking");
	}

	public void searchFlight() {
		
		String source = oexcelutils.getCellData(1, "Source");
		String destination = oexcelutils.getCellData(1, "Destination");
		
		try {
			driver.findElement(PopUp).click();
			Thread.sleep(2000);
			driver.findElement(Origin).sendKeys(source);
			oactions.sendKeys(Keys.ARROW_DOWN).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Location)).click();
		
			driver.findElement(Destination).sendKeys(destination);
			oactions.sendKeys(Keys.ARROW_DOWN).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(DLocation)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterTheDates() {
		
		String startDt = oexcelutils.getCellData(1, "StartDate");
		String endDt = oexcelutils.getCellData(1, "EndDate");
		
		try {
			driver.findElement(DDate).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@data-date='"+startDt+"'])[3]"))).click();
			
			//oactions.sendKeys(Keys.TAB).build().perform();
			
			driver.findElement(ReturnDate).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@data-date='"+endDt+"'])[7]"))).click();			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void passengerCount() {
		try {
			//oactions.sendKeys(Keys.TAB).build().perform();
			driver.findElement(Adult).click();
			driver.findElement(Children).click();
			driver.findElement(Infant).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchBtn() {
		driver.findElement(SearchBtn).click();
	}
}

