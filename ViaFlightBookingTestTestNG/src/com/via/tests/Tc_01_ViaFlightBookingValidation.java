package com.via.tests;

import org.testng.annotations.Test;

import com.utils.ViaExcelUtils;
import com.via.pageobject.BookFlight;
import com.via.pageobject.MakePayment;
import com.via.pageobject.PassengerInfo;
import com.via.pageobject.PaymentDetails;
import com.via.pageobject.SearchFlight;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Tc_01_ViaFlightBookingValidation {
	WebDriver driver;
	WebDriver Actions;
	WebDriverWait wait;
	ViaExcelUtils oexcelutils;
  @Test
  public void f() throws Exception {
	  driver.get("https://in.via.com/");
	  //driver.manage().window().maximize();
	  
	  SearchFlight osearch = new SearchFlight(driver);
	  osearch.searchFlight();
	  osearch.enterTheDates();
	  osearch.passengerCount();
	  osearch.searchBtn();
	  BookFlight obook = new BookFlight(driver);
	  obook.sliderWait();
	  obook.stopFilter();
	  obook.bookFlight();
	  PassengerInfo oinfo = new PassengerInfo(driver);
	  oinfo.popUp();
	  oinfo.adultInfo();
	  oinfo.childInfo();
	  oinfo.infantInfo();
	  oinfo.otherInfo();
	  oinfo.voucherCode();
	  oinfo.bookBtn();
	  MakePayment opayment = new MakePayment(driver);
	  opayment.paymentClick();
	  PaymentDetails odetails = new PaymentDetails(driver);
	  odetails.paymentInfo();
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
