package model;

import java.io.Serializable;

public class OrderDesc
implements Serializable {
    private Integer po_id;
    private String p_id;
    private Integer quantity;
    private String hist_p_name;
    private Integer hist_price;

    public OrderDesc(Integer po_id) {
        this.po_id = po_id;
        this.p_id = null;
        this.quantity = null;
        this.hist_p_name = null;
        this.hist_price = null;
    }

    public OrderDesc(Integer po_id, String p_id, Integer quantity, String hist_p_name, Integer hist_price) {
        this.po_id = po_id;
        this.p_id = p_id;
        this.quantity = quantity;
        this.hist_p_name = hist_p_name;
        this.hist_price = hist_price;
    }

    public Integer getPo_id() {
        return this.po_id;
    }

    public void setPo_id(Integer po_id) {
        this.po_id = po_id;
    }

    public String getP_id() {
        return this.p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getHist_p_name() {
        return this.hist_p_name;
    }

    public void setHist_p_name(String hist_p_name) {
        this.hist_p_name = hist_p_name;
    }

    public Integer getHist_price() {
        return this.hist_price;
    }

    public void setHist_price(Integer hist_price) {
        this.hist_price = hist_price;
    }
}
