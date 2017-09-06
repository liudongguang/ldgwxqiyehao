package com.ldg.pajax.vo;

/**
 * Created by LiuDongguang on 2017/9/6.
 */
public class WX_Response_department{
    private int id;
    private String name;
    private int parentid;
    private long order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "  WX_Response_department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentid=" + parentid +
                ", order=" + order +
                '}';
    }
}
