package com.jayanth.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jayanth.Base.Base;
import com.jayanth.pages.LoginPage;

public class Test1 extends Base{
	
	 LoginPage loginPage;
	
	Test1(){
		super();
	}
	
	@BeforeMethod
	public void init(){
		setup();
		driver.get(prop.getProperty("url"));
		loginPage=new LoginPage();
	}
	
	@Test
	public void test1Verifytitle(){
		String ss=loginPage.verifytitle();
		Assert.assertEquals(ss, "Happay Expense");
	}
	
	@Test
	public void test1(){
		loginPage.loginwith(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
}
