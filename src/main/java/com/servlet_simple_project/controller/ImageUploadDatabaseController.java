package com.servlet_simple_project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.servlet_simple_project.dto.User;

@WebServlet("/uplodaPhoto")
@MultipartConfig(maxFileSize = 16177215)
public class ImageUploadDatabaseController  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 // database connection settings
		    String dbURL = "jdbc:mysql://localhost:3306/zeromass";
		    String dbUser = "root";
		    String dbPass = "root";
		    
		    Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
		    
		    String insertQuery = "insert into imagestore values(?,?,?)";
		    
		    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
		    
		    int userId =Integer.parseInt(req.getParameter("id")) ;
		    String userName = req.getParameter("name");
		    
		    Part userImage = req.getPart("photo");
		    
		    System.out.println(userImage.getContentType());
		    System.out.println(userImage.getSize());
		    
		    User user = new User();
		    
		    user.setUserId(userId);
		    user.setUserImage(userImage.getInputStream());
		    user.setUserName(userName);
		    preparedStatement.setInt(1, user.getUserId());
		    preparedStatement.setString(2, user.getUserName());
		    preparedStatement.setBlob(3, user.getUserImage());
		    
		    PrintWriter printWriter = resp.getWriter();
		    
		    printWriter.write("<html><body>");
		    if(user.getUserImage()!=null) {
		    	
		    	printWriter.write("<h4>Data------Stored</h4>");
		    	preparedStatement.execute();
		    }
		    printWriter.write("</body></html>");
		    
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
