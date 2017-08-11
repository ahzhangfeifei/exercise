package com.core.java.v2.v2ch04. test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

/**
 * The type Test db.
 */
public class TestDB
{
   /**
    * Main.
    *
    * @param args the args
    * @throws IOException the io exception
    */
   public static void main(String args[]) throws IOException
   {
      try
      {
         runTest();
      }
      catch (SQLException ex)
      {
         for (Throwable t : ex)
            t.printStackTrace();
      }
   }

   /**
    * Run test.
    *
    * @throws SQLException the sql exception
    * @throws IOException  the io exception
    */
   public static void runTest() throws SQLException, IOException
   {
      
      try (Connection conn = getConnection())
      {
         Statement stat = conn.createStatement();

         stat.executeUpdate("CREATE TABLE Greetings (Message CHAR(20))");
         stat.executeUpdate("INSERT INTO Greetings VALUES ('Hello, World!')");

         try (ResultSet result = stat.executeQuery("SELECT * FROM Greetings"))
         {
            if (result.next())
               System.out.println(result.getString(1));
         }
         stat.executeUpdate("DROP TABLE Greetings");
      }
   }

   /**
    * Gets connection.
    *
    * @return the connection
    * @throws SQLException the sql exception
    * @throws IOException  the io exception
    */
   public static Connection getConnection() throws SQLException, IOException
   {
      Properties props = new Properties();
      try (InputStream in = Files.newInputStream(Paths.get("database.properties")))
      {
         props.load(in);
      }
      String drivers = props.getProperty("jdbc.drivers");
      if (drivers != null) System.setProperty("jdbc.drivers", drivers);
      String url = props.getProperty("jdbc.url");
      String username = props.getProperty("jdbc.username");
      String password = props.getProperty("jdbc.password");

      return DriverManager.getConnection(url, username, password);
   }
}
