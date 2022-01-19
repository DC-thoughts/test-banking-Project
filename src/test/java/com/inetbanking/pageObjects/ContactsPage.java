package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	WebDriver driver ;
	
	public ContactsPage(WebDriver rdriver) {
		
		this.driver=rdriver;
		PageFactory.initElements(rdriver,this );
	}
}
