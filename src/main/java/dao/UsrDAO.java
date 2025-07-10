package dao;

import dao.DBConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Usr;

public class UsrDAO
implements DBConfig {
    public List<Usr> findAUsr(Usr usr) {
        Connection conn = null;
        ArrayList<Usr> usrList = new ArrayList<Usr>();
        try {
            try {
                Class.forName(DRIVER_NAME);
                conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                String sql = "SELECT * FROM usr WHERE user_id=? and password=? ;";
                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, usr.getUser_id());
                pStmt.setString(2, usr.getPassword());
                ResultSet rs = pStmt.executeQuery();
                System.out.println(rs);
                while (rs.next()) {
                    String user_id = rs.getString("user_id");
                    String password = rs.getString("password");
                    String l_name = rs.getString("l_name");
                    String f_name = rs.getString("f_name");
                    String l_name_kana = rs.getString("l_name_kana");
                    String f_name_kana = rs.getString("f_name_kana");
                    String prefecture = rs.getString("prefecture");
                    String city = rs.getString("city");
                    String o_address = rs.getString("o_address");
                    String tel = rs.getString("tel");
                    String email = rs.getString("email");
                    System.out.println(user_id + ";" + password + ";" + l_name + ";");
                    Usr usrResult = new Usr(user_id, password, l_name, f_name, l_name_kana, f_name_kana, prefecture, city, o_address, tel, email);
                    usrList.add(usrResult);
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
        return usrList;
    }

    public String getNewID() {
        Connection conn = null;
        String newID = "";
        int cnt = 0;
        LocalDateTime date = LocalDateTime.now();
        newID = date.getMonthValue() < 10 ? "C0" + date.getMonthValue() : "C" + date.getMonthValue();
        Random random = new Random();
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            do {
                int i = 0;
                while (i < 4) {
                    newID = newID + Integer.valueOf(random.nextInt(9)).toString();
                    ++i;
                }
                System.out.println(newID);
                String sql = "SELECT count(*) AS cnt  FROM usr where usr_id=?;";
                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, newID);
                ResultSet rs = pStmt.executeQuery();
                while (rs.next()) {
                    cnt = rs.getInt("cnt");
                }
            } while (cnt > 0);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return newID;
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            return newID;
        }
        return newID;
    }

    public String insertUsr(Usr usr) {
        Connection conn = null;
        String errorStr = "";
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            String sql = "INSERT INTO usr(user_id,password,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, usr.getUser_id());
            pStmt.setString(2, usr.getPassword());
            pStmt.setString(3, usr.getL_name());
            pStmt.setString(4, usr.getF_name());
            pStmt.setString(5, usr.getL_name_kana());
            pStmt.setString(6, usr.getF_name_kana());
            pStmt.setString(7, usr.getPrefecture());
            pStmt.setString(8, usr.getCity());
            pStmt.setString(9, usr.getO_address());
            pStmt.setString(10, usr.getTel());
            pStmt.setString(11, usr.getEmail());
            pStmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            errorStr = "SQL\u30a8\u30e9\u30fc\u3067\u3059\u3002";
            return errorStr;
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            errorStr = "\u30c7\u30fc\u30bf\u30d9\u30fc\u30b9\u30a8\u30e9\u30fc\u3067\u3059\u3002";
            return errorStr;
        }
        return errorStr;
    }
}
