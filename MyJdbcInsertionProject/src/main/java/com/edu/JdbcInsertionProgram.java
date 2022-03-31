package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcInsertionProgram {

	public static void main(String[] args) {
		//making connection with the database
		int id;
		String name;
		String email;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id");
		id=sc.nextInt();
		System.out.println("enter name");
		name=sc.next();
		System.out.println("enter email");
		email=sc.next();
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/edudb";//edudb is database name
	    String un="root";
	    String pa="root";
	    try {
	    	//loading the driver 
	    	Class.forName(driver);
	    	Connection con=DriverManager.getConnection(url,un,pa);
	    	Statement st=con.createStatement();
	    	String ins="insert into details values("+id+","+name+","+email+")";
	    	int i=st.executeUpdate(ins);
	    	if(i>0)
	    	{
	    		System.out.println("record is inserted");
	    	}
	    	else
	    	{
	    		System.out.println("record is not inserted");
	    	}
	    }catch(Exception e)
	    {
	    	e.printStackTrace();
	    }

	}

}
