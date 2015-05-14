package utility.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class MyDatabase
{
   private String driver = "com.mysql.jdbc.Driver";
   private String url = "jdbc:mysql://localhost/";
   private String user = "root";
   private String pw = "";
   private boolean isDebugMode = false;
   private Connection connection;
   private boolean isOpen;

   public MyDatabase(String driver, String url, String user, String pw)
   {
      this.driver = driver;
      this.url = url;
      this.user = user;
      this.pw = pw;
      connection = null;
      isOpen = false;
   }

   public MyDatabase(String databaseName, String user, String pw)
   {
      this.url = url + databaseName;
      this.user = user;
      this.pw = pw;
      connection = null;
      isOpen = false;
   }

   public MyDatabase(String databaseName)
   {
      this.url = url + databaseName;
      connection = null;
      isOpen = false;
   }

   public boolean openDatabase()
   {
      if (isOpen)
      {
         return true;
      }
      try
      {
         Class.forName(driver);
         connection = DriverManager.getConnection(url, user, pw);
         isOpen = true;
         return true;
      }
      catch (Exception e)
      {
         if (isDebugMode)
         {
            System.out.println("MyDatabase: DEBUG");
            System.out.flush();
            e.printStackTrace();
         }
         return false;
      }
   }

   public boolean closeDatabase()
   {
      try
      {
         isOpen = false;
         if (connection != null)
            connection.close();
         return true;
      }
      catch (Exception e)
      {
         if (isDebugMode)
         {
            System.out.println("MyDatabase: DEBUG");
            System.out.flush();
            e.printStackTrace();
         }
         return false;
      }
   }

   public ArrayList<Object[]> query(String sql)
   {
      boolean justOpened = false;
      if (!isOpen)
      {
         isOpen = openDatabase();
         justOpened = true;
      }
      ArrayList<Object[]> list = null;
      Statement statement = null;
      ResultSet resultSet = null;
      try
      {
         statement = connection.createStatement();
         resultSet = statement.executeQuery(sql);
         list = new ArrayList<Object[]>();
         while (resultSet.next())
         {
            Object[] elements = new Object[resultSet.getMetaData()
                  .getColumnCount()];
            for (int i = 0; i < elements.length; i++)
            {
               elements[i] = resultSet.getObject(i + 1);
            }
            list.add(elements);
         }
         if (resultSet != null)
            resultSet.close();
         if (statement != null)
            statement.close();
      }
      catch (Exception e)
      {
         if (isDebugMode)
         {
            System.out.println("MyDatabase: DEBUG");
            System.out.flush();
            e.printStackTrace();
         }
      }
      if (justOpened)
      {
         closeDatabase();
      }
      return list;
   }

   public int update(String sql, Object... statementElements)
         throws SQLException
   {
      openDatabase();
      PreparedStatement statement = null;
      statement = connection.prepareStatement(sql);

      for (int i = 0; i < statementElements.length; i++)
      {

         statement.setObject(i + 1, statementElements[i]);

      }

      int updates = statement.executeUpdate();
      System.out.println("Number of update= " + updates);

      closeDatabase();

      return updates;
   }

   public int update(String sql)
   {
      boolean justOpened = false;
      if (!isOpen)
      {
         isOpen = openDatabase();
         justOpened = true;
      }
      Statement statement = null;
      int result = 0;
      try
      {
         statement = connection.createStatement();
         result = statement.executeUpdate(sql);
      }
      catch (Exception e)
      {
         if (isDebugMode)
         {
            System.out.println("MyDatabase: DEBUG");
            System.out.flush();
            e.printStackTrace();
         }
      }
      if (justOpened)
      {
         closeDatabase();
      }
      return result;
   }

   public int[] updateAll(ArrayList<String> sqlList)
   {
      if (sqlList == null)
         return null;
      int[] results = new int[sqlList.size()];
      for (int i = 0; i < sqlList.size(); i++)
      {
         results[i] = update(sqlList.get(i));
      }
      return results;
   }

   public int[] updateAll(String fileName)
   {
      ArrayList<String> sqlList = readFile(fileName);
      return updateAll(sqlList);
   }

   public void setDebugMode(boolean isDebugMode)
   {
      this.isDebugMode = isDebugMode;
   }

   private ArrayList<String> readFile(String filename)
   {
      Scanner input = null;
      String path = new File(filename).getAbsolutePath();
      try
      {
         FileInputStream fileIn = new FileInputStream(filename);
         input = new Scanner(fileIn);
      }
      catch (FileNotFoundException e)
      {
         if (isDebugMode)
         {
            System.out.println("MyDatabase: DEBUG");
            System.out.println("Cannot open file: \"" + path + "\" ");
            System.out.flush();
            e.printStackTrace();
         }
         return null;
      }

      ArrayList<String> list = new ArrayList<String>();
      while (input.hasNext())
      {
         list.add(input.nextLine());
      }
      input.close();
      return list;
   }
}
