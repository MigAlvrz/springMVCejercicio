package com.capgemini.model;

import java.util.ArrayList;

public class User {
	private String login;
	private String email;
	private String password;
	private UserStatus status;
	private boolean isAdmin;
	private ArrayList<Task> tareas;
}
