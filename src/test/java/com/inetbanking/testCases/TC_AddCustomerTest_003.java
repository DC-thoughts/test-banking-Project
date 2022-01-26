package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test(dataProvider = "RegData")
	public void addNewCustomer(String name, String gender, String address, String city, String state, String pin,
			String telph) throws InterruptedException, IOException {

		LoginPage lp = new LoginPage(driver);

		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);

		addcust.clickAddNewCustomer();

		logger.info("providing customer details....");

		/*
		 * addcust.custName("Pavan"); addcust.custgender("male");
		 * addcust.custdob("10","15","1985"); Thread.sleep(5000);
		 * addcust.custaddress("INDIA"); addcust.custcity("HYD");
		 * addcust.custstate("AP"); addcust.custpinno("5000074");
		 * addcust.custtelephoneno("987890091");
		 * 
		 * String email=randomestring()+"@gmail.com"; addcust.custemailid(email);
		 * addcust.custpassword("abcdef");
		 */
		addcust.custName(name);
		addcust.custgender(gender);
		addcust.custdob("10", "15", "1985");
		Thread.sleep(5000);
		addcust.custaddress(address);
		addcust.custcity(city);
		addcust.custstate(state);
		addcust.custpinno(pin);
		addcust.custtelephoneno(telph);

		String email = randomestring() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		Thread.sleep(3000);
		if (isAlertPresent() == true) {

			driver.switchTo().alert().accept();
			logger.warn("Please fill all mandatory fields...");
			Assert.assertTrue(false);

		}

		Thread.sleep(3000);

		logger.info("validation started....");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");

		} else {
			logger.info("test case failed....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}

	}

	@DataProvider(name = "RegData")
	public static String[][] getData() throws IOException {

		String path = "C:\\testData\\RegDetails.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet2");
		int colnum = XLUtils.getCellCount(path, "Sheet2", 1);

		String custData[][] = new String[rownum][colnum];
		for (int i = 1; i <= rownum; i++) {

			for (int j = 0; j < colnum; j++) {

				custData[i - 1][j] = XLUtils.getCellData(path, "Sheet2", i, j);
			}
		}

		return custData;
	}

}
