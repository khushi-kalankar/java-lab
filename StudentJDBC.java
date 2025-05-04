import java.sql.*;
import java.util.Scanner;

public class StudentJDBC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        PreparedStatement insertStmt = null;
        Statement selectStmt = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/StudentDB";  // Change port/db if needed
        String user = "root";       // Replace with your DB username
        String password = "root";   // Replace with your DB password

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database.");

            // Insert student
            System.out.print("Enter Roll No: ");
            int rno = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            String insertSQL = "INSERT INTO students (rno, name) VALUES (?, ?)";
            insertStmt = con.prepareStatement(insertSQL);
            insertStmt.setInt(1, rno);
            insertStmt.setString(2, name);
            insertStmt.executeUpdate();
            System.out.println("Record inserted successfully.");

            // Retrieve and display all students
            String selectSQL = "SELECT * FROM students";
            selectStmt = con.createStatement();
            rs = selectStmt.executeQuery(selectSQL);

            System.out.println("\nStudent Records:");
            while (rs.next()) {
                System.out.println("Roll No: " + rs.getInt("rno") + ", Name: " + rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (insertStmt != null) insertStmt.close(); } catch (Exception e) {}
            try { if (selectStmt != null) selectStmt.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
}
