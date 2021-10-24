package com.via.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.ViaExcelUtils;

public class PaymentDetails {

	WebDriver driver;
	WebDriverWait wait;
	Actions oactions;
	ViaExcelUtils oexcelUtils;
	
	By Cardtype = By.xpath("//div[@class='payOptDiv u_padT20']");
	By DebitCard = By.xpath("//div[contains(text(),'Debit Cards')]");
	By DcardNo = By.xpath("//input[@placeholder ='Card Number']");
	By DcardName = By.xpath("(//input[@placeholder ='Name as on Card'])[1]");
	By Dmonth = By.xpath("(//input[@placeholder='MM'])[1]");
	By Dyear = By.xpath("(//input[@placeholder='YYYY'])[1]");
	By Dcvv = By.xpath("(//input[@placeholder='CVV'])[1]");
	
	public PaymentDetails(WebDriver driver) throws Exception {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,70);
		this.oactions = new Actions(driver);
		this.oexcelUtils = new ViaExcelUtils("D:\\Selenium\\Sheet1.xlsx", "Via Flight Booking");
	}
	
	public void paymentInfo() {
		
		String paymode = oexcelUtils.getCellData(1,"CardType");
		String Cardnumber = oexcelUtils.getCellData(1,"CardNo");
		String name = oexcelUtils.getCellData(1,"CardName");
		String month = oexcelUtils.getCellData(1,"CardMonth");
		String year = oexcelUtils.getCellData(1,"CardYear");
		String cvv = oexcelUtils.getCellData(1,"CVV");
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Cardtype)).isDisplayed();
			oactions.moveToElement(driver.findElement(By.xpath("//div/div[contains(text(),'"+paymode+"')]"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div[contains(text(),'"+paymode+"')]"))).click();
			driver.findElement(DcardNo).sendKeys(Cardnumber);
			driver.findElement(DcardName).sendKeys(name);
			driver.findElement(Dmonth).sendKeys(month);
			driver.findElement(Dyear).sendKeys(year);
			driver.findElement(Dcvv).sendKeys(cvv);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
