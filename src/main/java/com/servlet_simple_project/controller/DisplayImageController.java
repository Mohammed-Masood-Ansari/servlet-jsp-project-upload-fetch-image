package com.servlet_simple_project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/imageDisplay")
public class DisplayImageController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		byte[] image = null;
		
		ServletOutputStream outputStream = null;
		
		String imageQuery = "SELECT image from imagestore where id = ?";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		    String dbURL = "jdbc:mysql://localhost:3306/zeromass";
		    String dbUser = "root";
		    String dbPass = "root";
		    
		    Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
		    
		    PreparedStatement preparedStatement = connection.prepareStatement(imageQuery);
		    
		    preparedStatement.setInt(1, 6575);
		    
		    ResultSet resultSet = preparedStatement.executeQuery();
		    
		    if(resultSet.next()) {
		    	
		    	image = resultSet.getBytes(1);
		    	
		    }
		    
		    outputStream = resp.getOutputStream();
		    outputStream.write(image);
		    
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
