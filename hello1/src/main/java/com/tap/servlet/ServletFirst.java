package com.tap.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/storetask")
public class ServletFirst extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	int id = Integer.parseInt(request.getParameter("id"));
        String taskName = request.getParameter("name");
        String assignee = request.getParameter("assign");
        String dueDate = request.getParameter("date");
        String description = request.getParameter("descrip");
        Task task = new Task();
        task.setId(id);
        task.setName(taskName);
        task.setAssignee(assignee);
        task.setDueDate(dueDate);
        task.setDescription(description);
        boolean success = storeTaskInDatabase(task);
        response.setContentType("text/plain");
        if (success) {
            response.getWriter().println("Task stored in the database.");
        } else {
            response.getWriter().println("Failed to store the task in the database.");
        }

    }



    private boolean storeTaskInDatabase(Task task) {
    	System.out.println("Hello");
    
        String jdbcUrl = "jdbc:mysql://localhost:3306/assignment";
        String jdbcUsername = "root";
        String jdbcPassword = "Nish123*";
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try (
        		
        	Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            String insertQuery = "INSERT INTO data (taskid, name, assignee, due_date, description) VALUES (?,?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            	preparedStatement.setInt(1, task.getId());
                preparedStatement.setString(2, task.getName());
                preparedStatement.setString(3, task.getAssignee());
                preparedStatement.setString(4, task.getDueDate());
                preparedStatement.setString(5, task.getDescription());
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
