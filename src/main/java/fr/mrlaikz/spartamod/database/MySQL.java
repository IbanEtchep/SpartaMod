package fr.mrlaikz.spartamod.database;

import fr.mrlaikz.spartamod.SpartaMod;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
	
	private SpartaMod plugin;
	
	private String host = plugin.strConfig("database.host");
  
	private String port = plugin.strConfig("database.port");
  
	private String database = plugin.strConfig("database.database");
  
	private String username = plugin.strConfig("database.username");
  
	private String password = plugin.strConfig("database.password");
  
	private Connection connection;
  
	public MySQL(SpartaMod plugin) {
		this.plugin = plugin;
	}
  
	public boolean isConnected() {
		return !(this.connection == null);
	}
  
	public void connect() throws SQLException {
		if (!isConnected()) {
			this.connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database + "?useSSL=false", this.username, this.password); 
		}
	}
  
	public void disconnect() {
		if (isConnected())
			try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}  
	}
  
	public Connection getConnection() {
		return this.connection;
	}
}
