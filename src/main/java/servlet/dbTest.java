package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(value={"/dbTest"})
public class dbTest
extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        block30: {
            Connection conn = null;
            Statement stmt = null;
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                System.out.print("Connecting to DB...");
                conn = DriverManager.getConnection("jdbc:mariadb://localhost/mysql", "root", "");
                System.out.println("done.");
                stmt = conn.createStatement();
                String sql = "SELECT user, host from mysql.user";
                ResultSet hrs = stmt.executeQuery(sql);
                while (hrs.next()) {
                    String user = hrs.getString(1);
                    String host = hrs.getString(2);
                    System.out.println("User: " + user + " Host: " + host);
                }
            }
            catch (SQLException se) {
                se.printStackTrace();
                System.out.println("error1");
                try {
                    if (stmt != null) {
                        conn.close();
                    }
                }
                catch (SQLException sQLException) {
                    // empty catch block
                }
                try {
                    if (conn != null) {
                        conn.close();
                    }
                    break block30;
                }
                catch (SQLException se2) {
                    se2.printStackTrace();
                    System.out.println("error3");
                }
                break block30;
            }
            catch (Exception e) {
                try {
                    e.printStackTrace();
                    System.out.println("error2");
                    break block30;
                }
                catch (Throwable throwable) {
                    throw throwable;
                }
                finally {
                    try {
                        if (stmt != null) {
                            conn.close();
                        }
                    }
                    catch (SQLException se2) {}
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    }
                    catch (SQLException se) {
                        se.printStackTrace();
                        System.out.println("error3");
                    }
                }
            }
            try {
                if (stmt != null) {
                    conn.close();
                }
            }
            catch (SQLException se) {
                // empty catch block
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            }
            catch (SQLException se) {
                se.printStackTrace();
                System.out.println("error3");
            }
        }
        System.out.println("Good bye!");
    }
}
