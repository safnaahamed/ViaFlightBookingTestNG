package com.via.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.ViaExcelUtils;

public class PassengerInfo {
	WebDriver driver;
	WebDriverWait wait;
	Actions oactions;
	ViaExcelUtils oexcelUtils;
	By PopUp1 = By.xpath("//div[@class='viaAlertClose']");
	By Adult1 = By.id("adult1Title");
	By AdultFN = By.id("adult1FirstName");
	By AdultLN = By.id("adult1Surname");
	By DOB1 = By.id("adult1DOBday");
	By MOB1 = By.id("adult1DOBmonth");
	By YOB1 = By.id("adult1DOByear");
	By Adult2Click = By.xpath("(//span[@class='paxOpenClose via-collapse-control expand']/preceding-sibling::span)[1]");
	By Adult2 = By.id("adult2Title");
	By Adult2FN = By.id("adult2FirstName");
	By Adult2LN = By.id("adult2Surname");
	By DOB2 = By.id("adult2DOBday");
	By MOB2 = By.id("adult2DOBmonth");
	By YOB2 = By.id("adult2DOByear");
	By Childclick = By.xpath("(//span[@class='paxOpenClose via-collapse-control expand']/preceding-sibling::span)[3]");
	By Child = By.id("child1Title");
	By ChildFN = By.id("child1FirstName");
	By ChildLN = By.id("child1Surname");
	By DOB3 = By.id("child1DOBday");
	By MOB3 = By.id("child1DOBmonth");
	By YOB3 = By.id("child1DOByear");
	By Infantclick = By.xpath("(//span[@class='paxOpenClose via-collapse-control expand']/preceding-sibling::span)[5]");
	By Infant = By.id("infant1Title");
	By InfantFN = By.id("infant1FirstName");
	By InfantLN = By.id("infant1Surname");
	By DOB4 = By.id("infant1DOBday");
	By MOB4 = By.id("infant1DOBmonth");
	By YOB4 = By.id("infant1DOByear");
	By Phone = By.name("contactPhone");
	By Email = By.name("contactEmail");
	By vouchercode = By.xpath("(//div[@id='discountCode']/div/div)[2]");
	By Voucher = By.id("voucherCode");
	By VoucherBtn = By.xpath("//div[@class='element-voucher']/div[contains(text(),'Validate')]");
	By AmounttoPay = By.xpath("(//span[@class='js-total-amt-pay'])[4]");
	By TermsBox = By.id("msgInfoChkBox_label");
	By BookBtn = By.xpath("//button[contains(text(),'Proceed to Booking')]/parent::div");
	

	public PassengerInfo(WebDriver driver) throws Exception {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 80);
		this.oactions = new Actions(driver);
		this.oexcelUtils = new ViaExcelUtils("D:\\Selenium\\Sheet1.xlsx", "Via Flight Booking");
	}

	public void popUp() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(PopUp1));
			oactions.moveToElement(driver.findElement(PopUp1)).build().perform();
			driver.findElement(PopUp1).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adultInfo() {
		
		String otitle1 = oexcelUtils.getCellData(1,"Adult1Title");
		String oFname1 = oexcelUtils.getCellData(1,"AdultFName");
		String oLname1 = oexcelUtils.getCellData(1,"AdultLName");
		String oadult1DOB = oexcelUtils.getCellData(1,"AdultDOB");
		String oadult1MOB = oexcelUtils.getCellData(1,"AdultMOB");
		String oadult1YOB = oexcelUtils.getCellData(1,"AdultYOB");
		String otitle2 = oexcelUtils.getCellData(1, "Adult2Title");
		String oFname2 = oexcelUtils.getCellData(1, "Adult2FName");
		String oLname2 = oexcelUtils.getCellData(1, "Adult2LName");
		String oadult2DOB = oexcelUtils.getCellData(1,"Adult2DOB");
		String oadult2MOB = oexcelUtils.getCellData(1,"Adult2MOB");
		String oadult2YOB = oexcelUtils.getCellData(1,"Adult2YOB");
		
		
		try {
			Select adult1 = new Select(driver.findElement(Adult1));
			adult1.selectByVisibleText(otitle1);
			driver.findElement(AdultFN).sendKeys(oFname1);
			driver.findElement(AdultLN).sendKeys(oLname1);
			Select dob1 = new Select(driver.findElement(DOB1));
			dob1.selectByVisibleText(oadult1DOB);
			Select mob1 = new Select(driver.findElement(MOB1));
			mob1.selectByVisibleText(oadult1MOB);
			Select yob1 = new Select(driver.findElement(YOB1));
			yob1.selectByVisibleText(oadult1YOB);

			wait.until(ExpectedConditions.visibilityOfElementLocated(Adult2Click)).click();
			Select adult2 = new Select(driver.findElement(Adult2));
			adult2.selectByVisibleText(otitle2);
			driver.findElement(Adult2FN).sendKeys(oFname2);
			driver.findElement(Adult2LN).sendKeys(oLname2);
			Select dob2 = new Select(driver.findElement(DOB2));
			dob2.selectByVisibleText(oadult2DOB);
			Select mob2 = new Select(driver.findElement(MOB2));
			mob2.selectByVisibleText(oadult2MOB);
			Select yob2 = new Select(driver.findElement(YOB2));
			yob2.selectByVisibleText(oadult2YOB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void childInfo() {
		
		String ochild1 = oexcelUtils.getCellData(1,"Child Title");
		String oFname3 = oexcelUtils.getCellData(1,"ChildFName");
		String oLname3 = oexcelUtils.getCellData(1,"ChildLName");
		String ochildDOB = oexcelUtils.getCellData(1,"ChildDOB");
		String ochildMOB = oexcelUtils.getCellData(1,"ChildMOB");
		String ochildYOB = oexcelUtils.getCellData(1,"ChildYOB");
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Childclick)).click();
			Select child = new Select(driver.findElement(Child));
			child.selectByVisibleText(ochild1);
			driver.findElement(ChildFN).sendKeys(oFname3);
			driver.findElement(ChildLN).sendKeys(oLname3);
			Select dob3= new Select(driver.findElement(DOB3));
			dob3.selectByVisibleText(ochildDOB);
			Select mob3 = new Select(driver.findElement(MOB3));
			mob3.selectByVisibleText(ochildMOB);
			Select yob3 = new Select (driver.findElement(YOB3));
			yob3.selectByVisibleText(ochildYOB);	
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	public void infantInfo() {
		
		String oinfant1 = oexcelUtils.getCellData(1,"Infant Title");
		String oFname4 = oexcelUtils.getCellData(1,"InfantFName");
		String oLname4 = oexcelUtils.getCellData(1,"InfantLName");
		String oinfantDOB = oexcelUtils.getCellData(1,"InfantDOB");
		String oinfantMOB = oexcelUtils.getCellData(1,"InfantMOB");
		String oinfantYOB = oexcelUtils.getCellData(1,"InfantYOB");
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Infantclick)).click();
			Select infant = new Select(driver.findElement(Infant));
			infant.selectByVisibleText(oinfant1);
			driver.findElement(InfantFN).sendKeys(oFname4);
			driver.findElement(InfantLN).sendKeys(oLname4);
			Select dob4= new Select(driver.findElement(DOB4));
			dob4.selectByVisibleText(oinfantDOB);
			Select mob4 = new Select(driver.findElement(MOB4));
			mob4.selectByVisibleText(oinfantMOB);
			Select yob4 = new Select (driver.findElement(YOB4));
			yob4.selectByVisibleText(oinfantYOB);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void otherInfo() {
		
		String phone = oexcelUtils.getCellData(1,"PhoneNo");
		String email = oexcelUtils.getCellData(1,"EmailAddress");
		
		driver.findElement(Phone).sendKeys(phone);
		driver.findElement(Email).sendKeys(email);
	}
	public void voucherCode() {
		try {
			String couponcode = driver.findElement(vouchercode).getText();
			Thread.sleep(3000);
			oactions.sendKeys(Keys.TAB).build().perform();
			wait.until(ExpectedConditions.elementToBeClickable(Voucher)).sendKeys(couponcode);		
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(VoucherBtn)).click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void bookBtn() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(AmounttoPay)).isDisplayed();
			Thread.sleep(3000);
			driver.findElement(TermsBox).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(BookBtn));
			driver.findElement(BookBtn).click();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

