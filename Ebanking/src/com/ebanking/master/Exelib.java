package com.ebanking.master;

import java.io.IOException;

public class Exelib {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
	
		//Instance class
		
		Library LB=new Library();
		
		String Retval=LB.OpenApp("http://122.175.8.158/ranford2");
		System.out.println(Retval);
		LB.AdminLgn("Admin","M1ndq");
		LB.Role("Tellerzx","E");
		
	}

}
