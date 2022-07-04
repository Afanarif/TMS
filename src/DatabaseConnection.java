
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hasham
 */
public class DatabaseConnection {      
       private Connection con;
       public Statement ps;
       public ResultSet rs;
       
       DatabaseConnection()
       {
           
       try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ums", "root", "");
        ps = con.createStatement();
        System.out.println("DB is Connected");
       }    
       catch(ClassNotFoundException | SQLException e){
        System.out.println(e);
       }
       
       }
       
           public ResultSet AdminAddStudentDetails(String ID, String Name,String FatherName,int Age,String Gender,String CourseName,String Email,String PhoneNo,Float X,Float XII)
    {
        try
        {
            
            ps.executeUpdate("INSERT INTO `studentdetails`(`ID`, `Name`, `FatherName`, `Age`, `Gender`, `CourseName`, `Email`, `Phone`, `ClassX%`, `ClassXII%`) VALUES ('"+ID+"','"+Name+"','"+FatherName+"','"+Age+"','"+Gender+"','"+CourseName+"','"+Email+"','"+PhoneNo+"','"+X+"','"+XII+"')");
            JOptionPane.showMessageDialog(null, "Data Added");
            ps.close();
        }
        catch(HeadlessException | SQLException e1)
        {
            JOptionPane.showMessageDialog(null, e1.getMessage());
        }
           return rs;
    }
           public ResultSet AdminAddTeacherDetails(String ID, String Name,String FatherName,int Age,String Gender,String CNIC,String Education,String Department,String Email,String PhoneNo)
    {
        try
        {
            
            ps.executeUpdate("INSERT INTO `teacherdetails`(`ID`, `Name`, `FatherName`, `Age`, `Gender`, `CNIC`, `Education`, `Department`, `Email`, `Phone`) VALUES ('"+ID+"','"+Name+"','"+FatherName+"','"+Age+"','"+Gender+"','"+CNIC+"','"+Education+"','"+Department+"','"+Email+"','"+PhoneNo+"')");
            
            JOptionPane.showMessageDialog(null, "Data Added");
            
        }
        catch(HeadlessException | SQLException e1)
        {
            JOptionPane.showMessageDialog(null, e1.getMessage());
        }
           return rs;
    }
           public ResultSet AdminAddTeacher(String ID,String Username,String Password)
    {
        try
        {
            ps.executeUpdate("insert into teacherlogin(ID,Username,Password) values('"+ID+"','"+Username+"','"+Password+"')");
            JOptionPane.showMessageDialog(null, "Data Added");
            ps.close();
        }
        catch(HeadlessException | SQLException e1)
        {
            JOptionPane.showMessageDialog(null, "Teacher Already Exist");
        }
           return rs;
    
    }
           
           public ResultSet RemoveTeacherRecords(String ID)
        {
        try
        {
             
        ps.executeUpdate("delete from teacherlogin where ID = '"+ID+"'");
        JOptionPane.showMessageDialog(null, "Record Deleted");
        }
        catch(SQLException e)
        {
        JOptionPane.showMessageDialog(null, "Connection Error");
        }
           return rs;
        
        }
           public ResultSet UpdateTeacherRecords(String ID,String Username,String Password,String id)
        {
        try
        {
             
        ps.executeUpdate("update teacherlogin set ID = '"+ID+"', Username = '"+Username+"',Password = '"+Password+"' where ID = '"+id+"' ");
        JOptionPane.showMessageDialog(null, "Record Updated");
        }
        catch(SQLException e)
        {
        JOptionPane.showMessageDialog(null, "Connection Error");
        }
           return rs;
        
        }
           public ResultSet SearchTeacherRecords(String ID)
        {
        try
        {
             
        rs = ps.executeQuery("Select * from teacherlogin where ID = '"+ID+"' ");
        
        }
        catch(SQLException e)
        {
        JOptionPane.showMessageDialog(null, "Connection Error");
        }
           return rs;
        
        }
           public ResultSet AdminAddStudentResult1(String ID, String S1,String S2,String S3,String S4,String S5,String S1M,String S2M,String S3M,String S4M,String S5M)
    {
        try
        {
            
            ps.executeUpdate("INSERT INTO `subject`(`ID`, `Subject1`, `Subject2`, `Subject3`, `Subject4`, `Subject5`) VALUES ('"+ID+"','"+S1+"','"+S2+"','"+S3+"','"+S4+"','"+S5+"')");
            //ps.executeUpdate("UPDATE `subject` SET `ID`='[value-1]',`Subject1`='[value-2]',`Subject2`='[value-3]',`Subject3`='[value-4]',`Subject4`='[value-5]',`Subject5`='[value-6]',`Subject6`='[value-7]',`Subject7`='[value-8]',`Subject8`='[value-9]',`Subject9`='[value-10]',`Subject10`='[value-11]',`Subject11`='[value-12]',`Subject12`='[value-13]',`Subject13`='[value-14]',`Subject14`='[value-15]',`Subject15`='[value-16]',`Subject16`='[value-17]',`Subject17`='[value-18]',`Subject18`='[value-19]',`Subject19`='[value-20]',`Subject20`='[value-21]' WHERE ID = '"+ID+"'");
            ps.executeUpdate("INSERT INTO `marks`(`ID`, `Subject1Marks`, `Subject2Marks`, `Subject3Marks`, `Subject4Marks`, `Subject5Marks`) VALUES ('"+ID+"','"+S1M+"','"+S2M+"','"+S3M+"','"+S4M+"','"+S5M+"')");
            JOptionPane.showMessageDialog(null, "Subject with Marks Added");
            ps.close();
        }
        catch(HeadlessException | SQLException e1)
        {
            JOptionPane.showMessageDialog(null, e1.getMessage());
        }
           return rs;
    }
           public ResultSet AdminAddStudentResult2(String ID,String S1,String S2,String S3,String S4,String S5,String S1M,String S2M,String S3M,String S4M,String S5M)
    {
        try
        {
            
            //ps.executeUpdate("INSERT INTO `subject`(`Subject6`, `Subject7`, `Subject8`, `Subject9`, `Subject10`) VALUES ('"+S1+"','"+S2+"','"+S3+"','"+S4+"','"+S5+"') ");
            ps.executeUpdate("UPDATE `subject` SET Subject6 = '"+S1+"', Subject7 = '"+S2+"', Subject8 = '"+S3+"', Subject9 ='"+S4+"', Subject10 = '"+S5+"' WHERE ID = '"+ID+"'");
            ps.executeUpdate("UPDATE `marks` SET Subject6Marks = '"+S1M+"', Subject7Marks = '"+S2M+"', Subject8Marks = '"+S3M+"', Subject9Marks = '"+S4M+"', Subject10Marks = '"+S5M+"' WHERE ID = '"+ID+"'");
            JOptionPane.showMessageDialog(null, "Semester 2 Subject with Marks Added");
            ps.close();
        }
        catch(HeadlessException | SQLException e1)
        {
            JOptionPane.showMessageDialog(null, e1.getMessage());
        }
           return rs;
    }
           public ResultSet AdminAddStudentResult3(String ID,String S1,String S2,String S3,String S4,String S5,String S1M,String S2M,String S3M,String S4M,String S5M)
    {
        try
        {
            
            ps.executeUpdate("UPDATE `subject` SET `Subject11`='"+S1+"',`Subject12`='"+S2+"',`Subject13`='"+S3+"',`Subject14`='"+S4+"',`Subject15`='"+S5+"' WHERE ID = '"+ID+"'");
            ps.executeUpdate("UPDATE `marks` SET `Subject11Marks`='"+S1M+"',`Subject12Marks`='"+S2M+"',`Subject13Marks`='"+S3M+"',`Subject14Marks`='"+S4M+"',`Subject15Marks`='"+S5M+"' WHERE ID = '"+ID+"'");
            JOptionPane.showMessageDialog(null, "Semester 3 Subject with Marks Added");
            ps.close();
        }
        catch(HeadlessException | SQLException e1)
        {
            JOptionPane.showMessageDialog(null, e1.getMessage());
        }
           return rs;
    }
           public ResultSet AdminAddStudentResult4(String ID,String S1,String S2,String S3,String S4,String S5,String S1M,String S2M,String S3M,String S4M,String S5M)
    {
        try
        {
            
            ps.executeUpdate("UPDATE `subject` SET `Subject16`='"+S1+"',`Subject17`='"+S2+"',`Subject18`='"+S3+"',`Subject19`='"+S4+"',`Subject20`='"+S5+"' WHERE ID = '"+ID+"'");
            ps.executeUpdate("UPDATE `marks` SET `Subject16Marks`='"+S1M+"',`Subject17Marks`='"+S2M+"',`Subject18Marks`='"+S3M+"',`Subject19Marks`='"+S4M+"',`Subject20Marks`='"+S5M+"' WHERE ID = '"+ID+"'");
            JOptionPane.showMessageDialog(null, "Semester 4 Subject with Marks Added");
            ps.close();
        }
        catch(HeadlessException | SQLException e1)
        {
            JOptionPane.showMessageDialog(null, e1.getMessage());
        }
           return rs;
    }
                   public ResultSet UpdateTeacherRecords(int ID,String Username,String Password,int id)
        {
        try
        {
             
        ps.executeUpdate("update teacherlogin set ID = '"+ID+"', Username = '"+Username+"',Password = '"+Password+"' where ID = '"+id+"' ");
        JOptionPane.showMessageDialog(null, "Record Updated");
        }
        catch(SQLException e)
        {
        JOptionPane.showMessageDialog(null, "Connection Error");
        }
           return rs;
        
        }
                   public ResultSet RemoveTeacherRecords(int ID)
        {
        try
        {
             
        ps.executeUpdate("delete from teacherlogin where ID = '"+ID+"'");
        JOptionPane.showMessageDialog(null, "Record Deleted");
        }
        catch(SQLException e)
        {
        JOptionPane.showMessageDialog(null, "Connection Error");
        }
           return rs;
        
        }
                   public ResultSet SearchTeacherRecords(int ID)
        {
        try
        {
             
        rs = ps.executeQuery("Select * from teacherlogin where ID = '"+ID+"' ");
        
        }
        catch(SQLException e)
        {
        JOptionPane.showMessageDialog(null, "Connection Error");
        }
           return rs;
        
        }
}
