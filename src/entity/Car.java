package entity;

/**
 * 购物车的每一项，每一条商品数据
 * @author zjjt
 *
 *通过继承来继承Goods的所有属性  extends Goods
 */
public class Car {
    private String customer;
    private int dishid;
    private String dishname;
    private String dishkind;
         private int count; //数量
         private float sum; //条目总价
    private float price;//单价

    public Car() {
        //
    }


    public Car(String customer,int dishid, String dishname, String dishkind, int count, float sum, float price) {
        this.customer = customer;
        this.dishid = dishid;
        this.dishname = dishname;
        this.dishkind = dishkind;
        this.count = count;
        this.sum = sum;
        this.price = price;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDishid() {
        return dishid;
    }

    public void setDishid(int dishid) {
        this.dishid = dishid;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public String getDishkind() {
        return dishkind;
    }

    public void setDishkind(String dishkind) {
        this.dishkind = dishkind;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }


}
