package com.github.GitHub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GitHubLogin {

	static WebDriver driver;
	static int seconds = 2000;
	
	public static void Open_Browser(String s,String d){
		driver=new FirefoxDriver();
	}
	
	public static WebElement WaitforElement(By locator,int seconds){
		return(new WebDriverWait(driver,seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void Navigate_Browser(String s,String d){
		driver.get("https://github.com/login");
	}
	
	public static void Input_Username(String s,String d){
		WaitforElement(By.xpath(s), seconds).sendKeys(d);
	}
	
	public static void Input_Password(String s,String d){
		WaitforElement(By.xpath(s), seconds).sendKeys(d);
	}
	
	public static void Signin_Click(String s,String d){
		WaitforElement(By.xpath(s), seconds).click();
	}
	
	public static void Profile_Click(String s,String d){
		WaitforElement(By.xpath(s), seconds).click();
	}
	
	public static void Signout_Click(String s, String d){
		WaitforElement(By.xpath(s), seconds).click();
	}
	
	public static void Close_Browser(String s, String d){
		driver.close();
	}
	
}
