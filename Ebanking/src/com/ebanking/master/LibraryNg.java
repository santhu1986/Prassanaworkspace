package com.ebanking.master;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LibraryNg 
{
	WebDriver driver;
	String Expval,Actval;
	FileInputStream FIS;
	Properties PR;
  
	public String OpenApp(String Url) throws IOException 
	{
		FIS=new FileInputStream("E:\\Seleniumevngnov\\Ebanking\\src\\com\\ebanking\\properties\\Rep.properties");
		PR=new Properties();
		PR.load(FIS);
		
		
        Expval="Ranford Bank";
		
		driver=new FirefoxDriver();
		driver.get(Url);
		driver.manage().window().maximize();
		
		String Actval=driver.findElement(By.xpath("//span[@class='style10'][contains(.,'Ranford Bank')]")).getText();
		
		//Comparision
		
		if (Expval.equalsIgnoreCase(Actval))
		{
		System.out.println("Application Launch");	
		}
		else
		{
			System.out.println("Application Not launch");
		}
		
		return "Pass";
		
	}
	
	public void AdminLgn(String Un,String Pwd) 
	{
	Expval="Welcome to Admin";
		
		driver.findElement(By.id(PR.getProperty("Uname"))).sendKeys(Un);
		driver.findElement(By.id(PR.getProperty("Pswd"))).sendKeys(Pwd);
		driver.findElement(By.xpath(PR.getProperty("Lgn"))).click();
		
		Actval=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		
		//Comparision
		
				if (Expval.equalsIgnoreCase(Actval))
				{
				System.out.println("Admin Login Succ");	
				}
				else
				{
					System.out.println("Admin Login Failed");
				}
				
	
	}
	
	public void Bcreation() throws InterruptedException 
	{
		 //Branch Creation
		
		Expval="Sucessfully";

driver.findElement(By.xpath(PR.getProperty("Bbutton"))).click();
driver.findElement(By.id("BtnNewBR")).click();

driver.findElement(By.id("txtbName")).sendKeys("Srnagartelangana");
driver.findElement(By.id("txtAdd1")).sendKeys("Srnagar");
driver.findElement(By.id("txtZip")).sendKeys("78787");
//Dropdown

Select Ctry=new Select(driver.findElement(By.id("lst_counrtyU")));
Ctry.selectByVisibleText("INDIA");

new Select(driver.findElement(By.id("lst_stateI"))).selectByVisibleText("GOA");
new Select(driver.findElement(By.id("lst_cityI"))).selectByVisibleText("GOA");

driver.findElement(By.id("btn_insert")).click();

//Alert

Actval=driver.switchTo().alert().getText();
Thread.sleep(3000);
driver.switchTo().alert().accept();


if (Actval.contains(Expval))
{
System.out.println("Branch Created");	
}
else
{
	System.out.println("Branch Already Exist");
}
	}
	
	public String Role(String RN,String RT) throws InterruptedException
	{
		Expval="Sucessfully";
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
		driver.findElement(By.xpath(".//*[@id='btnRoles']")).click();
		driver.findElement(By.id("txtRname")).sendKeys(RN);
		driver.findElement(By.id("lstRtypeN")).click();
		driver.findElement(By.id("lstRtypeN")).sendKeys(RT);
		driver.findElement(By.xpath(".//*[@id='btninsert']")).click();
		Thread.sleep(4000);
		String Actval=driver.switchTo().alert().getText();
		
		System.out.println(Actval);
		
		
	      driver.switchTo().alert().accept();
	      driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();  
	      if (Actval.contains(Expval)) 
	      {
	    	  System.out.println("Role Created");
	    	  
			
		}
	      else{
	    	  System.out.println("role not created");
	    	  
	      }
	      return Actval;
	     }

	

	
	
}
