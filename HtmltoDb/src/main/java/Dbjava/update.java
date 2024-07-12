package Dbjava;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class update<Int> extends HttpServlet {
   

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
       
    
    	 int sid = Integer.parseInt(req.getParameter("ids"));
        String Sn = req.getParameter("name");
        String Sad = req.getParameter("add");
       
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        try {
          
        Connection con= DriverManager.getConnection( "jdbc:mysql://localhost:3306/hiberdbjr","root","jairu");

String sql="UPDATE jrfriends SET Fname=?,Faddress=? WHERE fid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, Sn);
		ps.setString(2, Sad);
		ps.setInt(3,sid);
		
      
          
            int rowsUpdate = ps.executeUpdate();
            if (rowsUpdate > 0) {
                res.getWriter().write("Data Updated successfully!");
            } else {
                res.getWriter().write("Failed to update data.");
            }

            // Close the database connection
            ps.close();
            con.close();
        } catch (SQLException  e) {
          
			e.printStackTrace();
            res.getWriter().write("Database error: " + e.getMessage());
        }
    }
}
