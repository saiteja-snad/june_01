package org.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class PostgreSQLConnection {
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
        try {

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ram","postgres",
                    "Saiteja@1919" );
            //Statement st=con.createStatement();
           // String sql ="update student set course='full stack java' where id=2;";
            PreparedStatement ps=con.prepareStatement("select *from student where id=? and name=?");
            //st.executeUpdate("create table student(id int,name varchar(50),email varchar(50),course varchar(40));");
//            st.executeUpdate(
//            	    "INSERT INTO student VALUES " +
//            	    "(1,'saiteja','sai@gmail.com','java')," +
//            	    "(2,'anu','anu@gmail.com','java')," +
//            	    "(3,'prasad','prasad@gmail.com','mern')"
//            	);
            int ids=sc.nextInt();
            String names=sc.next();
            ps.setInt(1, ids);
            ps.setString(2, names);
           ResultSet rs= ps.executeQuery();
      
           
           if(rs.next()) {
        		 System.out.println("login successful");
        	 }
        	 else {
        		 System.out.println("invalid inputs");
        	 }
//        	  System.out.println(
//                      id + " " +
//                      name + " " +
//                      email + " " +
//                      course);
          
          System.out.println("insert table successfull");
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}


