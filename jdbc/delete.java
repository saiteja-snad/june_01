package org.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class delete {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	try{
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ram","postgres","Saiteja@1919");
		PreparedStatement p=con.prepareStatement("delete from student where id=?");
		int id=sc.nextInt();
		p.setInt(1, id);
		int rs=p.executeUpdate();
		if(rs>0) {
			System.out.println("record deleted successfully");
		}
		else{
			System.out.print("student id not found");
		}
	}catch(Exception e) {
		System.out.println(e);
	}
}
}
