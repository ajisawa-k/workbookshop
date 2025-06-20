package model;

import java.io.Serializable;

public class Product implements Serializable {
    private String p_id;
    private String p_name;
    private Integer price;
    
    public Product(String p_id, String p_name, Integer price) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.price = price;
    }
    
    public String getP_id() {
        return p_id;
    }
    
    public void setP_id(String p_id) {
        this.p_id = p_id;
    }
    
    public String getP_name() {
        return p_name;
    }
    
    public void setP_name(String p_name) {
        this.p_name = p_name;
    }
    
    public Integer getPrice() {
        return price;
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }
}