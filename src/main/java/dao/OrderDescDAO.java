package dao;

import dao.DBConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.OrderDesc;

public class OrderDescDAO
implements DBConfig {
    public OrderDesc create(OrderDesc orderDesc) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost/workbookshop", "root", "insource.2015it");
            String sql = "INSERT INTO order_desc (po_id,p_id,quantity,hist_p_name,hist_price) VALUES (?,?,?,?,?);";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, orderDesc.getPo_id());
            pStmt.setString(2, orderDesc.getP_id());
            pStmt.setInt(3, orderDesc.getQuantity());
            pStmt.setString(4, orderDesc.getHist_p_name());
            pStmt.setInt(5, orderDesc.getHist_price());
            System.out.println(pStmt.executeUpdate());
            pStmt.close();
            OrderDesc orderDesc2 = orderDesc;
            return orderDesc2;
        }
        catch (SQLException e) {
            e.printStackTrace();
            OrderDesc orderDesc3 = orderDesc;
            return orderDesc3;
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                    return orderDesc;
                }
            }
        }
    }

    public List<OrderDesc> selectByPo_id(Integer po_id) {
        Connection conn = null;
        ArrayList<OrderDesc> orderDescList = new ArrayList<OrderDesc>();
        try {
            try {
                conn = DriverManager.getConnection("jdbc:mariadb://localhost/workbookshop", "root", "insource.2015it");
                String sql = "SELECT * FROM order_desc WHERE po_id=?";
                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setInt(1, po_id);
                ResultSet rs = pStmt.executeQuery();
                System.out.println(rs);
                while (rs.next()) {
                    po_id = rs.getInt("po_id");
                    String p_id = rs.getString("p_id");
                    Integer quantity = rs.getInt("quantity");
                    String hist_p_name = rs.getString("hist_p_name");
                    Integer hist_price = rs.getInt("hist_price");
                    OrderDesc orderDescResult = new OrderDesc(po_id, p_id, quantity, hist_p_name, hist_price);
                    orderDescList.add(orderDescResult);
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
        return orderDescList;
    }
}
