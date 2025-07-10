package dao;

import dao.DBConfig;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.OrderMain;
import model.Usr;

public class OrderMainDAO
implements DBConfig {
    public OrderMain create(OrderMain orderMain) {
        Connection conn = null;
        Integer po_id = null;
        try {
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            String sql = "INSERT INTO order_main(user_id,order_date,delivery_date) VALUES (?,CURRENT_DATE,null);";
            PreparedStatement pStmt = conn.prepareStatement(sql, 1);
            pStmt.setString(1, orderMain.getUser_id());
            System.out.println(pStmt.executeUpdate());
            ResultSet rs = pStmt.getGeneratedKeys();
            while (rs.next()) {
                BigDecimal idColVar = rs.getBigDecimal(1);
                po_id = idColVar.intValue();
            }
            rs.close();
            pStmt.close();
            orderMain.setPo_id(po_id);
            OrderMain orderMain2 = orderMain;
            return orderMain2;
        }
        catch (SQLException e) {
            e.printStackTrace();
            OrderMain orderMain3 = orderMain;
            return orderMain3;
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                    return orderMain;
                }
            }
        }
    }

    public List<OrderMain> findAllByUserId(Usr loginUsr) {
        Connection conn = null;
        ArrayList<OrderMain> orderMainList = new ArrayList<OrderMain>();
        try {
            try {
                Class.forName(DRIVER_NAME);
                conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                String sql = "SELECT * FROM order_main WHERE user_id=? ORDER BY order_date DESC;";
                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, loginUsr.getUser_id());
                ResultSet rs = pStmt.executeQuery();
                System.out.println(rs);
                while (rs.next()) {
                    Integer po_id = rs.getInt("po_id");
                    String user_id = rs.getString("user_id");
                    String order_date = rs.getString("order_date");
                    String delivery_date = rs.getString("delivery_date");
                    OrderMain orderMainResult = new OrderMain(po_id, user_id, order_date, delivery_date);
                    orderMainList.add(orderMainResult);
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
                if (conn != null) {
                    try {
                        conn.close();
                    }
                    catch (SQLException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
            catch (ClassNotFoundException e) {
                block19: {
                    e.printStackTrace();
                    if (conn == null) break block19;
                    try {
                        conn.close();
                    }
                    catch (SQLException e3) {
                        e3.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return orderMainList;
    }

    public List<OrderMain> selectByPoId(Integer po_id) {
        Connection conn = null;
        ArrayList<OrderMain> orderMainList = new ArrayList<OrderMain>();
        try {
            try {
                Class.forName(DRIVER_NAME);
                conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                String sql = "SELECT * FROM order_main WHERE po_id=?;";
                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setInt(1, po_id);
                ResultSet rs = pStmt.executeQuery();
                System.out.println(rs);
                while (rs.next()) {
                    po_id = rs.getInt("po_id");
                    String user_id = rs.getString("user_id");
                    String order_date = rs.getString("order_date");
                    String delivery_date = rs.getString("delivery_date");
                    OrderMain orderMainResult = new OrderMain(po_id, user_id, order_date, delivery_date);
                    orderMainList.add(orderMainResult);
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
                if (conn != null) {
                    try {
                        conn.close();
                    }
                    catch (SQLException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
            catch (ClassNotFoundException e) {
                block19: {
                    e.printStackTrace();
                    if (conn == null) break block19;
                    try {
                        conn.close();
                    }
                    catch (SQLException e3) {
                        e3.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return orderMainList;
    }
}
