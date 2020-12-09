package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminHP 
{
        //ELEMENT PROPERTIES
	
	@FindBy(xpath="//img[@src='images/Branches_but.jpg']")
	WebElement Branch;
	
	@FindBy(xpath=".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")
	WebElement Role;
	
	//Employee
	//Log Out
	
	//Element methods
	
	public void br() 
	{
	Branch.click();	
	}
	
	public void Rol() 
	{
	Role.click();	
	}
	
}
