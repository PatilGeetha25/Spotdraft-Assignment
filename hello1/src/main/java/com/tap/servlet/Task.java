package com.tap.servlet;
public class Task {
	private int id; // Task ID
	private String name;
	private String assignee;
	private String dueDate;
	private String description;

	// Constructors, getters, and setters
	public Task() {
		// TODO Auto-generated constructor stub
	}
	public Task(int id, String name, String assignee, String dueDate, String description) {
		super();
		this.id = id;
		this.name = name;
		this.assignee = assignee;
		this.dueDate = dueDate;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

