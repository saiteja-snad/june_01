package org.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class CallableStatement {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	try {
	Class.forName("org.postgresql.Driver");
	Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ram","postgres","Saiteja@1919");
java.sql.CallableStatement cs =
c.prepareCall("CALL add_student(?,?,?,?)");

cs.setInt(1, 10);
cs.setString(2, "Kiran");
cs.setString(3, "kiran@gmail.com");
cs.setString(4, "Python");

cs.execute();
System.out.println("Procedure Executed Successfully");
cs.close();
c.close();
	}catch(Exception e) {
		System.out.println(e);
	}
}
}
