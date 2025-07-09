package model;

import java.io.Serializable;

public class OrderMain
implements Serializable {
    private Integer po_id;
    private String user_id;
    private String order_date;
    private String delivery_date;

    public OrderMain(String user_id) {
        this.po_id = null;
        this.user_id = user_id;
        this.order_date = null;
        this.delivery_date = null;
    }

    public OrderMain(Integer po_id, String user_id, String order_date, String delivery_date) {
        this.po_id = po_id;
        this.user_id = user_id;
        this.order_date = order_date;
        this.delivery_date = delivery_date;
    }

    public Integer getPo_id() {
        return this.po_id;
    }

    public void setPo_id(Integer po_id) {
        this.po_id = po_id;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOrder_date() {
        return this.order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getDelivery_date() {
        return this.delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }
}
