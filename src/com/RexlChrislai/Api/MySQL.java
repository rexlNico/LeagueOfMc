package com.RexlChrislai.Api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

public class MySQL {
    public static String user = "db_82302";
    public static String pass = "ba22afa7b9";
    public static String host = "mysql.mc-host24.de";
    public static String db = "db_82302";
    public static int port = 3306;
    public static java.sql.Connection connection;
   
	  public static void connect() {
	  System.out.println("[MySQL] Verbindung aufgebaut.");
	  try {
	      // Connect
	      Class.forName("com.mysql.jdbc.Driver");
	      connection = DriverManager.getConnection("jdbc:mysql://" + host + ":"+port +"/" + db, user, pass);
	  } catch (Exception ex) {
	      System.out.println(ex.getMessage());
	  }
	 }
	 
	 public static void close() {
	  System.out.println("[MySQL] Verbindung geschlossen.");
	  try {
	      if (connection != null) {
	    	  connection.close();
	      }
	  } catch (Exception ex) {
	      System.out.println(ex.getMessage());
	  }
	 }
	 
	 public static Connection getConnection(){
		    if(connection == null)
		    	connect();
		    return connection;
		}
	 
	 public static void execute(String SQL){
		 PreparedStatement ps;
		 try {
			ps = connection.prepareStatement(SQL);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	 }
	 
}
