package org.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Employeemanagement {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	try {
		Class.forName("org.postgresql.Driver");
		Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ram",
                "postgres",
                "Saiteja@1919");
		  System.out.println("\n****create a employee table****");
        String sql ="CREATE TABLE IF NOT EXISTS employee(" +
                     "emp_id INT PRIMARY KEY," +
                     "emp_name VARCHAR(50)," +
                     "email VARCHAR(50)," +
                     "department VARCHAR(50)," +
                     "salary DECIMAL(10,2))";
		PreparedStatement p=c.prepareStatement(sql);
		p.executeUpdate();
		System.out.println("====================================");
		System.out.println("Table Created Successfully");
		System.out.println("====================================");
		p.close();
		while(true) {
            System.out.println("\n1.Add");
            System.out.println("2.View");
            System.out.println("3.Update Salary");
            System.out.println("4.Delete");
            System.out.println("5.Exit");

            int choice = sc.nextInt();

            switch(choice) {

            case 1:
            	 System.out.print("Id: ");
                 int id = sc.nextInt();

                 System.out.print("Name: ");
                 String name = sc.next();

                 System.out.print("Email: ");
                 String email = sc.next();

                 System.out.print("Department: ");
                 String dept = sc.next();

                 System.out.print("Salary: ");
                 double sal = sc.nextDouble();

                 PreparedStatement ps1 =
                     c.prepareStatement(
                     "INSERT INTO employee VALUES(?,?,?,?,?)");
		 
					 ps1.setInt(1, id);
					 ps1.setString(2,name);
					 ps1.setString(3,email);
					 ps1.setString(4, dept);
					 ps1.setDouble(5, sal);
					 int row=ps1.executeUpdate();
					 System.out.println(row+"  employee added");
					 ps1.close();
					 break;
            case 2:
            	PreparedStatement ps2 =
                c.prepareStatement(
                "SELECT * FROM employee");

					 ResultSet rs=ps2.executeQuery();
					 while(rs.next()) {
	
					    System.out.println(
					        rs.getInt("emp_id") + " " +
					        rs.getString("emp_name") + " " +
					        rs.getString("email") + " " +
					        rs.getString("department") + " " +
					        rs.getDouble("salary")
					    );
					  }
					 ps2.close();
					 rs.close();
					 break;
            case 3:

                System.out.print("Employee Id: ");
                int eid = sc.nextInt();

                System.out.print("New Salary: ");
                double newsal = sc.nextDouble();

                PreparedStatement ps3 =
                    c.prepareStatement(
                    "UPDATE employee SET salary=? WHERE emp_id=?");

                ps3.setDouble(1, newsal);
                ps3.setInt(2, eid);

                ps3.executeUpdate();

                System.out.println("Salary Updated");
                ps3.close();
                break;
            case 4:

                System.out.print("Employee Id: ");
                int did = sc.nextInt();

                PreparedStatement ps4 =
                    c.prepareStatement(
                    "DELETE FROM employee WHERE emp_id=?");

                ps4.setInt(1, did);

                ps4.executeUpdate();

                System.out.println("Employee Deleted");
                break;

            case 5:
                c.close();
                System.out.println("bye.bye......");
                System.exit(0);
            }
           
		}
		
	}catch(Exception e) {
		System.out.println(e);
	}
	sc.close();
}
}
