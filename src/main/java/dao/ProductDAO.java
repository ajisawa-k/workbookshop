package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDAO implements DBConfig {
    
    public ProductDAO() {
    }
    
    public List<Product> findAllProducts() {
        Connection conn = null;
        List<Product> productList = new ArrayList<>();
        
        try {
            // Load JDBC driver
            Class.forName(DRIVER_NAME);
            
            // Establish connection
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            
            // Prepare SQL statement
            String sql = "SELECT * FROM product ORDER BY p_id;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            // Execute query
            ResultSet rs = pstmt.executeQuery();
            System.out.println(rs);
            
            // Process results
            while (rs.next()) {
                String p_id = rs.getString("p_id");
                String p_name = rs.getString("p_name");
                Integer price = Integer.valueOf(rs.getInt("price"));
                
                Product product = new Product(p_id, p_name, price);
                productList.add(product);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        
        return productList;
    }
}