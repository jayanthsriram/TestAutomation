package com.jayanth.pages;

import java.io.FileInputStream;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.jayanth.Base.Base;

public class LoginPage extends Base {
	
	@FindBy(xpath="//input[@id='phone-no']")
    public WebElement username;
	
	@FindBy(xpath="//button[normalize-space()='Next']")
	public WebElement Next;
	
	@FindBy(xpath="//input[@id='password-field']")
	public WebElement Password;
	
	@FindBy(xpath="//button[normalize-space()='Sign In']")
	public WebElement login;
	
	public LoginPage(){
	PageFactory.initElements(driver, this);
	}
	
	public String verifytitle(){
		return driver.getTitle();
		
	}
	public void loginwith(String un, String pwd){
		username.sendKeys(un);
		Next.click();
		Password.sendKeys(pwd);
		login.click();
	}
	
	
	public void newtest(){
		
		//Actions class
		Actions act= new Actions(driver);
		act.moveToElement(login);
		
		//Select class
		Select select= new Select(login);
		select.selectByIndex(1);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript(arg0, arg1)
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", login);

		
		FileInputStream fis = new FileInputStream("D:\\Test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
	}
}
