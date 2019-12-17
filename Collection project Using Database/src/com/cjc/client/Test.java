package com.cjc.client;

import java.util.Scanner;

import com.cjc.service.Operation;

public class Test 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Operation op=new Operation();
		while(true)
		{
			System.out.println(" press 1 for addCourse \n press 2for viewCourse \n press 3 for addFaculty \n press 4 for viewFaculty \n press 5 for addBatch \n press 6 for viewBatch \n press 7 for addStudent \n press 8 for viewStudent \n press 9 for exit\n Enter a choice");
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				  op.addCourse();
				  break;
			case 2:
				op.viewCource();
		/*		break;
			case 3:
				op.addFaculty();
				break;
			case 4:
				op.viewFaculty();
				break;
			case 5:
				op.addBatch();
				break;
			case 6:
				op.viewBatch();
				break;
			case 7:
				op.addStudent();
				break;
			case 8:
				op.viewBatch();
				break;
			case 9:
				System.exit(0);
				break;
		*/	default:
				System.out.println("Enter valid choice");
			}
		}
	}
}
