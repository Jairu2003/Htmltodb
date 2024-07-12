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

@WebServlet("/ret")
public class Retrive extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hiberdbjr", "root", "jairu");

			PreparedStatement ps = con.prepareStatement("select * from jrfriends");
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				pw.println("<h1>Welcome to Retrive Page</h1>");
				System.out.println("Retrive successfully");
				pw.println("Retrive successfully");
				pw.println("<br>");
				pw.println("F-Id |");
				pw.println("F-Name |");
				pw.println("Address <br>");
				if (rs.next()) {


					pw.println(rs.getString(1) + " |");
					pw.println(rs.getString(2) + " |");
					pw.println(rs.getString(3));

					pw.println("<br>");
				} else {
					pw.println("<br>");
					System.out.println("No data found");
					pw.println("No data found");
				}
			} else {
				System.out.println("Invalid");
				pw.println("Invalid");
			}
			ps.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}