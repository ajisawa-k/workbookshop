package model;

public class Cart {
    private String p_id;
    private String p_name;
    private Integer price;
    private Integer count;
    
    public Cart(String p_id, String p_name, Integer price, Integer count) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.price = price;
        this.count = count;
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
    
    public Integer getCount() {
        return count;
    }
    
    public void setCount(Integer count) {
        this.count = count;
    }
}