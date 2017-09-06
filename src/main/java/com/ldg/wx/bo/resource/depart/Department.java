package com.ldg.wx.bo.resource.depart;

/**
 * Created by LiuDongguang on 2017/8/3.
 */
public class Department {
    private String id;
    private String name;
    private String parentid;
    private String order;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", parentid='" + parentid + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
