package com.lockedme;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserFileOperation 
{
	
	public int MakeChoice()
	{
		int userChoice=0;
	do {
		Scanner userInput=new Scanner(System.in);
		System.out.println("Please select the operation you want to perform");
		System.out.println("1.Add File");
		System.out.println("2.Display All Files");
		System.out.println("3.Search File");
		System.out.println("4.Delete File");
		System.out.println("5.Close");
		if(userInput.hasNextInt())
		{
			userChoice=userInput.nextInt();
			return userChoice;
		}
		else
		{
			System.out.println("Please Give Proper input.(Number 1-10) ");
			
		}
	}while(userChoice==0);
	
	
	return userChoice;
		
	}

	public static void main(String[] args) throws IOException 
	{
		int choice;
		String fileName;
		String filePath;
		String fileType="txt";
		boolean isAdded;
		Scanner userInput;
		UserFileOperation userOperation=new UserFileOperation();
		choice=userOperation.MakeChoice();
		while(choice>0 && choice<6)
		{
			filePath=System.getProperty("user.dir");
			FileUtil fileOperation=new FileUtil();
			
			//System.out.println(filePath);
			switch (choice) 
			{
				case 1: 
				{
					System.out.println("please enter file Name");
					fileName=new Scanner(System.in).next();
					if(filePath!=null)
					{
						isAdded=fileOperation.addFile(fileName, fileType,filePath);
						if(isAdded)
							System.out.println("File added successfully..");
						else
							System.err.println("File alredy exists with the same name");
						
					}
					else
					{
						System.out.println("Sorry,File is not created.Please try again..");
					}
					break;
				}
				case 2:
				{
					Boolean isDeleted;
					System.out.println("eneter file name.File name is case sensitive");
					fileName=new Scanner(System.in).next();
					isDeleted=fileOperation.deleteFile(fileName);
					if(isDeleted)
						{
						System.out.println("File deleted successfully");
						}
					else
						System.out.println(fileName +"file not found");
						
					break;
				}
				case 3:
				{
					List<MyFile> allFiles=new ArrayList<>();
			        allFiles=fileOperation.getFiles();
			        for(MyFile f:allFiles)
					System.out.println(f.getId()+"\t"+f.getFileName());
				    break;
				}
				case 4:
				{	
					boolean isFound=false;
					System.out.println("enter file name");
					fileName=new Scanner(System.in).next();
					isFound=fileOperation.searchFile(fileName);
					if(isFound)
						System.err.println("file exists");
					else
						System.out.println("file doesnt exit");
					break;
				}
				case 5:
				{
					System.out.println("Thank you...Bye");
					Runtime.getRuntime().exit(0);
					
					break;
						
				}			
			
				default:
						System.out.println("This choice is not available");
						
			}			
			System.out.println("Do you want to perform anothe action?"+"\\n "+"press 1 to continue");
			userInput=new Scanner(System.in);
			int optionContinue=userInput.nextInt();
			if(optionContinue==1)
			choice=userOperation.MakeChoice();
			else
			{
				System.out.println("thank you for choosing.. ");
				
				Runtime.getRuntime().gc();
				Runtime.getRuntime().exit(0);
			}
		}
		
	}
	
		

	

}
