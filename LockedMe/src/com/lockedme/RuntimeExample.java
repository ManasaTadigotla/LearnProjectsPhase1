package com.lockedme;

import java.io.IOException;

public class RuntimeExample {

	public static void main(String[] args) 
	{
		try {
			//Runtime.getRuntime().exec("C://Manasa//FileProject//Adhya.txt");
			System.out.println("closing....");
			Runtime.getRuntime().exit(0);
			System.out.println("closing..");
		} catch (Exception e) {

			e.printStackTrace();
		}




	}

}
