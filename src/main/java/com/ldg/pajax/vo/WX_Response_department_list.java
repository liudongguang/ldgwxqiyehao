package com.ldg.pajax.vo;

import java.util.List;

/**
 * Created by LiuDongguang on 2017/9/6.
 */
public class WX_Response_department_list extends WX_Response_Base{
   private List<WX_Response_department> department;

    public List<WX_Response_department> getDepartment() {
        return department;
    }

    public void setDepartment(List<WX_Response_department> department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return super.toString()+"  WX_Response_department_list{" +
                "department=" + department +
                '}';
    }
}
