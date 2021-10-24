package com.via.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakePayment {
	WebDriver driver;
	WebDriverWait wait;
	By PaymentBtn = By.xpath("//span[contains(text(),'Make Payment')]/parent::button");
	
	public MakePayment(WebDriver driver) {
		this.wait = new WebDriverWait(driver,60);
	}
	
	public void paymentClick() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentBtn)).click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
