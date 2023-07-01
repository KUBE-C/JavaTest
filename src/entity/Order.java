package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    private int orderid;//订单号
    private String recipient;//收件人
    private String customer;
    private String dishes;
    private Float sum;//订单总金额
    private String address;//地址
    private String phone;//电话
    private String time;//下单时间
    private String ispay;//是否支付
    private String issend;//是否配送
    private String isrecieve;//是否到货

    public Order() {
        // TODO Auto-generated constructor stub
    }
    public Order(int orderid,String customer,String recipient,String dishes,float sum,String address,String phone,String ispay,String time,String issend, String isrecieve){
        this.orderid = orderid;
        this.customer = customer;
        this.recipient = recipient;
        this.dishes=dishes;
        this.sum = sum;
        this.address = address;
        this.phone = phone;
        this.ispay = ispay;
        this.time = time;
        this.issend = issend;
        this.isrecieve = isrecieve;
    }

    public String getDishes() {
        return dishes;
    }

    public void setDishes(String dishes) {
        this.dishes = dishes;
    }
    public void setDish(String name, String count) {
        String dish = name + "x" + count;
        if (this.dishes == null) {
            this.dishes = dish;
        } else {
            this.dishes += ", " + dish;
        }
    }

    public int getOrderid() {
         return orderid;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getTime() {
        return time;
    }

    public Float getSum() {
        return sum;
    }

    public String getAddress() {
        return address;
    }

    public String getIspay() {
        return ispay;
    }

    public String getIsrecieve() {
        return isrecieve;
    }

    public String getIssend() {
        return issend;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIspay(String ispay) {
        this.ispay = ispay;
    }

    public void setIsrecieve(String isrecieve) {
        this.isrecieve = isrecieve;
    }

    public void setIssend(String issend) {
        this.issend = issend;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }
}
