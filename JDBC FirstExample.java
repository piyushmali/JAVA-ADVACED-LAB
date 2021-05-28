import java.sql.*;

public class FirstExample {
   static final String DB_URL = "jdbc:mysql://localhost:3306/mydata";
   static final String USER = "root";
   static final String PASS = "Piyus@12";
   static final String QUERY = "SELECT id, first, last, age FROM Employees";

   public static void main(String[] args) {
     
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
         while (rs.next()) {
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Age: " + rs.getInt("age"));
            System.out.print(", First: " + rs.getString("first"));
            System.out.println(", Last: " + rs.getString("last"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}


/* Output:
Connecting to database...
Creating statement...
ID: 100, Age: 20, First: Piyush, Last: Mali
ID: 101, Age: 21, First: Raghav, Last: Sood
ID: 102, Age: 19, First: Pranjal, Last: Parmar
ID: 103, Age: 21, First: Prateek, Last: Luhadiya*/
