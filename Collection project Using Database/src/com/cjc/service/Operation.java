package com.cjc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.cjc.model.Batch;
import com.cjc.model.Course;
import com.cjc.model.Faculty;
import com.cjc.model.Student;

public class Operation implements Service_I
{
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void addCourse()
	{
		System.out.println("Enter a course id=");
		int cid=sc.nextInt();
		System.out.println("Enter a course name=");
		String cname=sc.next();
		
		Course c=new Course ();
			   c.setCid(cid);
			   c.setCname(cname);
		try{	   
	    Class.forName("com.mysql.jdbc.Driver");
	    
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testrathod","root","root");
	    
	    String sql="insert into cource values(?,?)";
	    
	    PreparedStatement ps=con.prepareStatement(sql);
	    
	    ps.setInt(1,c.getCid());
	    ps.setString(2,c.getCname());
	    
	    ps.execute();
		}
		catch(Exception e)
		{
			
		}
		
		
	}

	@Override
	public void viewCource()
	{
		try
		{
		Course c=new Course ();
		
        Class.forName("com.mysql.jdbc.Driver");
	    
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testrathod","root","root");
	    
	    String sql="select *from cource";
	    
	    PreparedStatement ps=con.prepareStatement(sql);
	    
	   	    ResultSet rs=ps.executeQuery();
	   	    while(rs.next())
	   	    {
	   	    	System.out.println(rs.getInt(1));
	   	    	System.out.println(rs.getString(2));
	   	    }
		}
		catch(Exception e)
		{
			
		}
	    
			   
	}
/*
	@Override
	public void addFaculty() 
	{	
		try
		{
	    Faculty f=new Faculty();
		System.out.println("Enter a faculty id=");
		int fid=sc.nextInt();
		System.out.println("Enter a faculty name=");
		String fname=sc.next();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testrathod","root","root");
		String sql="insert into faculty values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,f.getFid());
			ps.setString(2,f.getFname());
			ps.setInt(3,f.getCourse().getCid());
		}
		catch(Exception e)
		{
			
		}
	}
*/
/*	@Override
	public void viewFaculty() 
	{
		try{
		Faculty f=new Faculty();
		System.out.println("Enter a faculty id=");
		int fid=sc.nextInt();
		System.out.println("Enter a faculty name=");
		String fname=sc.next();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testrathod","root","root");
		String sql="insert into faculty values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		
	}

	@Override
	public void addBatch() 
	{
			Batch b=new Batch();
		System.out.println("Enter a batch id=");
		int bid=sc.nextInt();
		System.out.println("Enter a batch name=");
		String bname=sc.next();
		
		System.out.println("Enter a fid");
		int fid1=sc.nextInt();
		Iterator<Faculty>itr=facultyList.iterator();
		while(itr.hasNext())
		{
			Faculty f=itr.next();
			if(fid1==f.getFid())
			{
				b.setBid(bid);
				b.setBname(bname);
				b.setFaculty(f);
				
				batchList.add(b);
			}
			else
			{
				System.out.println("enter valid fid");
			}
		}
			  
		
			  
		
	}

	@Override
	public void viewBatch() 
	{
	Iterator<Batch> itr2=batchList.iterator();
	System.out.println("bid\tbname\tfname\tcname");
	    while(itr2.hasNext())
	    {
	    	Batch b=itr2.next();
	    	System.out.println(b.getBid()+"\t"+b.getBname()+"\t"+b.getFaculty().getFname()+"\t"+b.getFaculty().getCourse().getCname());
	    }
		
	}

	@Override
	public void addStudent() 
	{
		Student s=new Student();
		System.out.println("Enter a student id=");
		int sid=sc.nextInt();
		System.out.println("Enter a student name=");
		String sname=sc.next();
		
		System.out.println("Enter a bid");
		int bid1=sc.nextInt();
		Iterator<Batch>itr=batchList.iterator();
		while(itr.hasNext())
		{
			Batch b=itr.next();
			if(bid1==b.getBid())
			{
				s.setSid(sid);
				s.setSname(sname);
				s.setBatch(b);
				studentList.add(s);
			}
			else
			{
				System.out.println("enter a valid bid");
			}
		}
		
	}

	@Override
	public void viewStudent() 
	{
	Iterator<Student> itr3=studentList.iterator();
	System.out.println("sid\tsname\tbname\tfname\tcname");
	  	while(itr3.hasNext())
	  	{
	  		Student s=itr3.next();
	  		System.out.println(s.getSid()+"\t"+s.getSname()+"\t"+s.getBatch().getBname()+"\t"+s.getBatch().getFaculty().getFname()+"\t"+s.getBatch().getFaculty().getCourse().getCname());
	  	}
		
	}

*/}
