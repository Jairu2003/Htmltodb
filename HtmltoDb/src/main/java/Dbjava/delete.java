package Dbjava;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class delete extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
 String srnoStr = req.getParameter("name"); 

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hiberdbjr", "root", "jairu");

            PreparedStatement ps = con.prepareStatement("delete from jrfriends WHERE fid= '"+srnoStr+"'");
            int i = ps.executeUpdate();
            if(i>0) {
				System.out.println("Delete successfully");
				pw.println("Deleted successfully");
			}
			else {
				System.out.println("No record found");
				pw.print("No record found");
			}
            
            
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
