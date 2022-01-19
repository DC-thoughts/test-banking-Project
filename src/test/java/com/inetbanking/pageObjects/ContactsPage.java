package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	WebDriver driver ;
	
	public ContactsPage(WebDriver rdriver) {
		
		this.driver=rdriver;
		PageFactory.initElements(rdriver,this );
	}
	
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
}
