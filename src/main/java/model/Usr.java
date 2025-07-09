package model;

import java.io.Serializable;

public class Usr
implements Serializable {
    private String user_id;
    private String password;
    private String l_name;
    private String f_name;
    private String l_name_kana;
    private String f_name_kana;
    private String prefecture;
    private String city;
    private String o_address;
    private String tel;
    private String email;

    public Usr() {
        this.user_id = "";
        this.password = "";
        this.l_name = "";
        this.f_name = "";
        this.l_name_kana = "";
        this.f_name_kana = "";
        this.prefecture = "";
        this.city = "";
        this.o_address = "";
        this.tel = "";
        this.email = "";
    }

    public Usr(String user_id, String password) {
        this.user_id = user_id;
        this.password = password;
        this.l_name = "";
        this.f_name = "";
        this.l_name_kana = "";
        this.f_name_kana = "";
        this.prefecture = "";
        this.city = "";
        this.o_address = "";
        this.tel = "";
        this.email = "";
    }

    public Usr(String user_id, String password, String l_name, String f_name, String l_name_kana, String f_name_kana, String prefecture, String city, String o_address, String tel, String email) {
        this.user_id = user_id;
        this.password = password;
        this.l_name = l_name;
        this.f_name = f_name;
        this.l_name_kana = l_name_kana;
        this.f_name_kana = f_name_kana;
        this.prefecture = prefecture;
        this.city = city;
        this.o_address = o_address;
        this.tel = tel;
        this.email = email;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getL_name() {
        return this.l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getF_name() {
        return this.f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name_kana() {
        return this.l_name_kana;
    }

    public void setL_name_kana(String l_name_kana) {
        this.l_name_kana = l_name_kana;
    }

    public String getF_name_kana() {
        return this.f_name_kana;
    }

    public void setF_name_kana(String f_name_kana) {
        this.f_name_kana = f_name_kana;
    }

    public String getPrefecture() {
        return this.prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getO_address() {
        return this.o_address;
    }

    public void setO_address(String o_address) {
        this.o_address = o_address;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
