package Dbjava;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/rrr")
public class Retrivebyid extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		String ids = req.getParameter("id");
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hiberdbjr", "root", "jairu");

			PreparedStatement ps = con.prepareStatement("select * from jrfriends where fid=? ");
			ps.setString(1, ids);
			
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				System.out.println("Retrive ById successfully");
				pw.println("Records");
				pw.println("<br>");
				pw.println("Id |");
				pw.println("Name |");
				pw.println("Address <br>");
				if (rs.next()) {
					pw.println("<br>");
					int id = rs.getInt("fid");
					String name = rs.getString("fname");
					String add = rs.getString("faddress");
					System.out.println(id + name + add);
					pw.println(id + " |");
					pw.println(name + " |");
					pw.println(add + " |");
					pw.println("<br>");
				} else {
					pw.println("<br>");
					System.out.println("No data found");
					pw.println("No data found");
				}

			} else {
				pw.println("<br>");
				System.out.println("Invalid");
				pw.println("Invalid");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
