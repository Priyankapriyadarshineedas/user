package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regform")
public class Register extends HttpServlet{

	protected void dopost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter out =resp.getWriter();
		String myname=req.getParameter("name1");
		String myemail=req.getParameter("email1");
		String mypass=req.getParameter("pass1");
		String mygender=req.getParameter("gender1");
		String mycity=req.getParameter("city1");
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","Priyanka@2001");
		PreparedStatement ps= con.prepareStatement("insert into employee values(?,?,?,?,?)");
		ps.setString(1,myname);
		ps.setString(2,myemail);
		ps.setString(3,mypass);
		ps.setString(4,mygender);
		ps.setString(5,mycity);
		
		int count=ps.executeUpdate();
		if(count>1)
		{
			//System.out.println("inset the data successfully");
			resp.setContentType("text/html");
			out.print("<h3 style='color:green'>user submited successfully<h3/>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/form.html");
			rd.include(req, resp);
		}		{
			//System.out.println("not  inserted");
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>user not registered due to some error<h3/>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/form.html");
			rd.include(req, resp);
		}
		PreparedStatement ps1= con.prepareStatement("delete from employee where name='priyanka'");
		//ps1.setString(1, myname);
		int count1=ps1.execute();
		PreparedStatement ps2= con.prepareStatement("UPDATE employee"SET email = ?, 
				"WHERE name=?");
		ps2.setString(1, email);
		ps2.setString(2, name1);
		int count1=ps.executeUpdate();
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
	}
	con.close();

}
