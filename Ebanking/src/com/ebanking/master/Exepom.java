package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exepom 
{
	
	
	WebDriver driver;
	
    @BeforeTest
	public void login() throws InterruptedException 
	{
	driver=new FirefoxDriver();
	driver.get("http://122.175.8.158/ranford2");
	driver.manage().window().maximize();
	
	//pagefactory
	
	RanfordHP RHP=PageFactory.initElements(driver,RanfordHP.class);
	RHP.login();
	}
    
    @Test
    public void RCret() throws InterruptedException, IOException 
    {
    	
	//To get test data file
		
		FileInputStream Fis=new FileInputStream("E:\\Seleniumevngnov\\Ebanking\\src\\com\\ebanking\\testdata\\Role.xlsx");
		
		//Work book
		
		XSSFWorkbook WB=new XSSFWorkbook(Fis);
		
		//Sheet
		
		XSSFSheet WS=WB.getSheet("Rdata");
		
		//Row count
		
		int Rc=WS.getLastRowNum();
		System.out.println(Rc);
		
		//multiple Iterations ----  Loop (For)
		
		for (int i=1;i<=Rc;i++) 
		{
			//Row
			
			XSSFRow WR= WS.getRow(i);
			
			//Cells
			
			XSSFCell WC=WR.getCell(0);
			XSSFCell WC1=WR.getCell(1);
			
			XSSFCell WC2=WR.createCell(2);
			
			//Cell Values
			
			String Rname=WC.getStringCellValue();
			String Rtyp=WC1.getStringCellValue();

    	
	Thread.sleep(3000);
	AdminHP AHP=PageFactory.initElements(driver,AdminHP.class);
	AHP.Rol();
	Thread.sleep(3000);
	RoleDetails RD=PageFactory.initElements(driver,RoleDetails.class);
	RD.Nrole();
	RoleCreation RC=PageFactory.initElements(driver,RoleCreation.class);
	RC.Rcre(Rname,Rtyp);
	
	Thread.sleep(3000);
	
	driver.switchTo().alert().accept();
	Thread.sleep(3000);
	RD.Hom();
	
    }
    }
   
}