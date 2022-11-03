package com.myapplication.Screens;

public class MyCompanyModel {
    String order_id;
    String company_name;

    public MyCompanyModel(String order_id, String company_name) {
        this.company_name = company_name;
        this.order_id = order_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}
