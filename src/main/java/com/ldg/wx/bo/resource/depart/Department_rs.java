package com.ldg.wx.bo.resource.depart;

import java.util.List;

/**
 * Created by LiuDongguang on 2017/8/3.
 */
public class Department_rs {
    private int errcode;
    private String errmsg;
    private List<Department> department;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Department_rs{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", department=" + department +
                '}';
    }
}
